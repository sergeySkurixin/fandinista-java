package jbreathe.fandinista.dao.gen;

import java.util.List;

/**
 * Интерфейс для CRUD операций в dao.
 *
 * @param <T>  тип сущности
 * @param <ID> тип primary key
 */
public interface CrudDao<T, ID> {

    /**
     * Сохранение сущности.
     *
     * @param entity сущность для сохранения
     * @return сохраненную сущность
     */
    T save(T entity);

    /**
     * Нахождение сущности по primary key.
     *
     * @param id primary key
     * @return найденную сущность или null
     */
    T findById(ID id);

    /**
     * Список сущностей.
     *
     * @return список сущностей
     */
    List<T> findAll();

    /**
     * Обновление сущности. Primary key сущности не может быть null, иначе обновления не произойдет.
     *
     * @param entity сущность для обновления
     * @return обновленную сущность
     */
    T update(T entity);

    /**
     * Удаление сущности по primary key.
     *
     * @param id primary key
     */
    void delete(ID id);
}
