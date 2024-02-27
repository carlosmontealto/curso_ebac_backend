package br.com.calto.dao.generics;

import br.com.calto.entities.Persistence;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class GenericDao<T extends Persistence, E extends Serializable>
  implements IGenericDAO<T, E> {

  public T cadastrar(T entity) {
    EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory(
      "FabricantesCarros"
    );
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    entityManager.persist(entity);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();

    return entity;
  }
}
