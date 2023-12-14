package br.com.calto;

public abstract class Pessoa {

  private String nome;
  private String endereco;
  private Long telefone;

  public String getNome() {
    return nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public Long getTelefone() {
    return telefone;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setTelefone(Long telefone) {
    this.telefone = telefone;
  }

}
