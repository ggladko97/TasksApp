package tasksapp.tieto.com.tasksmanager.dao;

import android.app.Application;

import java.util.List;

import tasksapp.tieto.com.tasksmanager.TasksApp;
import tasksapp.tieto.com.tasksmanager.domain.User;

/**
 * Created by hladlyev on 24.04.2018.
 */

public class UserDao implements IGenericDao<User> {

    private tasksapp.tieto.com.tasksmanager.domain.UserDao dao;

    public UserDao(Application app) {
        this.dao = ((TasksApp) app).getDaoSession().getUserDao();
    }

    @Override
    public User findOne(long id) {
        return dao.load(id);
    }

    @Override
    public List<User> findAll() {
        return dao.loadAll();
    }

    @Override
    public void create(User entity) {
        dao.insert(entity);
    }

    @Override
    public void update(User entity) {
        dao.update(entity);
    }

    @Override
    public void delete(User entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        dao.deleteByKey(entityId);
    }
}
