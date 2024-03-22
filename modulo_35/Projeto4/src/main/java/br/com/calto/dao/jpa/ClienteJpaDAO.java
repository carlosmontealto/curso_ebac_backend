package br.com.calto.dao.jpa;

import br.com.calto.dao.generic.jpa.GenericJpaDAO;
import br.com.calto.domain.jpa.ClienteJpa;

public class ClienteJpaDAO
  extends GenericJpaDAO<ClienteJpa, Long>
  implements IClienteJpaDAO {

  public ClienteJpaDAO() {
    super(ClienteJpa.class);
  }
}
