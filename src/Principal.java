import br.com.alura.screeenmatch.modelos.Episodio;
import br.com.alura.screeenmatch.modelos.Filme;
import br.com.alura.screeenmatch.modelos.Serie;
import br.com.alura.screeenmatch.modelos.Titulo;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.Classificavel;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;

public class Principal {
    public static void main(String[] args) {

        FiltroRecomendacao filtro = new FiltroRecomendacao();

        Filme meuFilme = new Filme();

        meuFilme.setNome("Matrix");
        meuFilme.setDuracaoEmMinutos(118);
        meuFilme.setAnoDeLancamento(1999);
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(7);

        meuFilme.exibiFichaTecnica();
        filtro.filtra(meuFilme);

        Filme meuFilme1 = new Filme();
        meuFilme1.setNome("O Poderoso Chefão");
        meuFilme1.setDuracaoEmMinutos(197);
        meuFilme1.setAnoDeLancamento(1980);
        meuFilme1.avalia(1);
        meuFilme1.avalia(1);
        meuFilme1.avalia(7);

        meuFilme1.exibiFichaTecnica();
        System.out.println("Avaliacão: "+meuFilme1.getClassificacao());
        filtro.filtra(meuFilme1);

        Serie serie = new Serie();
        serie.setNome("Lost");
        serie.setAnoDeLancamento(2000);
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




    }
}
