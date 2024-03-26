package br.com.calto.vendas_online.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

  public enum Status {
    ACTIVE,
    INATIVE,
  }

  @Id
  private String id;

  @NotNull
  @Size(min = 2, max = 10)
  @Indexed(unique = true, background = true)
  private String code;

  @NotNull
  @Size(min = 1, max = 50)
  private String name;

  @NotNull
  @Size(min = 1, max = 50)
  private String description;

  private BigDecimal value;

  private Status status;
}
