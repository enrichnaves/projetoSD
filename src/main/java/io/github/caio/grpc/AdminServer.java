package io.github.caio.grpc;

import com.google.common.reflect.TypeToInstanceMap;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.*;

import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AdminServer implements MqttCallback {
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static MqttClient cliente;
    public static void main(String[] args) {

        String brokerUrl = "tcp://localhost:1883";
        try {
            cliente = new MqttClient(brokerUrl, "ServerAdmin");
            AdminServer c = new AdminServer();
            cliente.setCallback(c);
            cliente.connect();
            cliente.subscribe("tarefas", 0);

        } catch (MqttException e) {
            e.printStackTrace();
        }
        try {
            ServerSocket servidor = new ServerSocket(7000);
            while(true)
            {
                AtendeAdmin ad = new AtendeAdmin(servidor.accept());
                ad.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void publicaUsuarios()
    {
        String json = new Gson().toJson(listaUsuarios);
        MqttMessage msg = new MqttMessage(json.getBytes());
        try {
            cliente.publish("users", msg);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        listaUsuarios = (ArrayList<Usuario>) new Gson().fromJson(message.toString(), new TypeToken<ArrayList<Usuario>>(){}.getType());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }
}
