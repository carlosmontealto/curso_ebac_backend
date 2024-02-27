package br.com.rpires.service;

/**
 * @author rodrigo.pires
 */
public interface IContratoService {
  String salvar();

  String buscar(String codigo);

  String atualizar(String codigo);

  String excluir(String codigo);
  //TODO
  //Fazer métodos de buscar, excluir e atualizar
}
