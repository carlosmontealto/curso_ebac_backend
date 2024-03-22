package br.com.calto.jpa;

import static org.junit.Assert.assertTrue;

import br.com.calto.dao.jpa.ClienteJpaDAO;
import br.com.calto.dao.jpa.ClienteJpaDB2DAO;
import br.com.calto.dao.jpa.IClienteJpaDAO;
import br.com.calto.domain.jpa.ClienteJpa;
import br.com.calto.exceptions.DAOException;
import br.com.calto.exceptions.MaisDeUmRegistroException;
import br.com.calto.exceptions.TableException;
import br.com.calto.exceptions.TipoChaveNaoEncontradaException;
import java.util.Collection;
import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ClienteJpaDao2BancosTest {

  private IClienteJpaDAO<ClienteJpa> clienteDao;

  private IClienteJpaDAO<ClienteJpa> clienteDB2Dao;

  private Random rd;

  public ClienteJpaDao2BancosTest() {
    this.clienteDao = new ClienteJpaDAO();
    this.clienteDB2Dao = new ClienteJpaDB2DAO();
    rd = new Random();
  }

  @After
  public void end() throws DAOException {
    Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
    excluir1(list1);

    Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
    excluir2(list2);
  }

  private void excluir1(Collection<ClienteJpa> list) {
    list.forEach(cli -> {
      try {
        clienteDao.excluir(cli);
      } catch (DAOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }

  private void excluir2(Collection<ClienteJpa> list) {
    list.forEach(cli -> {
      try {
        clienteDB2Dao.excluir(cli);
      } catch (DAOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }

  @Test
  public void pesquisarCliente()
    throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
    ClienteJpa cliente = criarCliente();
    clienteDao.cadastrar(cliente);

    ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
    Assert.assertNotNull(clienteConsultado);

    cliente.setId(null);
    clienteDB2Dao.cadastrar(cliente);

    ClienteJpa clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
    Assert.assertNotNull(clienteConsultado2);
  }

  @Test
  public void salvarCliente()
    throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
    ClienteJpa cliente = criarCliente();
    ClienteJpa retorno = clienteDao.cadastrar(cliente);
    Assert.assertNotNull(retorno);

    ClienteJpa clienteConsultado = clienteDao.consultar(retorno.getId());
    Assert.assertNotNull(clienteConsultado);

    clienteDao.excluir(cliente);

    ClienteJpa clienteConsultado1 = clienteDao.consultar(retorno.getId());
    Assert.assertNull(clienteConsultado1);
  }

  @Test
  public void excluirCliente()
    throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
    ClienteJpa cliente = criarCliente();
    ClienteJpa retorno = clienteDao.cadastrar(cliente);
    Assert.assertNotNull(retorno);

    ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
    Assert.assertNotNull(clienteConsultado);

    clienteDao.excluir(cliente);
    clienteConsultado = clienteDao.consultar(cliente.getId());
    Assert.assertNull(clienteConsultado);
  }

  @Test
  public void alterarCliente()
    throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
    ClienteJpa cliente = criarCliente();
    ClienteJpa retorno = clienteDao.cadastrar(cliente);
    Assert.assertNotNull(retorno);

    ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
    Assert.assertNotNull(clienteConsultado);

    clienteConsultado.setNome("Carlos Montealto");
    clienteDao.alterar(clienteConsultado);

    ClienteJpa clienteAlterado = clienteDao.consultar(
      clienteConsultado.getId()
    );
    Assert.assertNotNull(clienteAlterado);
    Assert.assertEquals("Carlos Montealto", clienteAlterado.getNome());

    clienteDao.excluir(cliente);
    clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
    Assert.assertNull(clienteConsultado);
  }

  @Test
  public void buscarTodos()
    throws TipoChaveNaoEncontradaException, DAOException {
    ClienteJpa cliente = criarCliente();
    ClienteJpa retorno = clienteDao.cadastrar(cliente);
    Assert.assertNotNull(retorno);

    ClienteJpa cliente1 = criarCliente();
    ClienteJpa retorno1 = clienteDao.cadastrar(cliente1);
    Assert.assertNotNull(retorno1);

    Collection<ClienteJpa> list = clienteDao.buscarTodos();
    assertTrue(list != null);
    assertTrue(list.size() == 2);

    list.forEach(cli -> {
      try {
        clienteDao.excluir(cli);
      } catch (DAOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });

    Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
    assertTrue(list1 != null);
    assertTrue(list1.size() == 0);
  }

  private ClienteJpa criarCliente() {
    ClienteJpa cliente = new ClienteJpa();
    cliente.setCpf(rd.nextLong());
    cliente.setNome("Carlos");
    cliente.setCidade("São Paulo");
    cliente.setEnd("End");
    cliente.setEstado("SP");
    cliente.setNumero(10);
    cliente.setTel(1199999999L);
    return cliente;
  }
}
