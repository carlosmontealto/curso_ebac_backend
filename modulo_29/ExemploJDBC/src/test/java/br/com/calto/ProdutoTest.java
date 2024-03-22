package br.com.calto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import br.com.calto.dao.IProdutoDAO;
import br.com.calto.dao.ProdutoDAO;
import br.com.calto.domain.Produto;
import java.util.List;
import org.junit.Test;

public class ProdutoTest {

  private IProdutoDAO produtoDAO;

  public ProdutoTest() {
    produtoDAO = new ProdutoDAO();
  }

  @Test
  public void cadastrarProduto() throws Exception {
    Produto produto = criarProduto("A1");
    Integer countCad = produtoDAO.cadastrar(produto);
    assertTrue(countCad == 1);

    Produto produtoDB = produtoDAO.buscar("A1");
    assertNotNull(produtoDB);
    assertEquals(produto.getCodigo(), produtoDB.getCodigo());
    assertEquals(produto.getNome(), produtoDB.getNome());

    Integer countDel = produtoDAO.excluir(produtoDB);
    assertTrue(countDel == 1);
  }

  @Test
  public void buscarProduto() throws Exception {
    Produto produto = criarProduto("A2");
    Integer countCad = produtoDAO.cadastrar(produto);
    assertTrue(countCad == 1);

    Produto produtoDB = produtoDAO.buscar("A2");
    assertNotNull(produtoDB);
    assertEquals(produto.getCodigo(), produtoDB.getCodigo());
    assertEquals(produto.getNome(), produtoDB.getNome());

    Integer countDel = produtoDAO.excluir(produtoDB);
    assertTrue(countDel == 1);
  }

  @Test
  public void atualizarProduto() throws Exception {
    Produto produto = criarProduto("A3");
    Integer countCad = produtoDAO.cadastrar(produto);
    assertTrue(countCad == 1);

    Produto produtoDB1 = produtoDAO.buscar("A3");
    assertNotNull(produtoDB1);
    assertEquals(produto.getCodigo(), produtoDB1.getCodigo());
    assertEquals(produto.getNome(), produtoDB1.getNome());

    produtoDB1.setCodigo("A4");
    produtoDB1.setNome("Produto novo");
    Integer countUpdate = produtoDAO.atualizar(produtoDB1);
    assertTrue(countUpdate == 1);

    Produto produtoDB2 = produtoDAO.buscar("A3");
    assertNull(produtoDB2);

    Produto produtoDB3 = produtoDAO.buscar("A4");
    assertNotNull(produtoDB3);
    assertEquals(produtoDB1.getId(), produtoDB3.getId());
    assertEquals(produtoDB1.getCodigo(), produtoDB3.getCodigo());
    assertEquals(produtoDB1.getNome(), produtoDB3.getNome());

    Integer countDel = produtoDAO.excluir(produtoDB1);
    assertTrue(countDel == 1);
  }

  @Test
  public void excluirProduto() throws Exception {
    Produto produto = criarProduto("A5");
    Integer countCad = produtoDAO.cadastrar(produto);
    assertTrue(countCad == 1);

    Produto produtoDB = produtoDAO.buscar("A5");
    assertNotNull(produtoDB);
    assertEquals(produto.getCodigo(), produtoDB.getCodigo());
    assertEquals(produto.getNome(), produtoDB.getNome());

    Integer countDel = produtoDAO.excluir(produtoDB);
    assertTrue(countDel == 1);
  }

  @Test
  public void buscarTodos() throws Exception {
    Produto prod1 = criarProduto("A6");
    Produto prod2 = criarProduto("A7");
    Produto prod3 = criarProduto("A8");

    Integer counCad = produtoDAO.cadastrar(prod1);
    assertTrue(counCad == 1);
    counCad = produtoDAO.cadastrar(prod2);
    assertTrue(counCad == 1);
    counCad = produtoDAO.cadastrar(prod3);
    assertTrue(counCad == 1);

    List<Produto> lista = produtoDAO.buscarTodos();
    assertNotNull(lista);
    assertEquals(3, lista.size());

    int countDel = 0;
    for (Produto produto : lista) {
      produtoDAO.excluir(produto);
      countDel++;
    }
    assertEquals(lista.size(), countDel);

    lista = produtoDAO.buscarTodos();
    assertEquals(lista.size(), 0);
  }

  private Produto criarProduto(String codigo) {
    Produto produto = new Produto();
    produto.setCodigo(codigo);
    produto.setNome("Produto " + codigo);
    produto.setDescricao("Descrição do Produto: " + codigo);
    produto.setPreco(157.90);
    return produto;
  }
}
