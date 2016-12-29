package jbreathe.fandinista.dao.gen;

/**
 * Упрощенный интерфейс для {@link CrudDao}. В большинстве случаев мы будем использовать Long как primary key.
 *
 * @param <T> тип сущности
 */
public interface SimplifiedCrudDao<T> extends CrudDao<T, Long> {
}
