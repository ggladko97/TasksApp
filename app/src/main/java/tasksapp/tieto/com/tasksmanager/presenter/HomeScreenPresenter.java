package tasksapp.tieto.com.tasksmanager.presenter;

import android.app.Application;
import android.content.Context;

import tasksapp.tieto.com.tasksmanager.HomeActivity;
import tasksapp.tieto.com.tasksmanager.dao.UserDataDaoService;


public class HomeScreenPresenter implements HomeScreenContract.Presenter {

    private HomeActivity view;
    private UserDataDaoService dao;

    public HomeScreenPresenter(Context ctx) {
        dao = new UserDataDaoService(ctx);
    }

    public HomeScreenPresenter(Context ctx, Application application) {
        dao = new UserDataDaoService(ctx, application);
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
        view.loadMainScreen(dao.getAllData().get(0));
    }
}
