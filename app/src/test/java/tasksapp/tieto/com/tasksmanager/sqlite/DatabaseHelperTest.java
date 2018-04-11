package tasksapp.tieto.com.tasksmanager.sqlite;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;

import tasksapp.tieto.com.tasksmanager.dao.UserDataDao;
import tasksapp.tieto.com.tasksmanager.domain.User;
import tasksapp.tieto.com.tasksmanager.domain.UserData;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by hladlyev on 04.04.2018.
 */
public class DatabaseHelperTest {

//    private DatabaseHelper dbHelper;
    private UserDataDao dao;

    @Before
    public void setUp() throws Exception {
        Context context = mock(Context.class);
//        dbHelper = new DatabaseHelper(context);
        dao = new UserDataDao(context);

    }

    @Test
    public void when_insertUserIntoDb_expect_sameUser() {
        //when
        long user = dao.createUser(initMockData());

        //then
        assertEquals(1, user);
    }

    private UserData initMockData() {
        User user = new User();
        user.setUserName("Yevhenii");
        user.setUserId(0);
        user.setUserPassword("123");

        UserData userData = new UserData();
        userData.setAllCompletedTasks(15);
        userData.setAllCreatedTasks(22);
        userData.setAllScheduleTasks(8);
        userData.setWorkProjSize(2);
        userData.setGrocListSize(1);
        userData.setPersonalErrSize(4);
        userData.setUser(user);
        userData.setSchoolListSize(2);
        return userData;
    }


}