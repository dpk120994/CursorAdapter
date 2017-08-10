package com.example.sourcekode1.cursoradapter;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText1;
    ListView listView;
    DbOperations operations;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operations=new DbOperations(MainActivity.this);
        editText=(EditText)findViewById(R.id.edt1);
        editText1=(EditText)findViewById(R.id.edt2);
        listView=(ListView)findViewById(R.id.listview);



    }
    public void add(View view)
    {


        String f_name=editText.getText().toString();
        String l_name=editText1.getText().toString();
        operations.addInfo(id,f_name,l_name);
        id++;



    }
    public void get(View view)
    {

        Cursor cursor=operations.getInfo();
        String  f_name,l_name;
        CustomAdapter adapter=new CustomAdapter(MainActivity.this,cursor);
        listView.setAdapter(adapter);

       // while(cursor.moveToNext())
        //{
           // f_name=cursor.getString(0);//0 is just the id of a particular column
            //l_name=cursor.getString(1);
            //Toast.makeText(this, ""+f_name+" "+l_name, Toast.LENGTH_SHORT).show();
        //}



    }


}
