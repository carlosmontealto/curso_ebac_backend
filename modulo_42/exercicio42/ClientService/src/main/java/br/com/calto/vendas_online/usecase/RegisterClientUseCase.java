package br.com.calto.vendas_online.usecase;

import br.com.calto.vendas_online.domain.Client;
import br.com.calto.vendas_online.repository.IClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterClientUseCase {

  @Autowired
  private IClientRepository clientRepository;

  public Client register(@Valid Client client) {
    return clientRepository.save(client);
  }

  public Client update(@Valid Client client) {
    return clientRepository.save(client);
  }

  public void remove(String id) {
    clientRepository.deleteById(id);
  }
}
