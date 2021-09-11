package io.github.caio.grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientGRPC {
    private static final Logger logger = Logger.getLogger(ClientGRPC.class.getName());

    private final ManagedChannel channel;
    private GreeterGrpc.GreeterBlockingStub blockingStub;

    public ClientGRPC(String hostname, int port) {
        channel = ManagedChannelBuilder.forAddress(hostname, port)
                .usePlaintext(true)
                .build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public static void main(String[] args) throws Exception {
        ClientGRPC client = new ClientGRPC("localhost", 42420);
        Scanner teclado = new Scanner(System.in);
        int retorno, op;
        String CID;
        do{
            System.out.println("informe o CID:");
            CID = teclado.nextLine();
            retorno = client.login(CID);
            if(retorno !=0){
                System.out.println("CID não encontrado. Tente novamente!");
            }
            else{
                System.out.println("Logado");
            }
        }while(retorno!=0);
        String tit, desc;
        do{
            System.out.println("O que deseja fazer?");
            System.out.println("1-Criar tarefa");
            System.out.println("2-Ver tarefas");
            System.out.println("3-Atualizar tarefa");
            System.out.println("4-Deletar tarefa");
            System.out.println("0-Sair");
            op = Integer.parseInt(teclado.nextLine());
            switch(op)
            {
                case 0:
                    break;
                case 1:
                    System.out.println("Informe o titulo da tarefa");
                    tit = teclado.nextLine();
                    System.out.println("Informe a descricao da tarefa");
                    desc = teclado.nextLine();
                    if (client.cTarefa(CID, tit, desc)==0)
                    {
                        System.out.println("Tarefa criada");
                    }else
                    {
                        System.out.println("Tarefa com o mesmo nome ja existe. Não foi criada.");
                    }
                    break;
                case 2:
                    System.out.println("Tarefas: ");
                    System.out.println(client.rTarefa(CID));
                    break;
                case 3:
                    System.out.println("Qual titulo da tarefa que deseja atualizar?");
                    tit = teclado.nextLine();
                    System.out.println("Qual a nova descrição da tarefa?");
                    desc = teclado.nextLine();
                    if (client.aTarefa(CID, tit, desc)==0)
                    {
                        System.out.println("Tarefa atualizada");
                    }else
                    {
                        System.out.println("Tarefa com o mesmo nome não existe. Não foi atualizada.");
                    }
                    break;
                case 4:
                    System.out.println("Qual titulo da tarefa que deseja deletar?");
                    tit = teclado.nextLine();
                    if (client.dTarefa(CID, tit)==0)
                    {
                        System.out.println("Tarefa deletada");
                    }else
                    {
                        System.out.println("Tarefa com o mesmo nome não existe. Não foi deletada.");
                    }
                    break;
                default:
                    System.out.println("OP invalida");
                    break;
            }
        }while(op!=0);
        client.shutdown();
    }

    private int login(String CID)
    {
        try{
            LoginRequest request = LoginRequest.newBuilder().setCid(CID).build();
            GenResponse response = blockingStub.login(request);
            if (response.getRet().equals("0")){
                return 0;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 1;
    }
    private int cTarefa(String CID, String nome, String desc)
    {
        try{
            CTarefaRequest request = CTarefaRequest.newBuilder().setCid(CID).setNome(nome).setDesc(desc).build();
            GenResponse response = blockingStub.cTarefa(request);
            if (response.getRet().equals("0")){
                return 0;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 1;
    }
    private String rTarefa(String CID)
    {
        try{
            RTarefaRequest request = RTarefaRequest.newBuilder().setCid(CID).build();
            GenResponse response = blockingStub.rTarefa(request);
            if (response.getRet().equals("1")){
                return "1";
            }else
            {
                return response.getRet();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "1";
    }
    private int aTarefa(String CID, String nome, String desc)
    {
        try{
            CTarefaRequest request = CTarefaRequest.newBuilder().setCid(CID).setNome(nome).setDesc(desc).build();
            GenResponse response = blockingStub.uTarefa(request);
            if (response.getRet().equals("0")){
                return 0;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 1;
    }
    private int dTarefa(String CID, String nome)
    {
        try{
            CTarefaRequest request = CTarefaRequest.newBuilder().setCid(CID).setNome(nome).build();
            GenResponse response = blockingStub.dTarefa(request);
            if (response.getRet().equals("0")){
                return 0;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 1;
    }
}
