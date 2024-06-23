package com.example.recycleview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper  extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name Text Primary Key,email Text ,fname Text ,mname Text , mobile Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("Drop Table if exists Userdetails");

    }
    public Boolean insertdata(String name,String email, String fname ,String mname ,String mobile )
    {
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("fname",fname);
        contentValues.put("mname",mname);
        contentValues.put("email",email);
        contentValues.put("mobile",mobile);
        long result = DB.insert("Userdetails",null,contentValues);
        if (result==-1)
        {
            return false;

        }
        else
        {
            return true;
        }
    }
    public Cursor getdata()
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor =DB.rawQuery("SELECT * FROM Userdetails", null);
            return cursor;
        }

}
