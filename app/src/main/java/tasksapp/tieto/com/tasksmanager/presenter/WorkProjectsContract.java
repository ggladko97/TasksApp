package tasksapp.tieto.com.tasksmanager.presenter;

import java.util.List;

import tasksapp.tieto.com.tasksmanager.domain.Project;

/**
 * Created by hladlyev on 09.04.2018.
 */

public interface WorkProjectsContract {
    interface View {
       void updateWPList(List<Project> projList);
    }

    interface Presenter extends BasePresenter<WorkProjectsContract.View> {

    }
}
