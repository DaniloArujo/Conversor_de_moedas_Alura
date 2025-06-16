import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        String apiKey = "";
        Integer escolha;
        Float valor;

        while (true) {
            System.out.println("********************************************");
            System.out.println("Bem vindo/a ao conversor de moedas :)");
            System.out.println();


            System.out.println();

            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileiro");
            System.out.println("4) Real Brasileiro =>> Dólar");
            System.out.println("5) Dólar ==> Peso Argentino");
            System.out.println("6) Peso Colombiano ==> Dólar");
            System.out.println("7) sair");
            System.out.println();
            System.out.println("*********************************************");
            System.out.print("Escolha uma opção para conversão: ");

            escolha = scanner.nextInt();

            while (escolha < 1 || escolha > 7) {
                System.out.println("Entre com um valor válido");
                escolha = scanner.nextInt();
            }

            if(escolha == 7){
                scanner.close();
                break;
            };

            if(escolha == 1) {

                System.out.print("Entre com o valor a ser convertido : ");
                valor = scanner.nextFloat();

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/fd9d65a9a5c842e5c4394795/latest/USD")).build();

                HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Moeda usd = new Gson().fromJson(json, Moeda.class);

                Double taxa = usd.getConversionRate("ARS");

                System.out.println(valor * taxa);

            }

            if(escolha == 2) {

                System.out.print("Entre com o valor a ser convertido : ");
                valor = scanner.nextFloat();

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/fd9d65a9a5c842e5c4394795/latest/ARS")).build();

                HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Moeda ars = new Gson().fromJson(json, Moeda.class);

                Double taxa = ars.getConversionRate("USD");

                System.out.println(valor * taxa);

            }

            if(escolha == 3) {

                System.out.print("Entre com o valor a ser convertido : ");
                valor = scanner.nextFloat();

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/fd9d65a9a5c842e5c4394795/latest/USD")).build();

                HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Moeda usd = new Gson().fromJson(json, Moeda.class);

                Double taxa = usd.getConversionRate("BRL");

                System.out.println(valor * taxa);

            }

            if(escolha == 4) {

                System.out.print("Entre com o valor a ser convertido : ");
                valor = scanner.nextFloat();

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/fd9d65a9a5c842e5c4394795/latest/BRL")).build();

                HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Moeda brl = new Gson().fromJson(json, Moeda.class);

                Double taxa = brl.getConversionRate("USD");

                System.out.println(valor * taxa);

            }

            if(escolha == 5) {

                System.out.print("Entre com o valor a ser convertido : ");
                valor = scanner.nextFloat();

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/fd9d65a9a5c842e5c4394795/latest/USD")).build();

                HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Moeda usd = new Gson().fromJson(json, Moeda.class);

                Double taxa = usd.getConversionRate("ARS");

                System.out.println(valor * taxa);

            }

            if(escolha == 6) {

                System.out.print("Entre com o valor a ser convertido : ");
                valor = scanner.nextFloat();

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/fd9d65a9a5c842e5c4394795/latest/COP")).build();

                HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Moeda cop = new Gson().fromJson(json, Moeda.class);

                Double taxa = cop.getConversionRate("USD");

                System.out.println(valor * taxa);

            }


        }

        scanner.close();
    }

}
