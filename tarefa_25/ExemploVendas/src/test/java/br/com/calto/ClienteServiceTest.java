package br.com.calto;

import br.com.calto.dao.ClienteDaoMock;
import br.com.calto.dao.IClienteDAO;
import br.com.calto.domain.Cliente;
import br.com.calto.exception.TipoChaveNaoEncontradaException;
import br.com.calto.services.ClienteService;
import br.com.calto.services.IClienteService;
import org.junit.*;

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

    cliente.setCpf(12345678912L);
    cliente.setNome("Carlos Monte-Alto");
    cliente.setCidade("Campo Mourão");
    cliente.setEnd("Rua sei la");
    cliente.setEstado("PR");
    cliente.setNumero(1000);
    cliente.setTel(1112341234L);
  }

  @Test
  public void pesquisarCliente() {
    Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);
  }

  @Test
  public void salvarCliente() throws TipoChaveNaoEncontradaException {
    Boolean retorno = clienteService.cadastrar(cliente);
    Assert.assertTrue(retorno);
  }

  @Test
  public void excluirCliente() {
    clienteService.excluir(cliente.getCpf());
  }

  @Test
  public void alterarCliente() throws TipoChaveNaoEncontradaException {
    cliente.setNome("Carlos");
    clienteService.alterar(cliente);
    Assert.assertEquals("Carlos", cliente.getNome());
  }
}
