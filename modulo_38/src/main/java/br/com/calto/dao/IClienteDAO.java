package br.com.calto.dao;

import br.com.calto.dao.generic.IGenericDAO;
import br.com.calto.domain.Cliente;
import java.util.List;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {
  List<Cliente> filtrarClientes(String query);
}
