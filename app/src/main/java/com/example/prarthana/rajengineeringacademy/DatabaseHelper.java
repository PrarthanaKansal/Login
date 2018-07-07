package com.example.prarthana.rajengineeringacademy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="register";
    public static final String COL_1="First Name";
    public static final String COL_2="Last Name";
    public static final String COL_3="Password";
    public static final String COL_4="Email id";
    public static final String COL_5="Mobile No.";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (FirstName TEXT, LastName TEXT, Password TEXT, Email TEXT, Mobile TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public Boolean insert(String fname, String lname, String mobile, String email, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("First Name", fname);
        contentValues.put("Last Name",lname);
        contentValues.put("Mobile No.", mobile);
        contentValues.put("Email id", email);
        contentValues.put("Password", password);
        long ins= db.insert("register",null,contentValues);
        if(ins==-1){
            return false;
        }
        else {
            return true;
        }

    }
}
