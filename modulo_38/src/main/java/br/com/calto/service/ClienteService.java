package br.com.calto.service;

import br.com.calto.dao.IClienteDAO;
import br.com.calto.domain.Cliente;
import br.com.calto.exceptions.DAOException;
import br.com.calto.exceptions.MaisDeUmRegistroException;
import br.com.calto.exceptions.TableException;
import br.com.calto.services.generic.GenericService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteService
  extends GenericService<Cliente, Long>
  implements IClienteService {

  private IClienteDAO clienteDAO;

  @Inject
  public ClienteService(IClienteDAO clienteDAO) {
    super(clienteDAO);
    this.clienteDAO = clienteDAO;
  }

  @Override
  public Cliente buscarPorCPF(Long cpf) throws DAOException {
    try {
      return this.dao.consultar(cpf);
    } catch (MaisDeUmRegistroException | TableException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Cliente> filtrarClientes(String query) {
    return clienteDAO.filtrarClientes(query);
  }
}
