package br.com.calto.service;

import br.com.calto.dao.IProdutoDAO;
import br.com.calto.domain.Produto;
import br.com.calto.services.generic.GenericService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProdutoService
  extends GenericService<Produto, String>
  implements IProdutoService {

  private IProdutoDAO produtoDao;

  @Inject
  public ProdutoService(IProdutoDAO produtoDao) {
    super(produtoDao);
    this.produtoDao = produtoDao;
  }

  @Override
  public List<Produto> filtrarProdutos(String query) {
    return produtoDao.filtrarProdutos(query);
  }
}
