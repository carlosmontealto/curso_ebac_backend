package br.com.calto;

public class App {

  public static void main(String[] args) {

    PessoaFisica pessoaFisica = new PessoaFisica();
    pessoaFisica.setNome("Carlos");
    pessoaFisica.setIdade(25);
    pessoaFisica.setCpf(12345678912L);
    pessoaFisica.setTelefone(1112341234L);
    pessoaFisica.setEndereco("Rua Teste, 1234");

    PessoaJuridica pessoaJuridica = new PessoaJuridica();
    pessoaJuridica.setNome("A F da Silva");
    pessoaJuridica.setCnpj(12123123000110L);
    pessoaJuridica.setEndereco("Av Teste 2, 12345");
    pessoaJuridica.setTelefone(1212341234L);
    pessoaJuridica.setAtividadeEconomica("Comércio de bebidas");

    System.out.println(pessoaFisica.toString());
    System.out.println(pessoaJuridica.toString());

  }
}
