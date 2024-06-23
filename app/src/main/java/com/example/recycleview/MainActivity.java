package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, mname, fname, mobile, email;
    Button insert, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        fname = findViewById(R.id.fthr);
        mname = findViewById(R.id.mthr);
        mobile = findViewById(R.id.numbr);
        email = findViewById(R.id.email);
        insert = findViewById(R.id.btninsert);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String namePattern = "[a-zA-Z]+";

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UserList.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = name.getText().toString();
                String fnameTxt = fname.getText().toString();
                String mnameTxt = mname.getText().toString();
                String emailTxt = email.getText().toString();
                String mobileTxt = mobile.getText().toString();

                if (nameTxt.isEmpty() || fnameTxt.isEmpty() || mnameTxt.isEmpty() || mobileTxt.isEmpty() || emailTxt.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!nameTxt.matches(namePattern)){
                    Toast.makeText(MainActivity.this, "Please fill Correct name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!fnameTxt.matches(namePattern)){
                    Toast.makeText(MainActivity.this, "Please fill Correct name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!mnameTxt.matches(namePattern)){
                    Toast.makeText(MainActivity.this, "Please fill Correct name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!emailTxt.matches(emailPattern)) {
                    Toast.makeText(MainActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mobileTxt.length() != 10) {
                    Toast.makeText(MainActivity.this, "Please enter a valid 10-digit mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Boolean checkInsertData = DB.insertdata(nameTxt, emailTxt, fnameTxt, mnameTxt, mobileTxt);
                if (checkInsertData) {
                    Toast.makeText(MainActivity.this, "New entry inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "New entry not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
