package br.com.calto.service;

import br.com.calto.domain.Produto;
import br.com.calto.services.generic.IGenericService;
import java.util.List;

public interface IProdutoService extends IGenericService<Produto, String> {
  List<Produto> filtrarProdutos(String query);
}
