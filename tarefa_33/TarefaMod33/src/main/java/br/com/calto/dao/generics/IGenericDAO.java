package br.com.calto.dao.generics;

import br.com.calto.entities.Persistence;
import java.io.Serializable;

public interface IGenericDAO<T extends Persistence, E extends Serializable> {
  public T cadastrar(T entity);
  // public T consultar(E valor);

  // public T alterar(T entity, E valor);

  // public T excluir(E valor);
}
