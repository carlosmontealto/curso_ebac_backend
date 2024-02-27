package br.com.rpires;

import br.com.rpires.dao.ContratoDao;
import br.com.rpires.dao.IContratoDao;
import br.com.rpires.dao.mocks.ContratoDaoMock;
import br.com.rpires.service.ContratoService;
import br.com.rpires.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author rodrigo.pires
 */
public class ContratoServiceTest {

  @Test
  public void salvarTest() {
    IContratoDao dao = new ContratoDaoMock();
    IContratoService service = new ContratoService(dao);
    String retorno = service.salvar();
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void esperadoErroNoSalvarComBancoDeDadosTest() {
    IContratoDao dao = new ContratoDao();
    IContratoService service = new ContratoService(dao);
    String retorno = service.salvar();
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test
  public void buscarTest() {
    IContratoDao dao = new ContratoDaoMock();
    IContratoService service = new ContratoService(dao);
    String retorno = service.buscar("Teste");
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void esperadoErroNoBuscarComBancoDeDadosTest() {
    IContratoDao dao = new ContratoDao();
    IContratoService service = new ContratoService(dao);
    String retorno = service.buscar("Teste");
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test
  public void atualizarTest() {
    IContratoDao dao = new ContratoDaoMock();
    IContratoService service = new ContratoService(dao);
    String retorno = service.atualizar("Teste");
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void esperadoErroNoAtualizarComBancoDeDadosTest() {
    IContratoDao dao = new ContratoDao();
    IContratoService service = new ContratoService(dao);
    String retorno = service.atualizar("Teste");
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test
  public void excluirTest() {
    IContratoDao dao = new ContratoDaoMock();
    IContratoService service = new ContratoService(dao);
    String retorno = service.excluir("Teste");
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void esperadoErroNoExcluirComBancoDeDadosTest() {
    IContratoDao dao = new ContratoDao();
    IContratoService service = new ContratoService(dao);
    String retorno = service.excluir("Teste");
    Assert.assertEquals("Sucesso", retorno);
  }
  //TODO
  //Fazer métodos de buscar, excluir e atualizar
}
