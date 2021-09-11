package io.github.caio.grpc;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.*;


public class ClientServer implements MqttCallback{

    private static final Logger logger = Logger.getLogger(ClientServer.class.getName());

    private int port = 42420;
    private Server server;


    private void start() throws Exception {
        logger.info("Starting the grpc server");

        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();

        logger.info("Server started. Listening on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** JVM is shutting down. Turning off grpc server as well ***");
            ClientServer.this.stop();
            System.err.println("*** shutdown complete ***");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    BigInteger cid = BigInteger.valueOf(123);
    static ArrayList<Usuario> lista = new ArrayList<>();
    static MqttClient cliente;
    public static void main(String[] args) throws Exception {


        String brokerUrl = "tcp://localhost:1883";
        ClientServer c = new ClientServer();
        cliente = new MqttClient(brokerUrl, "ServerClient");
        cliente.setCallback(c);
        cliente.connect();
        cliente.subscribe("users", 0);

        lista.add(new Usuario(BigInteger.valueOf(123), "enrich"));
        logger.info("Server startup. Args = " + Arrays.toString(args));
        final ClientServer helloWorldServer = new ClientServer();
        helloWorldServer.start();
        helloWorldServer.blockUntilShutdown();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        lista = (ArrayList<Usuario>) new Gson().fromJson(mqttMessage.toString(), new TypeToken<ArrayList<Usuario>>(){}.getType());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

    private void publicaTarefas()
    {
        String json = new Gson().toJson(lista);
        MqttMessage msg = new MqttMessage(json.getBytes());
        try {
            cliente.publish("tarefas", msg);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void login(LoginRequest request, StreamObserver<GenResponse> responseObserver){
            GenResponse response = GenResponse.newBuilder().setRet("1").build();
            for (Usuario u: lista)
            {
                if (cid.equals(BigInteger.valueOf(Long.parseLong(request.getCid())))){
                    response = GenResponse.newBuilder().setRet("0").build();
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void cTarefa(CTarefaRequest request, StreamObserver<GenResponse> responseObserver){
            GenResponse response = GenResponse.newBuilder().setRet("1").build();
            for (Usuario u: lista)
            {
                if (cid.equals(BigInteger.valueOf(Long.parseLong(request.getCid())))){
                    response = GenResponse.newBuilder().setRet("0").build();
                    Tarefa t = new Tarefa(request.getNome(), request.getDesc());
                    u.addTarefa(t);
                    publicaTarefas();
                    break;
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void rTarefa(RTarefaRequest request, StreamObserver<GenResponse> responseObserver){
            GenResponse response = GenResponse.newBuilder().setRet("1").build();
            String tarefas = "";
            for (Usuario u: lista)
            {
                if (cid.equals(BigInteger.valueOf(Long.parseLong(request.getCid())))){
                    for (Tarefa t: u.getTarefas())
                    {
                        tarefas = tarefas.concat(t.toString()).concat("\n");
                    }
                    response = GenResponse.newBuilder().setRet(tarefas).build();
                    break;
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void uTarefa(CTarefaRequest request, StreamObserver<GenResponse> responseObserver){
            GenResponse response = GenResponse.newBuilder().setRet("1").build();
            for (Usuario u: lista)
            {
                if (cid.equals(BigInteger.valueOf(Long.parseLong(request.getCid())))){
                    for (Tarefa t: u.getTarefas())
                    {
                        if (t.getTitulo().equals(request.getNome()))
                        {
                            Tarefa tarefa = t;
                            u.removeTarefa(t);
                            tarefa.setDescricao(request.getDesc());
                            u.addTarefa(tarefa);
                            response = GenResponse.newBuilder().setRet("0").build();
                            publicaTarefas();
                        }
                        break;
                    }
                    break;
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        @Override
        public void dTarefa(CTarefaRequest request, StreamObserver<GenResponse> responseObserver){
            GenResponse response = GenResponse.newBuilder().setRet("1").build();
            for (Usuario u: lista)
            {
                if (cid.equals(BigInteger.valueOf(Long.parseLong(request.getCid())))){
                    for (Tarefa t: u.getTarefas())
                    {
                        if (t.getTitulo().equals(request.getNome()))
                        {
                            u.removeTarefa(t);
                            response = GenResponse.newBuilder().setRet("0").build();
                            publicaTarefas();
                        }
                        break;
                    }
                    break;
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

    }
}
