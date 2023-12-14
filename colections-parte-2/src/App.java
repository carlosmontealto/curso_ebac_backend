import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome e o sexo das pessoas da seguinte forma: ");
        System.out.println("João da Silva - M, Maria Jose - F");
        String nomesJuntos = scanner.nextLine();
        String[] nomesComSexo = nomesJuntos.split(", ");

        List<Pessoa> pessoasMasculina = new ArrayList<>();
        List<Pessoa> pessoasFemininas = new ArrayList<>();

        for (int i = 0; i < nomesComSexo.length; i++) {
            String[] nomeComSexo = nomesComSexo[i].split(" - ");

            Pessoa pessoa = new Pessoa(nomeComSexo[0], nomeComSexo[1]);
            if (pessoa.getSexo().equalsIgnoreCase("M")) {
                pessoasMasculina.add(pessoa);
            } else {
                pessoasFemininas.add(pessoa);
            }
        }
        Collections.sort(pessoasMasculina);
        Collections.sort(pessoasFemininas);
        System.out.println("Pessoas do sexo masculino:");
        System.out.println(pessoasMasculina);
        System.out.println("Pessoas do sexo feminino:");
        System.out.println(pessoasFemininas);

        scanner.close();
    }
}
