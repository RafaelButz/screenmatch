package br.com.alura.principal;

import br.com.alura.screeenmatch.modelos.Filme;
import br.com.alura.screeenmatch.modelos.Serie;
import br.com.alura.screeenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComLista {
    public static void main(String[] args) {

        var filmeRafa = new Filme("DogVille", 2003);
        filmeRafa.avalia(10);
        Filme meuFilme = new Filme("Matrix", 1999);
        meuFilme.avalia(10);
        Filme meuFilme1 = new Filme("O Poderoso Chefão", 1980);
        meuFilme1.avalia(10);

        Serie serie = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeRafa);
        lista.add(meuFilme);
        lista.add(meuFilme1);
        lista.add(serie);

   

        System.out.println(lista);

//        for (Titulo item: lista) {
//            System.out.println(item.getNome());
//            br.com.alura.screeenmatch.modelos.Filme filme = (br.com.alura.screeenmatch.modelos.Filme) item;
//            System.out.println("Classificação: " + ((br.com.alura.screeenmatch.modelos.Filme) item).getClassificacao());
//
//        }

        for (Titulo item: lista) {
            if(item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("br.com.alura.screeenmatch.modelos.Filme: " + item.getNome());
                System.out.println("Classificação: "+ filme.getClassificacao());
            }

        }

        List<String> buscaPorArtista = new LinkedList<>();

        buscaPorArtista.add("Adam Sandlers");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Michael");
        buscaPorArtista.add("Katarina");
        buscaPorArtista.add("Elaine");

        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da Ordenação ");
        System.out.println(buscaPorArtista);


        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano : " + lista);

    }

}
