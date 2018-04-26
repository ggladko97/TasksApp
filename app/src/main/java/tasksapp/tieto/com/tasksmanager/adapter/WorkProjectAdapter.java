package tasksapp.tieto.com.tasksmanager.adapter;

import android.app.Application;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import tasksapp.tieto.com.tasksmanager.R;
import tasksapp.tieto.com.tasksmanager.domain.Project;
import tasksapp.tieto.com.tasksmanager.presenter.PresenterToAdapterListener;
import tasksapp.tieto.com.tasksmanager.presenter.WorkProjectsPresenter;


public class WorkProjectAdapter extends RecyclerView.Adapter<WorkProjectAdapter.ViewHolder> {

    List<Project> projectList = null;
    PresenterToAdapterListener callback;
    Application app;

    public WorkProjectAdapter() {
    }


    public WorkProjectAdapter(RecyclerView rcView, Application application) {

    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("OnCreateVH", "Hello");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_tasks, parent, false);
//        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
//                RecyclerView.LayoutParams.WRAP_CONTENT);
//        itemView.setLayoutParams(layoutParams);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (projectList == null) {
            Log.e("app failed", "projectList is null");
        }
        try {
            Project project = projectList.get(position);

            Log.i("OnBindVH", project.toString());
            //set not expended stuff invisible
            holder.llExpandedButtons.setVisibility(View.GONE);
            holder.llExpandedTime.setVisibility(View.GONE);

            holder.tvExpandList.setText(String.valueOf(project.getTitle()));
            holder.tvExpDate.setText(String.valueOf(project.getEndDate()));
            holder.tvExpTime.setText(String.valueOf(project.getEndTime()));
            holder.ibCall
                    .setOnClickListener(l -> Snackbar.make(holder.itemView, "Functionality not supported yet", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show());
            if (project.getIsDone()) {
                holder.cbIsDone.setChecked(true);
            } else {
                holder.cbIsDone.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (isChecked) {
                        Log.i("Checkbox", "checked " + project);
                        callback = new WorkProjectsPresenter(app);
                        callback.updateProject(project);
                    } else {
                        Log.i("Checkbox", "UNchecked");
                    }
                });
            }

        } catch (ArrayIndexOutOfBoundsException aiobe) {
            Log.e("app failed", "Index out of bounds in list");
        }
    }

    @Override
    public int getItemCount() {
        return projectList == null ? 0 : projectList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvExpandList;
        private CheckBox cbIsDone;
        private LinearLayout llExpandLayout;
        private LinearLayout llExpandedTime;
        private LinearLayout llExpandedButtons;
        private ImageButton ibCall;
        private TextView tvExpDate;
        private TextView tvExpTime;
        private static boolean FLAG_CLICKED = false;

        public ViewHolder(View itemView) {
            super(itemView);
            tvExpandList = itemView.findViewById(R.id.tvExpandList);
            cbIsDone = itemView.findViewById(R.id.cbIsDone);
            llExpandLayout = itemView.findViewById(R.id.llExpandLayout);
            llExpandedTime = itemView.findViewById(R.id.llExpandedTime);
            llExpandedButtons = itemView.findViewById(R.id.llExpandedButtons);
            ibCall = itemView.findViewById(R.id.ibCall);
            tvExpDate = itemView.findViewById(R.id.tvDateExp);
            tvExpTime = itemView.findViewById(R.id.tvTimeExp);

            llExpandLayout.setOnClickListener(v -> {
                if (!FLAG_CLICKED) {
                    llExpandedButtons.setVisibility(View.VISIBLE);
                    llExpandedTime.setVisibility(View.VISIBLE);
                    FLAG_CLICKED = true;
                } else {
                    llExpandedButtons.setVisibility(View.GONE);
                    llExpandedTime.setVisibility(View.GONE);
                    FLAG_CLICKED = false;
                }
            });


        }


    }
}
