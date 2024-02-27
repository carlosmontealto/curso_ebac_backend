package br.com.calto.dao;

import br.com.calto.dao.generics.GenericDAO;
import br.com.calto.domain.Venda;
import br.com.calto.domain.Venda.Status;
import br.com.calto.exception.TipoChaveNaoEncontradaException;

public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

  @Override
  public Class<Venda> getTipoClasse() {
    return Venda.class;
  }

  @Override
  public void atualiarDados(Venda entity, Venda entityCadastrado) {
    entityCadastrado.setCodigo(entity.getCodigo());
    entityCadastrado.setStatus(entity.getStatus());
  }

  @Override
  public void excluir(Long valor) {
    throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
  }

  @Override
  public void finalizarVenda(Venda venda)
    throws TipoChaveNaoEncontradaException {
    venda.setStatus(Status.CONCLUIDA);
    super.alterar(venda);
  }
}
