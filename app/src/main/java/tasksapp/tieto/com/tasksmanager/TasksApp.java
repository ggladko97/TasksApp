package tasksapp.tieto.com.tasksmanager;

import android.app.Application;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

import java.util.Collection;

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
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this, "greendao_demo.db");
        Database writableDatabase = dbOpenHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        DaoMaster.createAllTables(dbOpenHelper.getWritableDb(), true);

        mDaoSession = daoMaster.newSession();


        Collection<AbstractDao<?, ?>> allDaos = mDaoSession.getAllDaos();

        Project project = new Project();
        project.setId(null);
        project.setTitle("Do the lanudry");
        project.setIsDone(false);
        project.setEndDate("2018-04-22");
        project.setEndTime("9-00 AM");


        User user = new User();
        user.setId(null);
        user.setUserPassword("abc");
        user.setUserName("Yevhenii");


        mDaoSession.getProjectDao().insert(project);

        long insert = mDaoSession.getUserDao().insert(user);
        UserData userData = new UserData(null, insert, 5, 5, 5, 5, 5, 5, 5);

        mDaoSession.getUserDataDao().insert(userData);

    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
