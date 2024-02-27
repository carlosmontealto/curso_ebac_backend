package br.com.calto.dao;

import br.com.calto.dao.generics.GenericDao;
import br.com.calto.entities.Acessorio;

public class AcessorioDAO
  extends GenericDao<Acessorio, String>
  implements IAcessorioDAO {}
