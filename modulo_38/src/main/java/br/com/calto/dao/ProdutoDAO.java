package br.com.calto.dao;

import br.com.calto.dao.generic.GenericDAO;
import br.com.calto.domain.Produto;
import java.util.List;
import javax.persistence.TypedQuery;

public class ProdutoDAO
  extends GenericDAO<Produto, String>
  implements IProdutoDAO {

  public ProdutoDAO() {
    super(Produto.class);
  }

  @Override
  public List<Produto> filtrarProdutos(String query) {
    TypedQuery<Produto> tpQuery =
      this.entityManager.createNamedQuery(
          "Produto.findByNome",
          this.persistenteClass
        );
    tpQuery.setParameter("nome", "%" + query + "%");
    return tpQuery.getResultList();
  }
}
