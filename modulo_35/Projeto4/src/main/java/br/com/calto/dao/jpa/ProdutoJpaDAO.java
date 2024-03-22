package br.com.calto.dao.jpa;

import br.com.calto.dao.generic.jpa.GenericJpaDAO;
import br.com.calto.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO
  extends GenericJpaDAO<ProdutoJpa, Long>
  implements IProdutoJpaDAO {

  public ProdutoJpaDAO() {
    super(ProdutoJpa.class);
  }
}
