package br.com.alura.principal;
import br.com.alura.screeenmatch.modelos.Episodio;
import br.com.alura.screeenmatch.modelos.Filme;
import br.com.alura.screeenmatch.modelos.Serie;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.Classificavel;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        FiltroRecomendacao filtro = new FiltroRecomendacao();

        Filme meuFilme = new Filme("Matrix", 1999);


        meuFilme.setDuracaoEmMinutos(118);
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(7);

        meuFilme.exibiFichaTecnica();
        filtro.filtra(meuFilme);

        Filme meuFilme1 = new Filme("O Poderoso Chefão", 1980);
        meuFilme1.setAnoDeLancamento(1980);
        meuFilme1.avalia(1);
        meuFilme1.avalia(1);
        meuFilme1.avalia(7);

        meuFilme1.exibiFichaTecnica();
        System.out.println("Avaliacão: "+meuFilme1.getClassificacao());
        filtro.filtra((Classificavel) meuFilme1);

        Serie serie = new Serie("Lost", 2000);
        serie.avalia(10);
        serie.avalia(9.9);
        serie.setTemporadas(10);
        serie.setEspisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(52);

        serie.exibiFichaTecnica();
        System.out.println(serie.getClassificacao());

        System.out.println("=======================================================");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(meuFilme1);
        calculadora.inclui(serie);
        filtro.filtra(serie);

        System.out.println("Tempo para maratornar : " + calculadora.getTempoTotal() + " minutos.");

        Episodio episodio = new Episodio();
        episodio.setNome("O inicio");
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(1);

        filtro.filtra(episodio);


        var filmeRafa = new Filme("DogVille", 2003);

        filmeRafa.setAnoDeLancamento(2003);
        filmeRafa.setDuracaoEmMinutos(200);
        filmeRafa.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeRafa);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(meuFilme1);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Tamanho da lista: " + listaDeFilmes.get(0).getClassificacao());
        System.out.println(listaDeFilmes);





    }
}
