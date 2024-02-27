package br.com.calto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import br.com.calto.dao.ClienteDAO;
import br.com.calto.dao.IClienteDAO;
import br.com.calto.dao.IProdutoDAO;
import br.com.calto.dao.IVendaDAO;
import br.com.calto.dao.ProdutoDAO;
import br.com.calto.dao.VendaDAO;
import br.com.calto.domain.Cliente;
import br.com.calto.domain.Produto;
import br.com.calto.domain.Venda;
import br.com.calto.domain.Venda.Status;
import br.com.calto.exception.TipoChaveNaoEncontradaException;
import java.math.BigDecimal;
import java.time.Instant;
import org.junit.Before;
import org.junit.Test;

public class VendaDAOTest {

  private IVendaDAO vendaDao;

  private IClienteDAO clienteDao;

  private IProdutoDAO produtoDao;

  //private Venda venda;

  private Cliente cliente;

  private Produto produto;

  public VendaDAOTest() {
    vendaDao = new VendaDAO();
    clienteDao = new ClienteDAO();
    produtoDao = new ProdutoDAO();
  }

  @Before
  public void init() throws TipoChaveNaoEncontradaException {
    this.cliente = cadastrarCliente();
    this.produto = cadastrarProduto(120L, BigDecimal.TEN);
  }

  @Test
  public void pesquisar() throws TipoChaveNaoEncontradaException {
    Venda venda = criarVenda(1L);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
    assertNotNull(vendaConsultada);
    assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
  }

  @Test
  public void salvar() throws TipoChaveNaoEncontradaException {
    Venda venda = criarVenda(2L);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
    assertTrue(venda.getStatus().equals(Status.INICIADA));
  }

  @Test
  public void cancelarVenda() throws TipoChaveNaoEncontradaException {
    Long codigoVenda = 3L;
    Venda venda = criarVenda(codigoVenda);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertNotNull(venda);
    assertEquals(codigoVenda, venda.getCodigo());

    venda.setStatus(Status.CANCELADA);
    vendaDao.alterar(venda);

    Venda vendaConsultada = vendaDao.consultar(codigoVenda);
    assertEquals(codigoVenda, vendaConsultada.getCodigo());
    assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
  }

