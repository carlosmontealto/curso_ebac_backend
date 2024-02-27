package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 */
public interface IContratoDao {
  void salvar();

  void buscar(String codigo);

  void excluir(String codigo);

  void atualizar(String codigo);
  //TODO
  //Fazer métodos de buscar, excluir e atualizar
}
