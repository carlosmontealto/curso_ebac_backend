package br.com.calto.dao;

import br.com.calto.domain.Produto;
import br.com.calto.exception.TipoChaveNaoEncontradaException;
import java.util.Collection;

public class ProdutoDaoMock implements IProdutoDAO {

  @Override
  public Boolean cadastrar(Produto entity)
    throws TipoChaveNaoEncontradaException {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public void excluir(Long valor) {
    // TODO Auto-generated method stub

  }

  @Override
  public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
    // TODO Auto-generated method stub

  }

  @Override
  public Produto consultar(Long valor) {
    Produto produto = new Produto();
    produto.setCodigo(valor);
    return produto;
  }

  @Override
  public Collection<Produto> buscarTodos() {
    // TODO Auto-generated method stub
    return null;
  }
}
