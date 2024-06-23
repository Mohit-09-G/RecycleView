package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name,fname,mname,email,mobile;
    DBHelper DB;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        DB=new DBHelper(this);
        name=new ArrayList<>();
        fname=new ArrayList<>();
        mname=new ArrayList<>();
        mobile=new ArrayList<>();
        email = new ArrayList<>();
        recyclerView =findViewById(R.id.recycleView);
        adapter=new MyAdapter(this, name ,fname,mname,email,mobile);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }
    private  void displaydata()
    {
        Cursor cursor =DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No Entry Exixts", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                fname.add(cursor.getString(1));
                mname.add(cursor.getString(2));
                email.add(cursor.getString(3));
                mobile.add(cursor.getString(4));
            }
        }
    }
}