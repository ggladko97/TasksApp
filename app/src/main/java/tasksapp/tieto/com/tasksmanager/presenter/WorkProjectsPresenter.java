package tasksapp.tieto.com.tasksmanager.presenter;

import android.app.Application;
import android.util.Log;

import java.util.List;
import java.util.stream.Collectors;

import tasksapp.tieto.com.tasksmanager.WorkProjectsActivity;
import tasksapp.tieto.com.tasksmanager.dao.WorkProjectDao;
import tasksapp.tieto.com.tasksmanager.domain.Project;


public class WorkProjectsPresenter implements WorkProjectsContract.Presenter, PresenterToAdapterListener {

    private WorkProjectsActivity view;
    private static WorkProjectDao dao;

    public WorkProjectsPresenter(Application app) {
        dao = new WorkProjectDao(app);
    }

    @Override
    public void bindView(WorkProjectsContract.View view) {
        this.view = (WorkProjectsActivity) view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    public void loadData() {
        List<Project> projList = dao.findAll();
        Log.i("Projlist", projList.toString());
        view.updateWPList(projList);
    }
    public void laodCompletedData() {
        List<Project> projList = dao.findAll();
        view.updateWPList(projList.stream().filter(Project::getIsDone).collect(Collectors.toList()));
    }

    @Override
    public void updateProject(Project project) {
        Log.i("PRESENTER", project.toString());
        Project prjToUpdate = dao.findOne(project.getId());
        if (prjToUpdate == null) {
            Log.e("MockDB",  "project with id " + project.getId() + " is null in Db");
        }
        if (prjToUpdate != null) {
            prjToUpdate.setIsDone(true);
        }
        dao.update(prjToUpdate);
    }
}
