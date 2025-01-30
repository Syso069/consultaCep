import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leituraCep = new Scanner(System.in);
        buscaCep buscaCep = new buscaCep();

        System.out.println("Digite um CEP para consultar: ");
        var cep = leituraCep.nextLine();

        try {
            Endereco endereco = buscaCep.retornaCep(cep);
            System.out.println(endereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.geraArquivoJson(endereco);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }
    }
}