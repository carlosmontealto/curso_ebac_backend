package br.com.calto.dao;

import br.com.calto.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.calto.dao.jpa.IVendaJpaDAO;
import br.com.calto.domain.jpa.VendaJpa;
import br.com.calto.exceptions.DAOException;
import br.com.calto.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDAO
  extends GenericJpaDB1DAO<VendaJpa, Long>
  implements IVendaJpaDAO {

  public VendaExclusaoJpaDAO() {
    super(VendaJpa.class);
  }

  @Override
  public void finalizarVenda(VendaJpa venda)
    throws TipoChaveNaoEncontradaException, DAOException {
    throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
  }

  @Override
  public void cancelarVenda(VendaJpa venda)
    throws TipoChaveNaoEncontradaException, DAOException {
    throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
  }

  @Override
  public VendaJpa consultarComCollection(Long id) {
    throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
  }
}
