package br.com.calto.vendas_online.controller;

import br.com.calto.vendas_online.domain.Client;
import br.com.calto.vendas_online.domain.ClientRegisterDTO;
import br.com.calto.vendas_online.usecase.FindClientUseCase;
import br.com.calto.vendas_online.usecase.RegisterClientUseCase;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

  private final FindClientUseCase findClientUseCase;
  private final RegisterClientUseCase registerClientUseCase;

  @GetMapping
  public ResponseEntity<Page<Client>> search(Pageable pageable) {
    return ResponseEntity.status(200).body(findClientUseCase.search(pageable));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Buscar um cliente pelo ID")
  public ResponseEntity<Client> findById(
    @PathVariable(value = "id", required = true) String id
  ) {
    return ResponseEntity.status(200).body(findClientUseCase.findById(id));
  }

  @GetMapping("isRegistered/{id}")
  public ResponseEntity<Boolean> isRegistered(
    @PathVariable(value = "id", required = true) String id
  ) {
    return ResponseEntity.status(200).body(findClientUseCase.isRegistered(id));
  }

  @PostMapping
  public ResponseEntity<Client> register(@RequestBody ClientRegisterDTO data) {
    Client client = Client
      .builder()
      .name(data.name())
      .cpf(data.cpf())
      .email(data.email())
      .phone(data.phone())
      .build();
    return ResponseEntity
      .status(201)
      .body(registerClientUseCase.register(client));
  }

  @GetMapping("/cpf/{cpf}")
  @Operation(summary = "Buscar um cliente pelo CPF")
  public ResponseEntity<Client> findByCpf(
    @PathVariable(value = "cpf", required = true) Long cpf
  ) {
    return ResponseEntity.status(200).body(findClientUseCase.findByCpf(cpf));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Atualiza um clinete")
  public ResponseEntity<Client> update(
    @RequestBody ClientRegisterDTO data,
    @PathVariable(value = "id", required = true) String id
  ) {
    Client client = Client
      .builder()
      .id(id)
      .name(data.name())
      .cpf(data.cpf())
      .email(data.email())
      .phone(data.phone())
      .build();
    return ResponseEntity
      .status(200)
      .body(registerClientUseCase.update(client));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Remove um cliente pelo seu ID")
  public ResponseEntity<String> remove(
    @PathVariable(value = "id", required = true) String id
  ) {
    registerClientUseCase.remove(id);
    return ResponseEntity.ok("Removido com sucesso");
  }
}
