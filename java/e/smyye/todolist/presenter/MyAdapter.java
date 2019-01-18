package e.smyye.todolist.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import e.smyye.todolist.R;
import e.smyye.todolist.model.Database;
import e.smyye.todolist.model.ItemTask;
import e.smyye.todolist.view.AddTaskActivity;
import e.smyye.todolist.view.MainActivity;

public class MyAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    List<ItemTask> taskL;
    TextView taskTitleText;
    int count =0;

    public MyAdapter(Activity activity, List<ItemTask> taskL) {
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.taskL = taskL;

    }

    @Override
    public int getCount() {
        return taskL.size();
    }

    @Override
    public Object getItem(int position) {
        return taskL.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View rowView;
        rowView = layoutInflater.inflate(R.layout.row_layout, null);

        FloatingActionButton completedFAB = rowView.findViewById(R.id.completedFAB);
        FloatingActionButton deleteFAB = rowView.findViewById(R.id.deleteFAB);
        taskTitleText = rowView.findViewById(R.id.taskTitleTV);

        final ItemTask itemTask = taskL.get(position);

        taskTitleText.setText(itemTask.getTitle());

        final Database db = new Database(rowView.getContext());

        deleteFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(rowView.getContext(), "görev silindi", Toast.LENGTH_SHORT).show();

                db.dataDelete(itemTask.getTitle());


              Intent intent = new Intent(rowView.getContext(), MainActivity.class); //listActivity manifestte bulunamadı hatası veriyor.
                rowView.getContext().startActivity(intent);
            }
        });

        completedFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   taskTitleText.setTextColor(Color.BLUE);
              //  Toast.makeText(rowView.getContext(), "renk değişti", Toast.LENGTH_SHORT).show();
                count++;
                Toast.makeText(rowView.getContext(), " " + count, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(rowView.getContext(), ListActivity.class);//listActivity manifestte bulunamadı hatası veriyor.
                intent.putExtra("count", count);
                rowView.getContext().startActivity(intent);


            }
        });

        taskTitleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(rowView.getContext());
                alert.setTitle(itemTask.getTitle());
                alert.setMessage(itemTask.getDetail());
                alert.show();


            }
        });


        return rowView;
    }
}

