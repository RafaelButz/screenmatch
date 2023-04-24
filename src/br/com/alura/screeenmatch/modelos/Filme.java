package br.com.alura.screeenmatch.modelos;
import br.com.alura.screeenmatch.modelos.Titulo;
import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;


    public Filme(String nome, int anoDeLancamento) {
       super(nome, anoDeLancamento);
    }


    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int)pegaMedia() / 2;
    }


    @Override
    public String toString() {
        return "br.com.alura.screeenmatch.modelos.Filme: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
