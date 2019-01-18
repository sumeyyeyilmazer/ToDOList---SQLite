package e.smyye.todolist.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import e.smyye.todolist.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // SplashScreen

        Thread time = new Thread (){
          public void run(){
              try{
                 sleep(5000);
              }
              catch(Exception e){

              }
              finally{
                  Intent listActivity = new Intent (MainActivity.this, ListActivity.class);
                  startActivity(listActivity);
                  finish();
              }
          }

        };

        time.start();


    }
}
