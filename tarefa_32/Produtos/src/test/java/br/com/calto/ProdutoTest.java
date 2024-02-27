package br.com.calto;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.calto.dao.IProdutoDao;
import br.com.calto.dao.ProdutoDao;
import br.com.calto.domain.Produto;

public class ProdutoTest {

  private IProdutoDao produtoDao;

  public ProdutoTest() {
    produtoDao = new ProdutoDao();
  }

  @Test
  public void cadastrar() {
    Produto produto = new Produto();
    produto.setNome("Camisa Polo");
    produto.setDescricao("Camiseta polo branca com detalhes pretos.");
    produto.setValor(37.9d);
    produto.setCodigo("A1");

    produto = produtoDao.cadastrar(produto);

    assertNotNull(produto);
    assertNotNull(produto.getId());

  }

}
