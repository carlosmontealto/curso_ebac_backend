package br.com.calto;

import br.com.calto.dao.ClienteDaoMock;
import br.com.calto.dao.IClienteDAO;
import br.com.calto.domain.Cliente;
import br.com.calto.exception.TipoChaveNaoEncontradaException;
import org.junit.*;

public class ClienteDAOTest {

  private IClienteDAO clienteDao;

  private Cliente cliente;

  public ClienteDAOTest() {
    clienteDao = new ClienteDaoMock();
  }

  @Before
  public void init() throws TipoChaveNaoEncontradaException {
    cliente = new Cliente();

    cliente.setCpf(12345678912L);
    cliente.setNome("Carlos Monte-Alto");
    cliente.setCidade("Campo Mourão");
    cliente.setEnd("Rua sei la");
    cliente.setEstado("PR");
    cliente.setNumero(1000);
    cliente.setTel(1112341234L);
    clienteDao.cadastrar(cliente);
  }

  @Test
  public void pesquisarCliente() {
    Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);
  }

  @Test
  public void salvarCliente() throws TipoChaveNaoEncontradaException {
    Boolean retorno = clienteDao.cadastrar(cliente);
    Assert.assertTrue(retorno);
  }

  @Test
  public void excluirCliente() {
    clienteDao.excluir(cliente.getCpf());
  }

  @Test
  public void alterarCliente() throws TipoChaveNaoEncontradaException {
    cliente.setNome("Carlos");
    clienteDao.alterar(cliente);
    Assert.assertEquals("Carlos", cliente.getNome());
  }
}
