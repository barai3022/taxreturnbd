package com.dvillage.taxreturnbd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dvillage.taxreturnbd.R;

public class C24Activity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c24);

        tv = findViewById(R.id.tv);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");


        tv.setText(name+" "+title+" "+desc);
    }
}