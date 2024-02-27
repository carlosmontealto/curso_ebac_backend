package br.com.calto;

import br.com.calto.objects.Pessoa;
import java.util.*;

public class App {

  public static void main(String[] args) {
    List<Pessoa> pessoas;
    List<Pessoa> pessoasMasculinas;
    List<Pessoa> pessoasFemininas;

    Scanner s = new Scanner(System.in);
    ManipulacaoLista mani = new ManipulacaoLista();

    System.out.println(
      "\n\nOlá, insira a lista de pessoa da seguinte forma: Nome - Sexo(M/F), Nome 2 - Sexo"
    );
    String nomesJuntos = s.nextLine();

    pessoas = mani.separaString(nomesJuntos);
    pessoasFemininas = mani.listaFeminino(pessoas);
    pessoasMasculinas = mani.listaMasculino(pessoas);

    System.out.println("\n\nPessoas do sexo feminino\n");
    pessoasFemininas.forEach(p -> System.out.println(p.getNome()));

    System.out.println("\n\nPessoas do sexo masculino\n");
    pessoasMasculinas.forEach(p -> System.out.println(p.getNome()));

    s.close();
  }
}
