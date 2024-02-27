package br.com.calto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.calto.dao.IProdutoDAO;
import br.com.calto.dao.ProdutoDAO;
import br.com.calto.domain.Produto;
import br.com.calto.exception.TipoChaveNaoEncontradaException;
import java.math.BigDecimal;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoDAOTest {

  private IProdutoDAO produtoDao;

  private Produto produto;

  public ProdutoDAOTest() {
    produtoDao = new ProdutoDAO();
  }

  @Before
  public void init() throws TipoChaveNaoEncontradaException {
    produto = new Produto();
    produto.setCodigo(120L);
    produto.setDescricao("Produto 1");
    produto.setNome("Produto 1");
    produto.setValor(BigDecimal.valueOf(150.2));
    produtoDao.cadastrar(produto);
  }

  @Test
  public void pesquisar() {
    Produto produto = this.produtoDao.consultar(this.produto.getCodigo());
    Assert.assertNotNull(produto);
  }

  @Test
  public void salvar() throws TipoChaveNaoEncontradaException {
    produto.setCodigo(125L);
    Boolean retorno = produtoDao.cadastrar(produto);
    Assert.assertTrue(retorno);
  }

  @Test
  public void excluir() {
    produtoDao.excluir(produto.getCodigo());
  }

  @Test
  public void alterarCliente() throws TipoChaveNaoEncontradaException {
    produto.setNome("Carlos Monte-Alto");
    produtoDao.alterar(produto);

    Assert.assertEquals("Carlos Monte-Alto", produto.getNome());
  }

  @Test
  public void buscarTodos() {
    Collection<Produto> list = produtoDao.buscarTodos();
    assertTrue(list != null);
    assertEquals(6, list.size());
  }
}
