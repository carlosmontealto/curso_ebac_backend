public class Pessoa implements Comparable<Pessoa> {
  String nome;
  String sexo;

  Pessoa(String nome, String sexo) {
    this.nome = nome;
    this.sexo = sexo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  @Override
  public int compareTo(Pessoa pessoa) {
    return this.nome.compareTo(pessoa.getNome());
  }

  @Override
  public String toString() {
    return nome;
  }

}
