package jbreathe.fandinista.dao.gen;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Класс, выполняющий CRUD операции.
 * Если нам нужны все CRUD операции, можно от него наследоваться.
 * Если нам нужно лишь какое-то подмножество CRUD операций,
 * можно использовать {@link org.springframework.beans.factory.annotation.Autowired} и композицию.
 *
 * @param <T> тип сущности
 */
public class GenericCrudDao<T> implements SimplifiedCrudDao<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> tClass;

    public GenericCrudDao() {
        // наивная реализация получения класса из первого параметра.
        @SuppressWarnings("unchecked")
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.tClass = tClass;
    }

    @Override
    public T save(T entity) {
        if (entity == null) {
            throw new NullPointerException(tClass.getSimpleName() + " can't be null.");
        }
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T findById(Long aLong) {
        if (aLong == null) {
            throw new NullPointerException("Id can't be null.");
        }
        return entityManager.find(tClass, aLong);
    }

    @Override
    public List<T> findAll() {
        // наивная реализация получения списка нужных сущностей.
        return entityManager.createQuery("from " + tClass.getSimpleName(), tClass).getResultList();
    }

    @Override
    public T update(T entity) {
        if (entity == null) {
            throw new NullPointerException(tClass.getSimpleName() + " can't be null.");
        }
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Long aLong) {
        if (aLong == null) {
            throw new NullPointerException("Id can't be null.");
        }
        T entity = findById(aLong);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
