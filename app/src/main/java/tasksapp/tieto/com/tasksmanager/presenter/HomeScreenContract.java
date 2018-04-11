package tasksapp.tieto.com.tasksmanager.presenter;

import tasksapp.tieto.com.tasksmanager.domain.UserData;

/**
 * Created by hladlyev on 02.01.2018.
 */

public interface HomeScreenContract {
    interface View {
        void loadMainScreen(UserData allData);
    }

    interface Presenter extends BasePresenter<View> {

    }
}