import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void geraArquivoJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter file = new FileWriter(endereco.cep() + ".json");
        file.write(gson.toJson(endereco));
        file.close();
        System.out.println("Programa finalizado com sucesso!");
    }
}
