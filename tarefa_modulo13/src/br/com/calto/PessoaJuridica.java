package br.com.calto;

public class PessoaJuridica extends Pessoa {
  private Long cnpj;
  private String atividadeEconomica;

  public Long getCnpj() {
    return cnpj;
  }

  public void setCnpj(Long cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public String toString() {
    return "Pessoa Jurídica [nome = " + this.getNome() + ", CNPJ = " + this.getCnpj() + ", Atividade Econômica = "
        + this.getAtividadeEconomica()
        + ", Telefone = " + this.getTelefone() + ", Endereço = " + this.getEndereco() + "]";
  }

  public String getAtividadeEconomica() {
    return atividadeEconomica;
  }

  public void setAtividadeEconomica(String atividadeEconomica) {
    this.atividadeEconomica = atividadeEconomica;
  }

}
