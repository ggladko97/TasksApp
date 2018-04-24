package tasksapp.tieto.com.tasksmanager.presenter;

/**
 * Created by hladlyev on 12.04.2018.
 */

public interface AddTaskContract {
    interface View {
        void successAddition();
    }

    interface Presenter extends BasePresenter<AddTaskContract.View> {

    }
}
