package br.com.calto.vendas_online.controller;

import br.com.calto.vendas_online.domain.Product;
import br.com.calto.vendas_online.domain.Product.Status;
import br.com.calto.vendas_online.usecase.FindProductUseCase;
import br.com.calto.vendas_online.usecase.RegisterProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

  private FindProductUseCase findProduct;
  private RegisterProductUseCase registerProduct;

  @GetMapping
  @Operation(summary = "Busca uma lista paginada de produtos")
  public ResponseEntity<Page<Product>> find(Pageable pageable) {
    return ResponseEntity.ok(findProduct.find(pageable));
  }

  @GetMapping(value = "/status/{status}")
  @Operation(summary = "Busca uma lista paginada de produtos por status")
  public ResponseEntity<Page<Product>> findByStatus(
    Pageable pageable,
    @PathVariable(value = "status", required = true) Status status
  ) {
    return ResponseEntity.ok(findProduct.find(pageable, status));
  }

  @GetMapping(value = "/{codigo}")
  @Operation(summary = "Busca um produto pelo codigo")
  public ResponseEntity<Product> findByCode(String code) {
    return ResponseEntity.ok(findProduct.findByCode(code));
  }

  @PostMapping
  @Operation(summary = "Cadastrar um produto")
  public ResponseEntity<Product> register(@RequestBody @Valid Product product) {
    return ResponseEntity.ok(registerProduct.register(product));
  }

  @PutMapping
  @Operation(summary = "Atualiza um produto")
  public ResponseEntity<Product> update(@RequestBody @Valid Product product) {
    return ResponseEntity.ok(registerProduct.update(product));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Remove um produto pelo seu identificador único")
  public ResponseEntity<String> remove(@PathVariable(value = "id") String id) {
    registerProduct.remove(id);
    return ResponseEntity.ok("Removido com sucesso");
  }
}
