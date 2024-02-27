package br.com.calto;

import static org.junit.Assert.assertNotNull;

import br.com.calto.dao.AcessorioDAO;
import br.com.calto.dao.CarroDAO;
import br.com.calto.dao.FabricanteDAO;
import br.com.calto.dao.IAcessorioDAO;
import br.com.calto.dao.ICarroDAO;
import br.com.calto.dao.IFabricanteDAO;
import br.com.calto.entities.Acessorio;
import br.com.calto.entities.Carro;
import br.com.calto.entities.Fabricante;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CarroTest {

  private ICarroDAO carroDAO;
  private IFabricanteDAO fabricanteDAO;
  private IAcessorioDAO acessorioDAO;

  public CarroTest() {
    carroDAO = new CarroDAO();
    fabricanteDAO = new FabricanteDAO();
    acessorioDAO = new AcessorioDAO();
  }

  @Test
  public void testCarro() {
    Acessorio acessorio1 = criarAcessorio("A1");
    Acessorio acessorio2 = criarAcessorio("A2");
    Fabricante fabricante = criarFabricante("A1");

    Carro carro = new Carro();
    carro.setAno(2024L);
    carro.setCodigo("A1");
    carro.setModelo("Picanto");
    carro.setFabricante(fabricante);
    carro.adicionarAcessorio(acessorio1);
    carro.adicionarAcessorio(acessorio2);

    carro = carroDAO.cadastrar(carro);

    assertNotNull(carro);
    assertNotNull(carro.getId());
  }

  private Fabricante criarFabricante(String codigo) {
    Fabricante fabricante = new Fabricante();
    fabricante.setCodigo(codigo);
    fabricante.setNome("KIA");
    return fabricanteDAO.cadastrar(fabricante);
  }

  private Acessorio criarAcessorio(String codigo) {
    Acessorio acessorio = new Acessorio();
    acessorio.setCodigo(codigo);
    acessorio.setDescricao("Descrição do acessório " + codigo);
    acessorio.setNome("Acessório " + codigo);

    return acessorio;
  }
}
