package tasksapp.tieto.com.tasksmanager.presenter;

import android.app.Application;

import tasksapp.tieto.com.tasksmanager.AdditionActivity;
import tasksapp.tieto.com.tasksmanager.dao.WorkProjectDao;
import tasksapp.tieto.com.tasksmanager.domain.Project;

/**
 * Created by hladlyev on 12.04.2018.
 */

public class AddTaskPresenter implements AddTaskContract.Presenter {

    private AdditionActivity view;
    private WorkProjectDao dao;

    public AddTaskPresenter(Application app) {
        dao = new WorkProjectDao(app);
    }

    @Override
    public void bindView(AddTaskContract.View view) {
        this.view = (AdditionActivity) view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    public void saveProject(Project prj) {
        dao.create(prj);
        view.successAddition();
    }
}
