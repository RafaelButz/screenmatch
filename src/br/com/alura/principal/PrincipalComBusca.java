package br.com.alura.principal;
import br.com.alura.screeenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screeenmatch.modelos.Titulo;
import br.com.alura.screeenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";

        List<Titulo> listaTitulo = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!busca.equalsIgnoreCase("Parar")) {

            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("Parar")){
                break;
            }

            busca = busca.replaceAll(" ", "+");

            try {

                String endereco = "http://www.omdbapi.com/?t=" + busca + "&apikey=7eaa794a";


                        System.out.println(endereco);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);



//        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
//        System.out.println(meuTitulo);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println(meuTitulo);

                listaTitulo.add(meuTitulo);


//                FileWriter fileWriter = new FileWriter("Filmes.txt");
//                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                bufferedWriter.write(meuTitulo.toString());
//                bufferedWriter.close();


            } catch (NumberFormatException e) {
                System.out.println("Ocorreu um erro");
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Erro no argumento de busca");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMensagem());
            } catch (NullPointerException e){
                System.out.println("Filme não localizado");
                continue;
            }
        }
        System.out.println("Programa finalizou corretamente");

        FileWriter escrita = new FileWriter("Filmes.json");
        escrita.write(gson.toJson(listaTitulo));
        escrita.close();

        FileWriter escrita2 = new FileWriter("Filmes.txt");
        escrita2.append(listaTitulo.toString());
        escrita2.close();

        System.out.println(listaTitulo);
    }
}
