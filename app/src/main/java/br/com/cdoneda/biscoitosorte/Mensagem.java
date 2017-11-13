package br.com.cdoneda.biscoitosorte;

/**
 * Created by cassi on 13/11/2017.
 */

public class Mensagem {

    private String autor;
    private String mensagem;

    public Mensagem(){}
    public Mensagem(String autor, String mensagem) {
        this.autor = autor;
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "autor='" + autor + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
