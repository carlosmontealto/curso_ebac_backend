package br.com.calto.vendas_online.usecase;

import br.com.calto.vendas_online.domain.Client;
import br.com.calto.vendas_online.exception.EntityNotFoundException;
import br.com.calto.vendas_online.repository.IClientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindClientUseCase {

  @Autowired
  private IClientRepository clientRepository;

  public Page<Client> search(Pageable pageable) {
    return clientRepository.findAll(pageable);
  }

  public Client findById(String id) {
    return clientRepository
      .findById(id)
      .orElseThrow(() -> new EntityNotFoundException(Client.class, "id", id));
  }

  public Boolean isRegistered(String id) {
    Optional<Client> client = clientRepository.findById(id);
    return client.isPresent() ? true : false;
  }

  public Client findByCpf(Long cpf) {
    return clientRepository
      .findByCpf(cpf)
      .orElseThrow(() ->
        new EntityNotFoundException(Client.class, "cpf", String.valueOf(cpf))
      );
  }
}
