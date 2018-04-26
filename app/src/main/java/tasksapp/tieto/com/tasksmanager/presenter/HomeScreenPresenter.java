package tasksapp.tieto.com.tasksmanager.presenter;

import android.app.Application;
import android.util.Log;

import java.util.List;

import tasksapp.tieto.com.tasksmanager.HomeActivity;
import tasksapp.tieto.com.tasksmanager.dao.UserDataDao;
import tasksapp.tieto.com.tasksmanager.domain.UserData;


public class HomeScreenPresenter implements HomeScreenContract.Presenter {

    private HomeActivity view;
    private UserDataDao dao;


    public HomeScreenPresenter( Application application) {
        dao = new UserDataDao(application);
    }

    @Override
    public void bindView(HomeScreenContract.View view) {
        this.view = (HomeActivity) view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    public void loadData() {
        List<UserData> all = dao.findAll();
        Log.i("HSP", all.toString());
        view.loadMainScreen(dao.findAll().get(0));
    }
}
