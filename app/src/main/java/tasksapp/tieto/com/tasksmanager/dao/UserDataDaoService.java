package tasksapp.tieto.com.tasksmanager.dao;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tasksapp.tieto.com.tasksmanager.domain.User;
import tasksapp.tieto.com.tasksmanager.domain.UserData;
import tasksapp.tieto.com.tasksmanager.sqlite.DatabaseHelper;

/**
 * Created by hladlyev on 03.04.2018.
 */
public class UserDataDaoService {
    private List<UserData> mockDatabase;
    private DatabaseHelper dbHelper;

    public UserDataDaoService(Context context) {
        mockDatabase = new ArrayList<>();
        initMockDB();
        dbHelper = new DatabaseHelper(context);
    }

    public UserDataDaoService(Context ctx, Application application) {
        mockDatabase = new ArrayList<>();
        initMockDB();

//        dbHelper = new DatabaseHelper(context);
    }

    public long createUser(UserData userData) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();
        Log.i("a", String.valueOf(db.isOpen()));

        ContentValues values = new ContentValues();
//        values.put("id", userData.getUser().getUserId());
//        values.put("userName", userData.getUser().getUserName());
//        values.put("userPassword", userData.getUser().getUserPassword());

        // insert row
        long userData_id = db.insert("Users", null, values);

        // assigning tags to userData
//        for (long tag_id : tag_ids) {
//            createTodoTag(userData_id, tag_id);
//        }

        return userData_id;
    }

    public List<UserData> getAllData() {
        return mockDatabase;
    }

    private void initMockDB() {
        User user = new User();
        user.setUserName("Yevhenii");
        user.setUserPassword("123");

        UserData userData = new UserData();
        userData.setAllCompletedTasks(15);
        userData.setAllCreatedTasks(22);
        userData.setAllScheduleTasks(8);
        userData.setWorkProjSize(2);
        userData.setGrocListSize(1);
        userData.setPersonalErrSize(4);
//        userData.setUser(user);
        userData.setSchoolListSize(2);

        mockDatabase.add(userData);
    }

}
