package br.com.calto.vendas_online.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Cliente", description = "Cliente")
public class Client {

  @Id
  @Schema(description = "Identificador único")
  private String id;

  @NotBlank
  @Size(min = 1, max = 50)
  @Schema(description = "Nome", minLength = 1, maxLength = 50, nullable = false)
  private String name;

  @NotNull
  @Indexed(unique = true, background = true)
  @Schema(description = "CPF", nullable = false)
  private Long cpf;

  @NotNull
  @Schema(description = "Telefone", nullable = false)
  private Long phone;

  @NotBlank
  @Size(min = 1, max = 50)
  @Indexed(unique = true, background = true)
  @Schema(
    description = "Email",
    minLength = 1,
    maxLength = 50,
    nullable = false
  )
  @Email
  private String email;
}
