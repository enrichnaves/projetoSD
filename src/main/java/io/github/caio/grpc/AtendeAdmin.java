package io.github.caio.grpc;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AtendeAdmin extends Thread{
    private Socket cliente;

    AtendeAdmin(Socket cliente){
        this.cliente = cliente;
    }

    public void run()
    {
        try{
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            Mensagem objeto;
            do{
                objeto = (Mensagem) entrada.readObject();
                switch(objeto.op){
                    case -1:
                        break;
                    case 0:
                        objeto = login(objeto);
                        break;
                    case 1:
                        objeto = create(objeto);
                        break;
                    case 2:
                        objeto = read(objeto);
                        break;
                    case 3:
                        objeto = update(objeto);
                        break;
                    case 4:
                        objeto = delete(objeto);
                        break;
                }
                saida.writeObject(objeto);
            }while(objeto.op!=-1);


        } catch (Exception e)
        {
            e.printStackTrace();
        }


        /*
        try {
            chegada = new Scanner(cliente.getInputStream());
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            while(chegada.hasNextLine())
            {
                resposta = chegada.nextLine();
                saida.println(msg);
            }

            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
    }

    private Mensagem login(Mensagem m)
    {
        if(m.msg.equals("senha")){
            m.retorno=0;
        }
        else
        {
            m.retorno=1;
        }
        return m;
    }

    private Mensagem create(Mensagem m)
    {
        for(Usuario u:AdminServer.listaUsuarios)
        {
            if(u.getCID().equals(m.cid))
            {
                m.retorno=1;
                AdminServer.publicaUsuarios();
                return m;
            }
        }
        AdminServer.listaUsuarios.add(new Usuario(m.cid, m.nome));
        m.retorno=0;
        return m;
    }

    private Mensagem read(Mensagem m)
    {
        m.msg="";
        for(Usuario u:AdminServer.listaUsuarios)
        {
            if(u.getCID().equals(m.cid))
            {
                m.msg=u.toString();
                m.retorno=0;
                break;
            }
        }
        return m;
    }

    private Mensagem update(Mensagem m)
    {
        Usuario user;
        for(Usuario u:AdminServer.listaUsuarios)
        {
            if(u.getCID().equals(m.cid))
            {
                user = u;
                AdminServer.listaUsuarios.remove(u);
                user.setNome(m.nome);
                AdminServer.listaUsuarios.add(user);
                m.retorno=0;
                AdminServer.publicaUsuarios();
                break;
            }
        }
        return m;
    }

    private Mensagem delete(Mensagem m)
    {
        for(Usuario u:AdminServer.listaUsuarios)
        {
            if(u.getCID().equals(m.cid))
            {
                AdminServer.listaUsuarios.remove(u);
                m.retorno=0;
                AdminServer.publicaUsuarios();
                break;
            }
        }
        return m;
    }
}
