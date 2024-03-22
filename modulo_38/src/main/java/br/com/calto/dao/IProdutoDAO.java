package br.com.calto.dao;

import br.com.calto.dao.generic.IGenericDAO;
import br.com.calto.domain.Produto;
import java.util.List;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {
  List<Produto> filtrarProdutos(String query);
}
