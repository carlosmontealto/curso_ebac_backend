package br.com.calto;

import static org.junit.Assert.assertTrue;

import br.com.calto.dao.ClienteDAO;
import br.com.calto.dao.IClienteDAO;
import br.com.calto.domain.Cliente;
import br.com.calto.exceptions.DAOException;
import br.com.calto.exceptions.MaisDeUmRegistroException;
import br.com.calto.exceptions.TableException;
import br.com.calto.exceptions.TipoChaveNaoEncontradaException;
import java.util.Collection;
import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ClienteDAOTest {

  private IClienteDAO clienteDao;
  private Random rdn;

  public ClienteDAOTest() {
    clienteDao = new ClienteDAO();
    rdn = new Random();
  }

  @After
  public void end() throws DAOException {
    Collection<Cliente> list = clienteDao.buscarTodos();
    list.forEach(cli -> {
      try {
        clienteDao.excluir(cli.getCpf());
      } catch (DAOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }

  @Test
  public void pesquisarCliente()
    throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
    Cliente cliente = criarCliente();
    clienteDao.cadastrar(cliente);

    Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);

    clienteDao.excluir(cliente.getCpf());
  }

  @Test
  public void salvarCliente()
    throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
    Cliente cliente = criarCliente();
    boolean retorno = clienteDao.cadastrar(cliente);
    Assert.assertTrue(retorno);

    Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);

    clienteDao.excluir(cliente.getCpf());
  }

  @Test
  public void excluirCliente()
    throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
    Cliente cliente = criarCliente();
    clienteDao.cadastrar(cliente);

    Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);

    clienteDao.excluir(cliente.getCpf());
    clienteConsultado = clienteDao.consultar(cliente.getCpf());
    Assert.assertNull(clienteConsultado);
  }

  @Test
  public void alterarCliente()
    throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
    Cliente cliente = criarCliente();
    boolean retorno = clienteDao.cadastrar(cliente);
    Assert.assertTrue(retorno);

    Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);

    clienteConsultado.setNome("Nome novo");
    clienteDao.alterar(clienteConsultado);

    Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
    Assert.assertNotNull(clienteAlterado);
    Assert.assertEquals("Nome novo", clienteAlterado.getNome());

    clienteDao.excluir(cliente.getCpf());
    clienteConsultado = clienteDao.consultar(cliente.getCpf());
    Assert.assertNull(clienteConsultado);
  }

  @Test
  public void buscarTodos()
    throws TipoChaveNaoEncontradaException, DAOException {
    Cliente cliente1 = criarCliente();
    boolean retorno = clienteDao.cadastrar(cliente1);
    Assert.assertTrue(retorno);

    Cliente cliente2 = criarCliente();
    retorno = clienteDao.cadastrar(cliente2);
    Assert.assertTrue(retorno);

    Cliente cliente3 = criarCliente();
    retorno = clienteDao.cadastrar(cliente3);
    Assert.assertTrue(retorno);

    Collection<Cliente> list = clienteDao.buscarTodos();
    assertTrue(list != null);
    assertTrue(list.size() == 3);

    list.forEach(cli -> {
      try {
        clienteDao.excluir(cli.getCpf());
      } catch (DAOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });

    Collection<Cliente> list1 = clienteDao.buscarTodos();
    assertTrue(list1 != null);
    assertTrue(list1.size() == 0);
  }

  private Cliente criarCliente() {
    Cliente cliente = new Cliente();
    Long cpfPessoa = rdn.nextLong();
    cliente.setCpf(cpfPessoa);
    cliente.setNome("Pessoa com CPF " + cpfPessoa);
    cliente.setCidade("São Paulo");
    cliente.setEnd("End");
    cliente.setEstado("SP");
    cliente.setNumero(rdn.nextInt());
    cliente.setTel(rdn.nextLong());
    cliente.setEmail("email@email.com");
    return cliente;
  }
}
