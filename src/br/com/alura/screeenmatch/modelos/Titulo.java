package br.com.alura.screeenmatch.modelos;

import br.com.alura.screeenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {

        this.nome = meuTituloOmdb.title();
        if (meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano por ter mais que 4 caracteres");
        }

        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0 , 2));
    }

    public void exibiFichaTecnica(){

        System.out.println("=======================================================");
        System.out.println("Nome: "+ getNome());
        System.out.println("Duração: " + getDuracaoEmMinutos());
        System.out.println("Lançamento: " + getAnoDeLancamento());
        System.out.println(String.format("Avaliação: %.1f ", pegaMedia()));
        System.out.println("Total Avaliações: " + getTotalDeAvaliacoes());

    }

    public void avalia(double nota){
        this.somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;

    }
    double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return  "nome = " + nome + ", anoDeLancamento = " + anoDeLancamento + ", Duração: " +
                duracaoEmMinutos + "\n";
    }
}
