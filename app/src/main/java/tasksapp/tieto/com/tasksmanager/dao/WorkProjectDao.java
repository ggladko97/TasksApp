package tasksapp.tieto.com.tasksmanager.dao;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tasksapp.tieto.com.tasksmanager.TasksApp;
import tasksapp.tieto.com.tasksmanager.domain.Project;
import tasksapp.tieto.com.tasksmanager.domain.ProjectDao;

/**
 * Created by hladlyev on 09.04.2018.
 */

public class WorkProjectDao implements IGenericDao<Project> {

    private static List<Project> mockProjects = new ArrayList<>();
    private ProjectDao dao;

    private void initMockProj() {
        Project project = new Project();
        project.setId(1L);
        project.setTitle("Do the lanudry");
        project.setIsDone(false);
        project.setEndDate("2018-04-22");
        project.setEndTime("9-00 AM");

        Project project1 = new Project();
        project1.setId(2L);
        project1.setTitle("Wash the dishes");
        project1.setIsDone(true);
        project1.setEndDate("2018-04-23");
        project1.setEndTime("5-00 AM");
        mockProjects.add(project);
        mockProjects.add(project1);
    }

    public WorkProjectDao(Application app) {
        dao = ((TasksApp) app).getDaoSession().getProjectDao();
    }

    @Override
    public Project findOne(long id) {
        return dao.load(id);
//        return mockProjects.stream().filter(prj -> prj.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Project> findAll() {
//        Log.i("DAO", mockProjects.toString());
        return dao.loadAll();
//        return mockProjects;
    }

    @Override
    public void create(Project entity) {
//        mockProjects.add(entity);
        long insert = dao.insert(entity);
        Log.i("DAO", "Inserted entity" + entity.toString());
    }

    //old must have same id
    @Override
    public void update(Project entity) {
//        Log.i("DAO", String.valueOf(entity));
//        Project project = mockProjects.stream().filter(prj -> prj.getId().equals(entity.getId())).findFirst().get();
//        project.setTitle(entity.getTitle());
//        project.setEndTime(entity.getTitle());
//        project.setEndTime(entity.getEndTime());
//        project.setIsDone(entity.getDone());

//        return project;
        dao.update(entity);

    }

    @Override
    public void delete(Project entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        dao.deleteByKey(entityId);
    }
}
