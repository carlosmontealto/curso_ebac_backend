package br.com.calto.services;

import br.com.calto.dao.IProdutoDAO;
import br.com.calto.domain.Produto;
import br.com.calto.services.generics.GenericService;

public class ProdutoService
  extends GenericService<Produto, Long>
  implements IProdutoService {

  public ProdutoService(IProdutoDAO dao) {
    super(dao);
  }
}
