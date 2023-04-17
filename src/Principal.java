import br.com.alura.screeenmatch.modelos.Filme;
import br.com.alura.screeenmatch.modelos.Serie;
import br.com.alura.screeenmatch.modelos.Titulo;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();

        meuFilme.setNome("Matrix");
        meuFilme.setDuracaoEmMinutos(110);
        meuFilme.setAnoDeLancamento(1999);
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(7);

        meuFilme.exibiFichaTecnica();

        Filme meuFilme1 = new Filme();
        meuFilme1.setNome("O Poderoso Chefão");
        meuFilme1.setDuracaoEmMinutos(190);
        meuFilme1.setAnoDeLancamento(1980);
        meuFilme1.avalia(10);
        meuFilme1.avalia(10);
        meuFilme1.avalia(7);

        meuFilme1.exibiFichaTecnica();

        Serie serie = new Serie();
        serie.setNome("Lost");
        serie.setAnoDeLancamento(2000);
        serie.avalia(10);
        serie.avalia(8);
        serie.setTemporadas(10);
        serie.setEspisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(50);
        serie.exibiFichaTecnica();

        System.out.println("=======================================================");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(meuFilme1);
        calculadora.inclui(serie);

        System.out.println(calculadora.getTempoTotal());

    }
}
