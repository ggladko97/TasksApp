package tasksapp.tieto.com.tasksmanager.dao;

import android.app.Application;

import java.util.List;

import tasksapp.tieto.com.tasksmanager.TasksApp;
import tasksapp.tieto.com.tasksmanager.domain.UserData;

/**
 * Created by hladlyev on 24.04.2018.
 */

public class UserDataDao implements IGenericDao<UserData> {


    private tasksapp.tieto.com.tasksmanager.domain.UserDataDao dao;

    public UserDataDao(Application app) {
        this.dao = ((TasksApp) app).getDaoSession().getUserDataDao();
    }

    @Override
    public UserData findOne(long id) {
        return dao.load(id);
    }

    @Override
    public List<UserData> findAll() {
        return dao.loadAll();
    }

    @Override
    public void create(UserData entity) {
        dao.insert(entity);
    }

    @Override
    public void update(UserData entity) {
        dao.update(entity);
    }

    @Override
    public void delete(UserData entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        dao.deleteByKey(entityId);
    }
}
