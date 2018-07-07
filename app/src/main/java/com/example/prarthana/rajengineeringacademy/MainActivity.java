package com.example.prarthana.rajengineeringacademy;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button _btnreg, _btnlogin;
    EditText _txtfname, _txtlname, _txtpass, _txtemail, _txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new DatabaseHelper(this);
        _txtfname = (EditText)findViewById(R.id.firstName);
        _txtlname = (EditText)findViewById(R.id.secondName);
        _txtpass = (EditText)findViewById(R.id.pass);
        _txtemail = (EditText)findViewById(R.id.email);
        _txtphone = (EditText)findViewById(R.id.mobile);
       // _btnlogin=(Button)findViewById(R.id.btnlogin);
        _btnreg=(Button)findViewById(R.id.register);



    _btnreg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String fname = _txtfname.getText().toString();
            String lname = _txtlname.getText().toString();
            String pass = _txtpass.getText().toString();
            String email = _txtemail.getText().toString();
            String phone = _txtphone.getText().toString();
            if(fname.equals("")|| lname.equals("")|| pass.equals("")|| email.equals("")|| phone.equals("")){
                Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();
            }
            else{
                db.insert(fname,lname,phone,email,pass);
                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_LONG).show();
            }



        }
    });


        }
 }
