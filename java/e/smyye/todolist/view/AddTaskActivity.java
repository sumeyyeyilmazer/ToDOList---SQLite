package e.smyye.todolist.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import e.smyye.todolist.R;
import e.smyye.todolist.model.Database;
import e.smyye.todolist.model.ItemTask;

public class AddTaskActivity extends AppCompatActivity {

    public EditText taskTitleET, taskDetailET;
    public Button addBtn;
    public Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskTitleET = findViewById(R.id.newTaskTitleE);
        taskDetailET = findViewById(R.id.taskDetailE);
        addBtn = findViewById(R.id.saveBtn);
        db = new Database(AddTaskActivity.this);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = taskTitleET.getText().toString();
                String detail = taskDetailET.getText().toString();
                ItemTask tasks = new ItemTask(title, detail);

                db.dataAdd(tasks);
             //   db.dataAdd( new ItemTask(taskTitleET.getText().toString(), taskDetailET.getText().toString()));
                Toast.makeText(AddTaskActivity.this, "görev kaydedildi", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddTaskActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }
}
