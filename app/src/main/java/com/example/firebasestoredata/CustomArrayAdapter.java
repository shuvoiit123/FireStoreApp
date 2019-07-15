package com.example.firebasestoredata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;

    public CustomArrayAdapter(Activity context, List<Student> studentList) {
        super(context, R.layout.list_view_sample, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_view_sample,null,true);

        Student student = studentList.get(position);

        TextView t1 = view.findViewById(R.id.nameTextViewId);
        TextView t2 = view.findViewById(R.id.ageTextViewId);
        TextView t3 = view.findViewById(R.id.phoneTextViewId);

        t1.setText("Name :"+student.getName());
        t2.setText("Age :"+student.getAge());
        t3.setText("Mobile : "+student.getPhone());


        return view;
    }
}

