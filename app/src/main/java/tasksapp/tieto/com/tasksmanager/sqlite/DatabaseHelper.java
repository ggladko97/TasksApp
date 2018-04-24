package tasksapp.tieto.com.tasksmanager.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tasksapp.tieto.com.tasksmanager.domain.UserData;

/**
 * Created by hladlyev on 03.04.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + "Users " + "(" + "id" + " INTEGER PRIMARY KEY," + "userName"
            + " TEXT," + "userPassword" + " TEXT"  + ")";

    private static final String CREATE_TABLE_USER_DATA = "CREATE TABLE "
            + "UserData " + "(" + "id" + " INTEGER PRIMARY KEY," + "userId"
            + " INTEGER ," + "allCreatedTasks" + " INTEGER, allCompletedTasks INTEGER, allScheduleTasks INTEGER, " +
            "personalErrSize INTEGER, workProjSize INTEGER, grocListSize INTEGER, schoolListSize INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, "TasksApp.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_USER_DATA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "Users");
        db.execSQL("DROP TABLE IF EXISTS " + "UserData");

        onCreate(db);
    }

    public long createUser(UserData userData) {
        SQLiteDatabase db = this.getWritableDatabase();

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
}
