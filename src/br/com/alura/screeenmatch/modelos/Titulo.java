package br.com.alura.screeenmatch.modelos;

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



}
