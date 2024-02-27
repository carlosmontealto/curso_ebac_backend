package br.com.calto.entities;

import java.util.List;
import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "tb_fabricante")
public class Fabricante implements Persistence {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "fabricante_seq"
  )
  @SequenceGenerator(
    name = "fabricante_seq",
    sequenceName = "sq_fabricante",
    initialValue = 1,
    allocationSize = 1
  )
  private Long id;

  @Column(name = "CODIGO", nullable = false, length = 10)
  private String codigo;

  @Column(name = "NOME", nullable = false, length = 50)
  private String nome;

  @OneToMany(mappedBy = "fabricante")
  private List<Carro> carros;
}
