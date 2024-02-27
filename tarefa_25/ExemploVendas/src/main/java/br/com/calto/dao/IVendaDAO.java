package br.com.calto.dao;

import br.com.calto.dao.generics.IGenericDAO;
import br.com.calto.domain.Venda;
import br.com.calto.exception.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {
  public void finalizarVenda(Venda venda)
    throws TipoChaveNaoEncontradaException;
}
