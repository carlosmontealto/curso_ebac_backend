package br.com.calto.dao;

import br.com.calto.dao.generics.GenericDao;
import br.com.calto.entities.Fabricante;

public class FabricanteDAO
  extends GenericDao<Fabricante, String>
  implements IFabricanteDAO {}
