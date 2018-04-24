package tasksapp.tieto.com.tasksmanager;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import tasksapp.tieto.com.tasksmanager.domain.Project;
import tasksapp.tieto.com.tasksmanager.presenter.AddTaskContract;
import tasksapp.tieto.com.tasksmanager.presenter.AddTaskPresenter;

public class AdditionActivity extends AppCompatActivity implements AddTaskContract.View {

    private Spinner spinner;
    private ImageButton ibAddTaskOk, ibCancelTaskEndDate, ibCancelTaskDescription, ibCancelTaskEndTime;
    private EditText etTaskDescription, etTaskEndDate, etTaskEndTime;


    private AddTaskPresenter presenter;
    private Calendar myCalendar;
    private DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        presenter = new AddTaskPresenter(getApplication());
        presenter.bindView(AdditionActivity.this);
        initView();
        myCalendar = Calendar.getInstance();

        date = (view, year, monthOfYear, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String myFormat = "MM/dd/yy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            etTaskEndDate.setText(sdf.format(myCalendar.getTime()));
        };

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Personal errands");
        categories.add("Work Projects");
        categories.add("Grocery List");
        categories.add("Study");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.custom_text_view, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        etTaskEndDate.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                new DatePickerDialog(AdditionActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

                Log.i("etTaskEndDate", "clicked");
            }
        });

        ibCancelTaskEndDate.setOnClickListener(l -> {
            etTaskEndDate.setText("");

        });

        ibAddTaskOk.setOnClickListener(l -> {
            Log.i("Addition", "OK");
            validateInput();
            Project project = new Project();
            project.setIsDone(false);
            project.setEndDate(String.valueOf(etTaskEndDate.getText()));
            project.setEndTime(String.valueOf(etTaskEndTime.getText()));
            project.setTitle(String.valueOf(etTaskDescription.getText()));

            presenter.saveProject(project);
        });
    }

    private void initView() {
        spinner = findViewById(R.id.spinner);
        ibAddTaskOk = findViewById(R.id.btnAddTaskOk);
        etTaskDescription = findViewById(R.id.etTaskDescription);
        etTaskEndDate = findViewById(R.id.etTaskEndDate);
        etTaskEndTime = findViewById(R.id.etTaskEndTime);
        ibCancelTaskEndDate = findViewById(R.id.ibCancelTaskEndDate);
        ibCancelTaskDescription = findViewById(R.id.ibCancelTaskDescription);
        ibCancelTaskEndTime = findViewById(R.id.ibCancelTaskEndTime);
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.etTaskEndDate:
//                new DatePickerDialog(AdditionActivity.this, date, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//
//                Log.i("etTaskEndDate", "clicked");
//                break;
//            case R.id.ibCancelTaskEndDate:
//                etTaskEndDate.setText("");
//                break;
//            case R.id.ibCancelTaskDescription:
//                etTaskDescription.setText("");
//                break;
//            case R.id.ibCancelTaskEndTime:
//                etTaskEndTime.setText("");
//                break;
//            case R.id.btnAddTaskOk:
//                Log.i("Addition", "OK");
//                validateInput();
//                Project project = new Project();
//                project.setDone(false);
//                project.setEndDate(String.valueOf(etTaskEndDate.getText()));
//                project.setEndTime(String.valueOf(etTaskEndTime.getText()));
//                project.setTitle(String.valueOf(etTaskDescription.getText()));
//
//                presenter.saveProject(project);
//                break;
//            default:
//                Log.i("Addition", "DEFAULT");
//                break;
//        }
//    }

    private void validateInput() {

    }


    @Override
    public void successAddition() {
        etTaskEndDate.setText("");
        etTaskDescription.setText("");
        etTaskEndTime.setText("");
        Snackbar.make(etTaskDescription, "Successfully added", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
