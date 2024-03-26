package br.com.calto.vendas_online.usecase;

import br.com.calto.vendas_online.domain.Product;
import br.com.calto.vendas_online.domain.Product.Status;
import br.com.calto.vendas_online.exception.EntityNotFoundException;
import br.com.calto.vendas_online.repository.IProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterProductUseCase {

  @Autowired
  private IProductRepository productRepository;

  public Product register(@Valid Product product) {
    product.setStatus(Status.ACTIVE);
    return productRepository.insert(product);
  }

  public Product update(@Valid Product product) {
    return productRepository.save(product);
  }

  public void remove(String id) {
    Product product = productRepository
      .findById(id)
      .orElseThrow(() -> new EntityNotFoundException(Product.class, "id", id));
    product.setStatus(Status.INATIVE);
    productRepository.save(product);
  }
}
