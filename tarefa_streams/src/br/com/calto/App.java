package br.com.calto;

import br.com.calto.objects.Pessoa;
import java.util.*;

public class App {

  public static void main(String[] args) {
    List<Pessoa> pessoas = new ArrayList<>();
    List<Pessoa> pessoasMasculinas = new ArrayList<>();
    List<Pessoa> pessoasFemininas = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    System.out.println(
      "\n\nOlá, insira a lista de pessoa da seguinte forma: Nome - Sexo(M/F), Nome 2 - Sexo"
    );
    String nomesJuntos = s.nextLine();

    String[] nomesComSexo = nomesJuntos.split(", ");

    for (String nome : nomesComSexo) {
      String[] nomesSeparadosArray = nome.split(" - ");

      Pessoa pessoa = new Pessoa(
        nomesSeparadosArray[0],
        nomesSeparadosArray[1]
      );
      pessoas.add(pessoa);
    }

    pessoas
      .stream()
      .filter(p -> p.getSexo().equals("F"))
      .forEach(pessoasFemininas::add);

    pessoas
      .stream()
      .filter(p -> p.getSexo().equals("M"))
      .forEach(pessoasMasculinas::add);

    System.out.println("\n\nPessoas do sexo feminino\n");
    pessoasFemininas.forEach(p -> System.out.println(p.getNome()));

    System.out.println("\n\nPessoas do sexo masculino\n");
    pessoasMasculinas.forEach(p -> System.out.println(p.getNome()));

    s.close();
  }
}
