package br.com.calto.services;

import br.com.calto.dao.IProdutoDAO;
import br.com.calto.domain.Produto;
import br.com.calto.services.generic.GenericService;

public class ProdutoService
  extends GenericService<Produto, String>
  implements IProdutoService {

  public ProdutoService(IProdutoDAO dao) {
    super(dao);
  }
}
