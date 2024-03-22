package br.com.calto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(length = 50, nullable = false)
  private String name;

  @Column(length = 50, nullable = false, unique = true)
  private String email;

  @Column(length = 11, nullable = false)
  private Long phone;

  @Column(length = 11, nullable = false, unique = true)
  private Long cpf;

  @Column(length = 50, nullable = false)
  private String address;

  @Column(length = 50, nullable = false)
  private String city;

  @Column(length = 50, nullable = false)
  private String state;
}
