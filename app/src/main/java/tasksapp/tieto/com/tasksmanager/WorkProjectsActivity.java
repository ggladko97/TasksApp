package tasksapp.tieto.com.tasksmanager;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TabHost;

import java.util.List;

import tasksapp.tieto.com.tasksmanager.adapter.WorkProjectAdapter;
import tasksapp.tieto.com.tasksmanager.domain.Project;
import tasksapp.tieto.com.tasksmanager.presenter.WorkProjectsContract;
import tasksapp.tieto.com.tasksmanager.presenter.WorkProjectsPresenter;

public class WorkProjectsActivity extends AppCompatActivity implements WorkProjectsContract.View {

    private TabHost host;
    private RecyclerView rcView;
    private WorkProjectsPresenter presenter;
    private WorkProjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_projects);
        host = findViewById(R.id.tabHost);
        rcView = findViewById(R.id.rcView);
        adapter = new WorkProjectAdapter(rcView);
        presenter = new WorkProjectsPresenter();
        presenter.bindView(WorkProjectsActivity.this);
        initHost(host);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);

        host.setCurrentTab(0);
        presenter.loadData();
        rcView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                switch (tabId) {
                    case "All":
                        presenter.loadData();
                        rcView.setAdapter(adapter);

                        adapter.notifyDataSetChanged();
                        break;
                    case "Complete":
                        presenter.laodCompletedData();
                        rcView.setAdapter(adapter);

                        adapter.notifyDataSetChanged();
                        break;
                    case "Priority":
                        Snackbar.make(host, "Functionality not supported yet", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case "Date":
                        Snackbar.make(host, "Functionality not supported yet", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    default:
                        Snackbar.make(host, "Functionality not supported yet", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                }
            }
        });


    }

    private void initHost(TabHost host) {

        host.setup();
        TabHost.TabSpec spec = host.newTabSpec("All");
        spec.setContent(R.id.tab1);
        spec.setIndicator("All");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Complete");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Complete");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Priority");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Priority");
        host.addTab(spec);
        //Tab 4
        spec = host.newTabSpec("Date");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Date");
        host.addTab(spec);
    }

    @Override
    public void updateWPList(List<Project> projList) {
        adapter.setProjectList(projList);
        adapter.notifyDataSetChanged();
    }
}
