package br.com.calto.service;

import br.com.calto.domain.Cliente;
import br.com.calto.exceptions.DAOException;
import br.com.calto.services.generic.IGenericService;
import java.util.List;

public interface IClienteService extends IGenericService<Cliente, Long> {
  Cliente buscarPorCPF(Long cpf) throws DAOException;

  List<Cliente> filtrarClientes(String query);
}
