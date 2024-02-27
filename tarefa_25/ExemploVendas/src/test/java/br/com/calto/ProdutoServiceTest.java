package br.com.calto;

import br.com.calto.dao.IProdutoDAO;
import br.com.calto.dao.ProdutoDaoMock;
import br.com.calto.domain.Produto;
import br.com.calto.exception.TipoChaveNaoEncontradaException;
import br.com.calto.services.IProdutoService;
import br.com.calto.services.ProdutoService;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoServiceTest {

  private IProdutoService produtoService;

  private br.com.calto.domain.Produto produto;

  public ProdutoServiceTest() {
    IProdutoDAO dao = new ProdutoDaoMock();
    produtoService = new ProdutoService(dao);
  }

  @Before
  public void init() {
    produto = new Produto();
    produto.setCodigo(120L);
    produto.setDescricao("Produto 1");
    produto.setNome("Produto 1");
    produto.setValor(BigDecimal.valueOf(1350.2));
  }

  @Test
  public void pesquisar() {
    Produto produtor = this.produtoService.consultar(produto.getCodigo());
    Assert.assertNotNull(produtor);
  }

  @Test
  public void salvar() throws TipoChaveNaoEncontradaException {
    Boolean retorno = produtoService.cadastrar(produto);
    Assert.assertTrue(retorno);
  }

  @Test
  public void excluir() {
    produtoService.excluir(produto.getCodigo());
  }

  @Test
  public void alterarCliente() throws TipoChaveNaoEncontradaException {
    produto.setNome("Carlos Monte-Alto");
    produtoService.alterar(produto);

    Assert.assertEquals("Carlos Monte-Alto", produto.getNome());
  }
}
