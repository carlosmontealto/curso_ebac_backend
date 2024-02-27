package br.com.calto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "TB_PRODUTO")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
  @SequenceGenerator(name = "curso_seq", sequenceName = "sq_curso", initialValue = 1, allocationSize = 1)
  private Long id;

  @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
  private String codigo;

  @Column(name = "NOME", length = 50, nullable = false)
  private String nome;

  @Column(name = "DESCRICAO", length = 100, nullable = false)
  private String descricao;

  @Column(name = "VALOR", length = 10, nullable = false)
  private Double valor;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

}
