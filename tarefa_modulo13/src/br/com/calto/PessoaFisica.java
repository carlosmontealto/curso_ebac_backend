package br.com.calto;

public class PessoaFisica extends Pessoa {

  private Long cpf;
  private Integer idade;

  public Long getCpf() {
    return cpf;
  }

  public void setCpf(Long cpf) {
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return "Pessoa Física [nome = " + this.getNome() + ", CPF = " + this.getCpf() + ", Idade = " + this.getIdade()
        + ", Telefone = " + this.getTelefone() + ", Endereço = " + this.getEndereco() + "]";
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

}
