import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoedas {
    public Moedas buscaMoedas(String moedaDe, String moedaPara) {
        URI valorMoeda = URI.create( "https://v6.exchangerate-api.com/v6/b52948def20058bc49b63d2c/pair/"+moedaDe+"/"+moedaPara);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(valorMoeda)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moedas.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui encontrar o valor da moeda!");
        }
    }
}

