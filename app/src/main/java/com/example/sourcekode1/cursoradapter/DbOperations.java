package com.example.sourcekode1.cursoradapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sourcekode1 on 10/08/17.
 */

public class DbOperations extends SQLiteOpenHelper {

    String query="create table emp(_id number,f_name text,l_name text)";
    public DbOperations(Context context) {
        super(context, "Mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addInfo(int id,String f_name,String l_name)
    {

        SQLiteDatabase database=this.getWritableDatabase();//to get writable permission
        ContentValues values=new ContentValues();//to store key values and pass them to insert function
        values.put("_id",id);
        values.put("f_name",f_name);//add the value f_name to column F_NAME;
        values.put("l_name",l_name);//add the value l_name to column L_NAME;
        database.insert("EMP",null,values);




    }
    public Cursor getInfo()
    {

        SQLiteDatabase database=this.getReadableDatabase();//to get readable permission for our database
        String [] columns={"_id","F_NAME"
                ,"L_NAME"};
        Cursor cursor=database.query("EMP",columns,null,null,null,null,null);//used to get the data queried from database,it is returned in cursor format

        return cursor;



    }

}

