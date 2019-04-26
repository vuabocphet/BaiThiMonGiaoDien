package com.trung.assgiaodien;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Base extends AppCompatActivity {

    public Button btn;
    public DB database;
    public ArrayList<Model> list=new ArrayList<>();

    public ArrayList<Model> GetData(Context context){
        ArrayList<Model> list=new ArrayList<>();
        list.clear();
        DB db=new DB(context);

        Cursor cursor=db.getData();

        if (cursor!=null && cursor.moveToFirst()){

            do {
                Model model=new Model(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getDouble(3));
                list.add(model);
            }while (cursor.moveToNext());
        }
        return list;
    }

}
