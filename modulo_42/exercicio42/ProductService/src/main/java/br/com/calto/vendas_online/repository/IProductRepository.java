package br.com.calto.vendas_online.repository;

import br.com.calto.vendas_online.domain.Product;
import br.com.calto.vendas_online.domain.Product.Status;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends MongoRepository<Product, String> {
  Optional<Product> findByCode(String codigo);

  Page<Product> findAllByStatus(Pageable pageable, Status status);
}
