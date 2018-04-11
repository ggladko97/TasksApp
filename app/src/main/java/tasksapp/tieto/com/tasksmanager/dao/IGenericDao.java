package tasksapp.tieto.com.tasksmanager.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hladlyev on 09.04.2018.
 */

public interface IGenericDao<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}