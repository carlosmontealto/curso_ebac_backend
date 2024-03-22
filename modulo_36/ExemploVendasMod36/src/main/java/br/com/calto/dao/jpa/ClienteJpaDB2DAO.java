package br.com.calto.dao.jpa;

import br.com.calto.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.calto.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO
  extends GenericJpaDB2DAO<ClienteJpa, Long>
  implements IClienteJpaDAO<ClienteJpa> {

  public ClienteJpaDB2DAO() {
    super(ClienteJpa.class);
  }
}
