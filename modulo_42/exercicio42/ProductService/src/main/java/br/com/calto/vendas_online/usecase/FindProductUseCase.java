package br.com.calto.vendas_online.usecase;

import br.com.calto.vendas_online.domain.Product;
import br.com.calto.vendas_online.domain.Product.Status;
import br.com.calto.vendas_online.exception.EntityNotFoundException;
import br.com.calto.vendas_online.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindProductUseCase {

  private IProductRepository productRepository;

  public Page<Product> find(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  public Page<Product> find(Pageable pageable, Status status) {
    return productRepository.findAllByStatus(pageable, status);
  }

  public Product findByCode(String code) {
    return productRepository
      .findByCode(code)
      .orElseThrow(() ->
        new EntityNotFoundException(Product.class, "code", code)
      );
  }
}
