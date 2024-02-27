package br.com.rpires.service;

import br.com.rpires.dao.IContratoDao;

/**
 * @author rodrigo.pires
 */
public class ContratoService implements IContratoService {

  private IContratoDao contratoDao;

  public ContratoService(IContratoDao dao) {
    this.contratoDao = dao;
  }

  @Override
  public String salvar() {
    contratoDao.salvar();
    return "Sucesso";
  }

  @Override
  public String buscar(String codigo) {
    contratoDao.buscar(codigo);
    return "Sucesso";
  }

  @Override
  public String atualizar(String codigo) {
    contratoDao.atualizar(codigo);
    return "Sucesso";
  }

  @Override
  public String excluir(String codigo) {
    contratoDao.excluir(codigo);
    return "Sucesso";
  }
}
