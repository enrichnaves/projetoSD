package io.github.caio.grpc;

import java.io.Serializable;
import java.math.BigInteger;

public class Mensagem implements Serializable {
    public int op, retorno;
    public String msg;
    public BigInteger cid;
    public String nome;

    public Mensagem(int op, int retorno, String msg) {
        this.op = op;
        this.retorno = retorno;
        this.msg = msg;
    }

    public Mensagem(int op, int retorno, BigInteger cid, String nome) {
        this.op = op;
        this.retorno = retorno;
        this.cid = cid;
        this.nome = nome;
    }
}
