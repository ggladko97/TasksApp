package tasksapp.tieto.com.tasksmanager.presenter;

import android.content.Context;

import tasksapp.tieto.com.tasksmanager.HomeActivity;
import tasksapp.tieto.com.tasksmanager.dao.UserDataDao;


public class HomeScreenPresenter implements HomeScreenContract.Presenter {

    private HomeActivity view;
    private UserDataDao dao;

    public HomeScreenPresenter(Context ctx) {
        dao = new UserDataDao(ctx);
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
