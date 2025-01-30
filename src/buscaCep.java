import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class buscaCep {
    public Endereco retornaCep(String cep) throws IOException {

        URI buscaCep = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(buscaCep)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (Exception e){
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }
}
