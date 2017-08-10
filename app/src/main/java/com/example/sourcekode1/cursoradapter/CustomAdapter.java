package com.example.sourcekode1.cursoradapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by sourcekode1 on 10/08/17.
 */

public class CustomAdapter extends CursorAdapter {
    public CustomAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rawView=inflater.inflate(R.layout.my_style,null);

        return rawView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView textView1=view.findViewById(R.id.txt1);
        TextView textView2=view.findViewById(R.id.txt2);
        TextView textView3=view.findViewById(R.id.txt3);
        String id=cursor.getString(0);
        String fname=cursor.getString(1);
        String lname=cursor.getString(2);
        textView1.setText(id);
        textView2.setText(fname);
        textView3.setText(lname);
    }
}
