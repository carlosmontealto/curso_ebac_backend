public abstract class GenericCar {

  private String modelo;
  private String fabricante;
  private Integer ano;
  private Double preco;

  public abstract void Construtor();

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setFabricante(String fabricante) {
    this.fabricante = fabricante;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  @Override
  public String toString() {
    return "modelo = " + modelo + ", fabricante = " + fabricante + ", ano = " + ano + ", preço = " + preco;
  }

}
