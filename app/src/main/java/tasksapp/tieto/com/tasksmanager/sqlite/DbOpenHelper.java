package tasksapp.tieto.com.tasksmanager.sqlite;

import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import tasksapp.tieto.com.tasksmanager.domain.DaoMaster;

/**
 * Created by hladlyev on 18.04.2018.
 */

public class DbOpenHelper extends DaoMaster.OpenHelper {

    public DbOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
        switch (oldVersion) {
            case 1:
            case 2:
                //db.execSQL("ALTER TABLE " + UserDao.TABLENAME + " ADD COLUMN " + UserDao.Properties.Name.columnName + " TEXT DEFAULT 'DEFAULT_VAL'");
        }
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
