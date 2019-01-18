package e.smyye.todolist.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import e.smyye.todolist.R;
import e.smyye.todolist.model.Database;
import e.smyye.todolist.presenter.MyAdapter;

public class ListActivity extends AppCompatActivity {

    public TextView completedTV, incompleteTV;
    public ListView taskListView;
    public  Database db;
    public FloatingActionButton addTaskFAB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        completedTV = findViewById(R.id.completedTV);
        incompleteTV = findViewById(R.id.incompleteTV);
        taskListView = findViewById(R.id.taskListV);
        db = new Database(ListActivity.this);
        addTaskFAB = findViewById(R.id.addFAB);

     //   int count = getIntent().getExtras().getInt("count");
       // completedTV.setText("" + completedTV.getText().toString() + "\n" + count);
     //   Toast.makeText(ListActivity.this, " " + count, Toast.LENGTH_SHORT).show();


        MyAdapter adapter = new MyAdapter(ListActivity.this, db.dataSelect());
        taskListView.setAdapter(adapter);

        addTaskFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, AddTaskActivity.class );
                startActivity(intent);
            }
        });


    }

}
