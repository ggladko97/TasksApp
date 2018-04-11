package tasksapp.tieto.com.tasksmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import tasksapp.tieto.com.tasksmanager.domain.UserData;
import tasksapp.tieto.com.tasksmanager.presenter.HomeScreenContract;
import tasksapp.tieto.com.tasksmanager.presenter.HomeScreenPresenter;

public class HomeActivity extends AppCompatActivity implements HomeScreenContract.View {

    private TextView tvUserName, tvDate, tvAllTasksSize, tvCompletedTasksSize, tvAllScheduleSize;
    private TextView tvPersonalErrSize, tvWorkProjectsSize, tvGrocListSize, tvSchoolSize;
    private ImageButton ibSettings;
    private LinearLayout llAllSchedule, llPersErr, llWorkProj, llGrocList, llSchool;

    private HomeScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AdditionActivity.class);
                startActivity(intent);

            }
        });

        presenter = new HomeScreenPresenter(HomeActivity.this);
        presenter.bindView(HomeActivity.this);
        presenter.loadData();

        llWorkProj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WorkProjectsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        tvUserName = findViewById(R.id.tvUserName);
        tvDate = findViewById(R.id.tvMainDate);
        tvAllTasksSize = findViewById(R.id.tvAllTasksSize);
        tvCompletedTasksSize = findViewById(R.id.tvCompletedTasksSize);
        tvAllScheduleSize = findViewById(R.id.tvAllScheduleSize);
        tvPersonalErrSize = findViewById(R.id.tvPersonalErrSize);
        tvWorkProjectsSize = findViewById(R.id.tvWorkProjects);
        tvGrocListSize = findViewById(R.id.tvGroceryList);
        tvSchoolSize = findViewById(R.id.tvStudySize);
        ibSettings = findViewById(R.id.ibSettings);

        llAllSchedule = findViewById(R.id.llAllSchedule);
        llPersErr = findViewById(R.id.llPerErr);
        llWorkProj = findViewById(R.id.llWorkProj);
        llGrocList = findViewById(R.id.llGrocList);
        llSchool = findViewById(R.id.llStudy);

    }

    @Override
    public void loadMainScreen(UserData allData) {
        tvUserName.setText(String.valueOf(allData.getUser().getUserName()));
        tvDate.setText(String.valueOf(new SimpleDateFormat("yyyy.MM.dd").format(new Date())));
        tvAllTasksSize.setText(String.valueOf(allData.getAllCreatedTasks()));
        tvCompletedTasksSize.setText(String.valueOf(allData.getAllCompletedTasks()));
        tvAllScheduleSize.setText(String.valueOf(allData.getAllScheduleTasks()).concat(" tasks"));
        tvPersonalErrSize.setText(String.valueOf(allData.getPersonalErrSize()).concat(" tasks"));
        tvWorkProjectsSize.setText(String.valueOf(allData.getWorkProjSize()).concat(" tasks"));
        tvGrocListSize.setText(String.valueOf(allData.getGrocListSize()).concat(" tasks"));
        tvSchoolSize.setText(String.valueOf(allData.getSchoolListSize()).concat(" tasks"));
    }
}
