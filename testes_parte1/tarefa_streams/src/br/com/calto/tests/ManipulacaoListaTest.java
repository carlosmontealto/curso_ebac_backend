package br.com.calto.tests;

import br.com.calto.ManipulacaoLista;
import br.com.calto.objects.Pessoa;
import java.util.*;
import org.junit.*;

public class ManipulacaoListaTest {

  List<Pessoa> pessoas = new ArrayList<>();
  ManipulacaoLista mani = new ManipulacaoLista();

  @Before
  public void teste() {
    pessoas.add(new Pessoa("Rafaela", "F"));
    pessoas.add(new Pessoa("Thaise", "F"));
    pessoas.add(new Pessoa("Carlos", "M"));
    pessoas.add(new Pessoa("Ana", "F"));
    pessoas.add(new Pessoa("Rodrigo", "M"));
    pessoas.add(new Pessoa("Matheus", "M"));
  }

  @Test
  public void testListaCompleta() {
    Assert.assertEquals(6, pessoas.size());
  }

  @Test
  public void testListaFeminina() {
    List<Pessoa> pessoasFemininas;
    pessoasFemininas = mani.listaFeminino(pessoas);

    Assert.assertTrue(
      pessoasFemininas.stream().allMatch(p -> p.getSexo().equals("F"))
    );
    Assert.assertEquals(3, pessoasFemininas.size());
  }

  @Test
  public void testListaMasculina() {
    List<Pessoa> pessoasMasculinas;
    pessoasMasculinas = mani.listaMasculino(pessoas);

    Assert.assertTrue(
      pessoasMasculinas.stream().allMatch(p -> p.getSexo().equals("M"))
    );
    Assert.assertEquals(3, pessoasMasculinas.size());
  }
}
