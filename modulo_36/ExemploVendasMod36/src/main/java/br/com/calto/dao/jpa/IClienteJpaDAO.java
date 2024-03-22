package br.com.calto.dao.jpa;

import br.com.calto.dao.generic.jpa.IGenericJapDAO;
import br.com.calto.domain.jpa.Persistente;

public interface IClienteJpaDAO<T extends Persistente>
  extends IGenericJapDAO<T, Long> {}
