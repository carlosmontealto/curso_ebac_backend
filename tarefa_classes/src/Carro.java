/**
 * @author Carlos.Montealto
 */

public class Carro {
  // Criação de um objeto contendo principais dados de um carro.

  private String marca;
  private String modelo;
  private int ano;
  private String motorizacao;
  private String cambio;

  // Construtor da Classe
  public Carro(String marca, String modelo, int ano, String motorizacao, String cambio) {
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.motorizacao = motorizacao;
    this.cambio = cambio;
  }

  /**
   * @return String Retorna a marca do veiculo.
   */
  public String getMarca() {
    return marca;
  }

  /**
   * @param marca Marca do veiculo.
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }

  /**
   * @return String Retorna o modelo do veiculo.
   */
  public String getModelo() {
    return modelo;
  }

  /**
   * @param modelo Modelo do veiculo.
   */
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  /**
   * @return int Retorna o ano de fabricação do carro.
   */
  public int getAno() {
    return ano;
  }

  /**
   * @param ano Ano de fabricação do carro
   */
  public void setAno(int ano) {
    this.ano = ano;
  }

  /**
   * @return String Retorna o tipo de motor e litragem
   */
  public String getMotorizacao() {
    return motorizacao;
  }

  /**
   * @param motorizacao Modelo e litragem do motor.
   */
  public void setMotorizacao(String motorizacao) {
    this.motorizacao = motorizacao;
  }

  /**
   * @return String Retorna o tipo de cambio.
   */
  public String getCambio() {
    return cambio;
  }

  /**
   * @param cambio Modelo do cambio do carro
   */
  public void setCambio(String cambio) {
    this.cambio = cambio;
  }

}
