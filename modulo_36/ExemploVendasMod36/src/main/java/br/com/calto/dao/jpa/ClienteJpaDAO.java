package br.com.calto.dao.jpa;

import br.com.calto.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.calto.domain.jpa.ClienteJpa;

public class ClienteJpaDAO
  extends GenericJpaDB1DAO<ClienteJpa, Long>
  implements IClienteJpaDAO<ClienteJpa> {

  public ClienteJpaDAO() {
    super(ClienteJpa.class);
  }
}
