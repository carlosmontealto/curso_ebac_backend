package br.com.calto.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@Data
@Builder
@Entity(name = "tb_carro")
public class Carro implements Persistence {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
  @SequenceGenerator(
    name = "carro_seq",
    sequenceName = "sq_carro",
    initialValue = 1,
    allocationSize = 1
  )
  private Long id;

  @Column(name = "CODIGO", nullable = false, length = 10)
  private String codigo;

  @Column(name = "MODELO", nullable = false, length = 50)
  private String modelo;

  @Column(name = "ANO", nullable = false, length = 4)
  private Long ano;

  @ManyToOne
  @JoinColumn(
    name = "id_fabricante_fk",
    referencedColumnName = "id",
    nullable = false
  )
  private Fabricante fabricante;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "TB_CARRO_ACESSORIO",
    joinColumns = { @JoinColumn(name = "id_carro_fk") },
    inverseJoinColumns = { @JoinColumn(name = "id_acessorio_fk") }
  )
  private List<Acessorio> acessorios;

  public Carro() {
    this.acessorios = new ArrayList<>();
  }

  public void adicionarAcessorio(Acessorio acessorio) {
    this.acessorios.add(acessorio);
  }
}
