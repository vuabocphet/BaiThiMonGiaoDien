package com.trung.assgiaodien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB {
    final private String DB_NAME="BanHang";
    final private String TB_TABLE="HangHoa";
    final private int DB_VERSION=1;

    private SQLiteDatabase database;


    public DB (Context context){
        OpenHelper helper=new OpenHelper(context);
        database=helper.getWritableDatabase();

    }


    public class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE IF NOT EXISTS HangHoa(_id INTEGER PRIMARY KEY AUTOINCREMENT,mid NVARCHAR,name NVARCHAR,price NVARCHAR)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS HangHoa");
            onCreate(db);
        }
    }

    public void insert(String name,double price,String mid){
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("mid",mid);
        values.put("price",price);
        database.insert(TB_TABLE,null,values);
    }


    public void update(String name,double price,String mid,int id){
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("mid",mid);
        values.put("price",price);
        database.update(TB_TABLE,values,"_id="+id,null);
    }

    public void delete(int id){

        database.delete(TB_TABLE,"_id="+id,null);
    }
    public Cursor getData(){
        return database.query(TB_TABLE,null,null,null,null,null,null);
    }
}


