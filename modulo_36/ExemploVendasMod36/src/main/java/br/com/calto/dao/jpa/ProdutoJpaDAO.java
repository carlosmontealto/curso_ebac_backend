package br.com.calto.dao.jpa;

import br.com.calto.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.calto.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO
  extends GenericJpaDB1DAO<ProdutoJpa, Long>
  implements IProdutoJpaDAO {

  public ProdutoJpaDAO() {
    super(ProdutoJpa.class);
  }
}
