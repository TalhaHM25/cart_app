package com.example.clone_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Student.db";
    private static final int database_version=1;

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, database_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Students(" + "Student_ID INTEGER Primary Key AUTOINCREMENT," +"Name Varchar(50), "+"Email Varchar(50))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop Table If Exists Student");
        onCreate(db);

    }
    public boolean insertdata(String name,String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("Name",name);
        values.put("Email",email);
       long result=db.insert("Students",null,values);
        return result != -1;
    }
    public Cursor readdata(){

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from Students",null);
        return cursor;
    }
}
