package br.com.calto.dao;

import br.com.calto.dao.generic.IGenericDAO;
import br.com.calto.domain.Venda;
import br.com.calto.exceptions.DAOException;
import br.com.calto.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {
  public void finalizarVenda(Venda venda)
    throws TipoChaveNaoEncontradaException, DAOException;

  public void cancelarVenda(Venda venda)
    throws TipoChaveNaoEncontradaException, DAOException;
}
