package jbreathe.fandinista.service.gen;

import java.util.List;

public interface CrudService<T, ID> {

    T save(T dto);

    T findById(ID id);

    List<T> findAll();

    T update(T dto);

    void delete(ID id);
}
