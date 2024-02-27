package br.com.calto;

import br.com.calto.objects.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class ManipulacaoLista {

  public List<Pessoa> separaString(String nomes) {
    List<Pessoa> pessoas = new ArrayList<>();

    String[] nomesComSexo = nomes.split(", ");

    for (String nome : nomesComSexo) {
      String[] nomesSeparadosArray = nome.split(" - ");

      Pessoa pessoa = new Pessoa(
        nomesSeparadosArray[0],
        nomesSeparadosArray[1]
      );
      pessoas.add(pessoa);
    }
    return pessoas;
  }

  public List<Pessoa> listaFeminino(List<Pessoa> pessoas) {
    List<Pessoa> pessoasFemininas = new ArrayList<>();
    pessoas
      .stream()
      .filter(p -> p.getSexo().equals("F"))
      .forEach(pessoasFemininas::add);
    return pessoasFemininas;
  }

  public List<Pessoa> listaMasculino(List<Pessoa> pessoas) {
    List<Pessoa> pessoasMasculinas = new ArrayList<>();
    pessoas
      .stream()
      .filter(p -> p.getSexo().equals("M"))
      .forEach(pessoasMasculinas::add);
    return pessoasMasculinas;
  }
}