  @Test
  public void adicionarMaisProdutosDoMesmo()
    throws TipoChaveNaoEncontradaException {
    Long codigoVenda = 4L;
    Venda venda = criarVenda(codigoVenda);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertNotNull(venda);
    assertEquals(codigoVenda, venda.getCodigo());

    Venda vendaConsultada = vendaDao.consultar(codigoVenda);
    vendaConsultada.adicionarProduto(produto, 1);

    assertTrue(venda.getQuantidadeTotalProdutos() == 3);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(30)));
    assertTrue(venda.getStatus().equals(Status.INICIADA));
  }

  @Test
  public void adicionarMaisProdutosDiferentes()
    throws TipoChaveNaoEncontradaException {
    Long codigoVenda = 5L;
    Venda venda = criarVenda(codigoVenda);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertNotNull(venda);
    assertEquals(codigoVenda, venda.getCodigo());

    Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
    assertNotNull(prod);
    assertEquals(codigoVenda, prod.getCodigo());

    Venda vendaConsultada = vendaDao.consultar(codigoVenda);
    vendaConsultada.adicionarProduto(prod, 1);

    assertTrue(venda.getQuantidadeTotalProdutos() == 3);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));
    assertTrue(venda.getStatus().equals(Status.INICIADA));
  }

  @Test
  public void salvarProdutoExistente() throws TipoChaveNaoEncontradaException {
    Venda venda = criarVenda(6L);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);

    Boolean retorno1 = vendaDao.cadastrar(venda);
    assertFalse(retorno1);
    assertTrue(venda.getStatus().equals(Status.INICIADA));
  }

  @Test
  public void removerProduto() throws TipoChaveNaoEncontradaException {
    Long codigoVenda = 7L;
    Venda venda = criarVenda(codigoVenda);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertNotNull(venda);
    assertEquals(codigoVenda, venda.getCodigo());

    Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
    assertNotNull(prod);
    assertEquals(codigoVenda, prod.getCodigo());

    Venda vendaConsultada = vendaDao.consultar(codigoVenda);
    vendaConsultada.adicionarProduto(prod, 1);
    assertTrue(venda.getQuantidadeTotalProdutos() == 3);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));

    vendaConsultada.removerProduto(prod, 1);
    assertTrue(venda.getQuantidadeTotalProdutos() == 2);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
    assertTrue(venda.getStatus().equals(Status.INICIADA));
  }

  @Test
  public void removerApenasUmProduto() throws TipoChaveNaoEncontradaException {
    Long codigoVenda = 8L;
    Venda venda = criarVenda(codigoVenda);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertNotNull(venda);
    assertEquals(codigoVenda, venda.getCodigo());

    Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
    assertNotNull(prod);
    assertEquals(codigoVenda, prod.getCodigo());

    Venda vendaConsultada = vendaDao.consultar(codigoVenda);
    vendaConsultada.adicionarProduto(prod, 1);
    assertTrue(venda.getQuantidadeTotalProdutos() == 3);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));

    vendaConsultada.removerProduto(prod, 1);
    assertTrue(venda.getQuantidadeTotalProdutos() == 2);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
    assertTrue(venda.getStatus().equals(Status.INICIADA));
  }

  @Test
  public void removerTodosProdutos() throws TipoChaveNaoEncontradaException {
    Long codigoVenda = 9L;
    Venda venda = criarVenda(codigoVenda);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertNotNull(venda);
    assertEquals(codigoVenda, venda.getCodigo());

    Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
    assertNotNull(prod);
    assertEquals(codigoVenda, prod.getCodigo());

    Venda vendaConsultada = vendaDao.consultar(codigoVenda);
    vendaConsultada.adicionarProduto(prod, 1);
    assertTrue(venda.getQuantidadeTotalProdutos() == 3);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));

    vendaConsultada.removerTodosProdutos();
    assertTrue(venda.getQuantidadeTotalProdutos() == 0);
    assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(0)));
    assertTrue(venda.getStatus().equals(Status.INICIADA));
  }

  @Test
  public void finalizarVenda() throws TipoChaveNaoEncontradaException {
    Long codigoVenda = 10L;
    Venda venda = criarVenda(codigoVenda);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertNotNull(venda);
    assertEquals(codigoVenda, venda.getCodigo());

    vendaDao.finalizarVenda(venda);

    Venda vendaConsultada = vendaDao.consultar(codigoVenda);
    assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    assertEquals(venda.getStatus(), vendaConsultada.getStatus());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void tentarAdicionarProdutosVendaFinalizada()
    throws TipoChaveNaoEncontradaException {
    Long codigoVenda = 11L;
    Venda venda = criarVenda(codigoVenda);
    Boolean retorno = vendaDao.cadastrar(venda);
    assertTrue(retorno);
    assertNotNull(venda);
    assertEquals(codigoVenda, venda.getCodigo());

    vendaDao.finalizarVenda(venda);
    Venda vendaConsultada = vendaDao.consultar(codigoVenda);
    assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    assertEquals(venda.getStatus(), vendaConsultada.getStatus());

    vendaConsultada.adicionarProduto(this.produto, 1);
  }

  private Produto cadastrarProduto(Long codigo, BigDecimal valor)
    throws TipoChaveNaoEncontradaException {
    Produto produto = new Produto();
    produto.setCodigo(codigo);
    produto.setDescricao("Produto 1");
    produto.setNome("Produto 1");
    produto.setValor(valor);
    produtoDao.cadastrar(produto);
    return produto;
  }

  private Cliente cadastrarCliente() throws TipoChaveNaoEncontradaException {
    Cliente cliente = new Cliente();
    cliente.setCpf(12312312312L);
    cliente.setNome("Carlos");
    cliente.setCidade("Campo Mourão");
    cliente.setEnd("Sei lá");
    cliente.setEstado("PR");
    cliente.setNumero(1000);
    cliente.setTel(12345678912L);
    clienteDao.cadastrar(cliente);
    return cliente;
  }

  private Venda criarVenda(Long codigo) {
    Venda venda = new Venda();
    venda.setCodigo(codigo);
    venda.setDataVenda(Instant.now());
    venda.setCliente(this.cliente);
    venda.setStatus(Status.INICIADA);
    venda.adicionarProduto(this.produto, 2);
    return venda;
  }
}
