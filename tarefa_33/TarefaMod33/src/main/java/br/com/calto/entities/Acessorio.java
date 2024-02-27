package br.com.calto.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Entity(name = "tb_acessorio")
public class Acessorio implements Persistence {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "acessorio_seq"
  )
  @SequenceGenerator(
    name = "acessorio_seq",
    sequenceName = "sq_acessorio",
    initialValue = 1,
    allocationSize = 1
  )
  private Long id;

  @Column(name = "CODIGO", nullable = false, length = 10)
  private String codigo;

  @Column(name = "NOME", nullable = false, length = 50)
  private String nome;

  @Column(name = "DESCRICAO", nullable = false, length = 100)
  private String descricao;

  @ManyToMany(mappedBy = "acessorios")
  private List<Carro> carros;

  public Acessorio() {
    this.carros = new ArrayList<>();
  }

  public void adicionarAcessorios(Carro carro) {
    this.carros.add(carro);
  }
}
