package tasksapp.tieto.com.tasksmanager;

import android.app.Application;

import tasksapp.tieto.com.tasksmanager.domain.DaoMaster;
import tasksapp.tieto.com.tasksmanager.domain.DaoSession;
import tasksapp.tieto.com.tasksmanager.domain.Project;
import tasksapp.tieto.com.tasksmanager.domain.User;
import tasksapp.tieto.com.tasksmanager.domain.UserData;
import tasksapp.tieto.com.tasksmanager.sqlite.DbOpenHelper;

/**
 * Created by hladlyev on 18.04.2018.
 */

public class TasksApp extends Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession =
                new DaoMaster(new DbOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();



        Project project = new Project();
        project.setId(null);
        project.setTitle("Do the lanudry");
        project.setIsDone(false);
        project.setEndDate("2018-04-22");
        project.setEndTime("9-00 AM");


        User user = new User(null, "Yevhenii", "abc");




        // USER CREATION FOR DEMO PURPOSE
        if (mDaoSession.getProjectDao().loadAll().size() == 0) {
            mDaoSession.getProjectDao().insert(project);
            long insert = mDaoSession.getUserDao().insert(user);
            UserData userData = new UserData(null, insert, 5, 5, 5, 5, 5, 5, 5);
//            userData.setUserId(insert);
            mDaoSession.getUserDataDao().insert(userData);
        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
