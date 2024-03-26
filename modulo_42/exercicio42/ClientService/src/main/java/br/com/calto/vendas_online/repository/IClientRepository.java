package br.com.calto.vendas_online.repository;

import br.com.calto.vendas_online.domain.Client;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends MongoRepository<Client, String> {
  Optional<Client> findByCpf(Long cpf);
}
