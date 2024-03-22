package br.com.calto;

import br.com.calto.dao.ClienteDaoMock;
import br.com.calto.dao.IClienteDAO;
import br.com.calto.domain.Cliente;
import br.com.calto.exceptions.DAOException;
import br.com.calto.exceptions.TipoChaveNaoEncontradaException;
import br.com.calto.services.ClienteService;
import br.com.calto.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

  private IClienteService clienteService;

  private Cliente cliente;

  public ClienteServiceTest() {
    IClienteDAO dao = new ClienteDaoMock();
    clienteService = new ClienteService(dao);
  }

  @Before
  public void init() {
    cliente = new Cliente();
    cliente.setCpf(12312312312L);
    cliente.setNome("Carlos");
    cliente.setCidade("São Paulo");
    cliente.setEnd("End");
    cliente.setEstado("SP");
    cliente.setNumero(10);
    cliente.setTel(1199999999L);
  }

  @Test
  public void pesquisarCliente() throws DAOException {
    Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);
  }

  @Test
  public void salvarCliente()
    throws TipoChaveNaoEncontradaException, DAOException {
    Boolean retorno = clienteService.cadastrar(cliente);

    Assert.assertTrue(retorno);
  }

  @Test
  public void excluirCliente() throws DAOException {
    clienteService.excluir(cliente.getCpf());
  }

  @Test
  public void alterarCliente()
    throws TipoChaveNaoEncontradaException, DAOException {
    cliente.setNome("Carlos Montealto");
    clienteService.alterar(cliente);

    Assert.assertEquals("Carlos Montealto", cliente.getNome());
  }
}
