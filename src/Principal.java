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

        System.out.println("=======================================================");
    }

}
