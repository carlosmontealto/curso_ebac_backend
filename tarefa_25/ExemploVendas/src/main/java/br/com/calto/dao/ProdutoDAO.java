package br.com.calto.dao;

import br.com.calto.dao.generics.GenericDAO;
import br.com.calto.domain.Produto;

public class ProdutoDAO
  extends GenericDAO<Produto, Long>
  implements IProdutoDAO {

  public ProdutoDAO() {
    super();
  }

  @Override
  public Class<Produto> getTipoClasse() {
    return Produto.class;
  }

  @Override
  public void atualiarDados(Produto entity, Produto entityCadastrado) {
    entityCadastrado.setCodigo(entity.getCodigo());
    entityCadastrado.setDescricao(entity.getDescricao());
    entityCadastrado.setNome(entity.getNome());
    entityCadastrado.setValor(entity.getValor());
  }
}
