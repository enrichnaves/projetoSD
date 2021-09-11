package io.github.caio.grpc;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Scanner;

public class ClientAdmin {
    public static void main(String[] args) {
        Socket cliente = null;
        try {
            cliente = new Socket("127.0.0.1", 7000);
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream chegada = new ObjectInputStream(cliente.getInputStream());
            Scanner entrada = new Scanner(System.in);
            String msg="";
            Mensagem mensagem;
            //fazer login do admin
            do{
                System.out.println("digite a senha de administrador:");
                msg = entrada.nextLine();
                mensagem = new Mensagem(0, 1, msg);
                saida.writeObject(mensagem);
                mensagem = (Mensagem) chegada.readObject();
                if (mensagem.retorno!=0){
                    System.out.println("senha incorreta, tente novamente");
                }
            }while(mensagem.retorno!=0);
            int op=0;
            do{
                System.out.println("1-Criar usuario");
                System.out.println("2-Ver dados do usuario");
                System.out.println("3-Atualizar usuario");
                System.out.println("4-Deletar usuario");
                System.out.println("0-Sair");
                op = Integer.parseInt(entrada.nextLine());
                switch(op)
                {
                    case 0:
                        break;
                    case 1:
                        do{
                            mensagem.op=1;
                            mensagem.retorno=1;
                            System.out.println("Informe o CID numérico: ");
                            mensagem.cid = new BigInteger(entrada.nextLine());
                            System.out.println("Informe o nome: ");
                            mensagem.nome=entrada.nextLine();
                            saida.writeObject(mensagem);
                            mensagem = (Mensagem) chegada.readObject();
                            if(mensagem.retorno!=0)
                            {
                                System.out.println("CID ja existente");
                            }else{
                                System.out.println("Usuario cadastrado");
                            }
                        }while(mensagem.retorno!=0);
                        break;
                    case 2:
                        mensagem.op=2;
                        mensagem.retorno=1;
                        System.out.println("Informe o CID:");
                        mensagem.cid = new BigInteger(entrada.nextLine());
                        saida.writeObject(mensagem);
                        mensagem = (Mensagem) chegada.readObject();
                        if(mensagem.retorno==0)
                        {
                            System.out.println("Cliente encontrado:");
                            System.out.println(mensagem.msg);
                        }else {
                            System.out.println("Cliente não encontrado digite outro CID");
                        }
                        break;
                    case 3:
                        mensagem.op=3;
                        mensagem.retorno=1;
                        System.out.println("Informe o CID:");
                        mensagem.cid = new BigInteger(entrada.nextLine());
                        System.out.println("Informe o novo nome:");
                        mensagem.nome=entrada.nextLine();
                        saida.writeObject(mensagem);
                        mensagem = (Mensagem) chegada.readObject();
                        if(mensagem.retorno==0)
                        {
                            System.out.println("Cliente encontrado e modificado");
                        }else {
                            System.out.println("Cliente não encontrado digite outro CID");
                        }
                        break;
                    case 4:
                        mensagem.op=4;
                        mensagem.retorno=1;
                        System.out.println("Informe o CID:");
                        mensagem.cid = new BigInteger(entrada.nextLine());
                        saida.writeObject(mensagem);
                        mensagem = (Mensagem) chegada.readObject();
                        if(mensagem.retorno==0)
                        {
                            System.out.println("Cliente encontrado e excluido");
                        }else {
                            System.out.println("Cliente não encontrado digite outro CID");
                        }
                        break;
                    default:
                        System.out.println("OP invalida");
                        break;
                }
            }while(op!=0);
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
