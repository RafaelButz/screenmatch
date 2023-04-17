package br.com.alura.screenmatch.calculos;

import br.com.alura.screeenmatch.modelos.Titulo;

public class FiltroRecomendacao extends Titulo {


    public void filtra(Classificavel classificavel){
        if(classificavel.getClassificacao() >= 4){
            System.out.println("Esta entre os preferidos do momento");
        } else if(classificavel.getClassificacao() < 4){
            System.out.println("Uma Bosta!");
        } else {
            System.out.println("Deixe para depois");
        }
    }

}
