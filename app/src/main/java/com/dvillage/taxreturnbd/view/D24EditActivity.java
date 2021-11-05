package com.dvillage.taxreturnbd.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.RebateModel;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;

public class D24EditActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private EditText d2403_et;
    private EditText d2404_et;
    private EditText d2405_et;
    private EditText d2406_et;
    private EditText d2407_et;
    private EditText d2409_et;
    private EditText d2410_et;
    private EditText d2411_et;
    private EditText d2412l_et;
    private EditText d2412_et;
    private Button back_btn;
    private Button update_btn;
    private String ga1101, ga1105;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d24_edit);

        mainViewModel = new ViewModelProvider(this, ViewModelProvider
        .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        d2403_et = findViewById(R.id.et_d2403);
        d2404_et = findViewById(R.id.et_d2404);
        d2405_et = findViewById(R.id.et_d2405);
        d2406_et = findViewById(R.id.et_d2406);
        d2407_et = findViewById(R.id.et_d2407);
        d2409_et = findViewById(R.id.et_d2409);
        d2410_et = findViewById(R.id.et_d2410);
        d2411_et = findViewById(R.id.et_d2411);
        d2412l_et = findViewById(R.id.et_d2412l);
        d2412_et = findViewById(R.id.et_d2412);

        back_btn = findViewById(R.id.btn_back);
        update_btn = findViewById(R.id.btn_update);

        Intent intent = getIntent();
        ga1101 = intent.getStringExtra("ga1101");
        ga1105 = intent.getStringExtra("ga1105");

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRebate();
                finish();
            }
        });

        mainViewModel.getRebate(ga1101, ga1105);
        mainViewModel.getRebateLiveData.observe(this, new Observer<RebateModel>() {
            @Override
            public void onChanged(RebateModel rebateModel) {
                d2403_et.setText(String.valueOf(rebateModel.getD2403()));
                d2404_et.setText(String.valueOf(rebateModel.getD2404()));
                d2405_et.setText(String.valueOf(rebateModel.getD2405()));
                d2406_et.setText(String.valueOf(rebateModel.getD2406()));
                d2407_et.setText(String.valueOf(rebateModel.getD2407()));
                d2409_et.setText(String.valueOf(rebateModel.getD2409()));
                d2410_et.setText(String.valueOf(rebateModel.getD2410()));
                d2411_et.setText(String.valueOf(rebateModel.getD2411()));
                d2412l_et.setText(String.valueOf(rebateModel.getD2412l()));
                d2412_et.setText(String.valueOf(rebateModel.getD2412()));
            }
        });
    }

    private void updateRebate() {

        long d2403 = Long.parseLong(d2403_et.getText().toString());
        long d2404 = Long.parseLong(d2404_et.getText().toString());
        long d2405 = Long.parseLong(d2405_et.getText().toString());
        long d2406 = Long.parseLong(d2406_et.getText().toString());
        long d2407 = Long.parseLong(d2407_et.getText().toString());
        long d2409 = Long.parseLong(d2409_et.getText().toString());
        long d2410 = Long.parseLong(d2410_et.getText().toString());
        long d2411 = Long.parseLong(d2411_et.getText().toString());
        String d2412l = d2412l_et.getText().toString();
        long d2412 = Long.parseLong(d2412_et.getText().toString());

        mainViewModel.setRebate(new RebateModel(ga1101, ga1105, d2403, d2404, d2405, d2406, d2407, d2409, d2410, d2411, d2412l, d2412));
        mainViewModel.setRebateLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s == "Okay") {
                    Toast.makeText(D24EditActivity.this, "Rebate Model Update successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(D24EditActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}