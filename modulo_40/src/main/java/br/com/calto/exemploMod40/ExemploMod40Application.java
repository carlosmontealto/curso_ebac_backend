package br.com.calto.exemploMod40;

import br.com.calto.domain.Client;
import br.com.calto.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.calto.repository")
@EntityScan("br.com.calto.*")
@ComponentScan(basePackages = "br.com.calto")
public class ExemploMod40Application implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(
    ExemploMod40Application.class
  );

  @Autowired
  private ClientRepository clientRepository;

  public static void main(String[] args) {
    SpringApplication.run(ExemploMod40Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("Start apllication ...");
    var client = createClient();
    clientRepository.save(client);
  }

  private Client createClient() {
    return Client
      .builder()
      .name("Carlos Montealto")
      .address("Teste, 123")
      .city("São Paulo")
      .cpf(12345678911L)
      .email("teste@teste.com")
      .phone(11912341234L)
      .state("SP")
      .build();
  }
}
