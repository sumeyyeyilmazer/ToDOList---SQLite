package e.smyye.todolist.model;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="example";
    public static final String TABLE_NAME="tasks";


    public Database( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//tablo oluşturuluyor
        String sql= "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, detail TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //verileri veritabanına ekleme
    public void dataAdd (ItemTask itemTask){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("title", itemTask.getTitle() );
        data.put("detail", itemTask.getDetail());

        db.insert(TABLE_NAME, null, data);
        db.close();

    }

    //Verileri veritabanından çekme
    public List<ItemTask> dataSelect (){
        SQLiteDatabase db = this.getWritableDatabase();
        List<ItemTask> taskList = new ArrayList<>();

        String sql = "SELECT * " +
                     "FROM " + TABLE_NAME;

        Cursor cursorObj = db.rawQuery(sql,null);

        while(cursorObj.moveToNext()){
            ItemTask task = new ItemTask();
            task.setTitle(cursorObj.getString(1));
            task.setDetail(cursorObj.getString(2));

            taskList.add(task);
        }
        db.close();
        return taskList;
    }

    //verileri veritabanından silmek
    public void dataDelete(String title){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "DELETE " +
                     "FROM " + TABLE_NAME + " WHERE title = '" + title + "\' ";

      //  String sql =  "DELETE FROM tasks WHERE title = '" + title + "\' ";
        db.execSQL(sql);
        db.close();

    }




}
