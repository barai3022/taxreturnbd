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
import com.dvillage.taxreturnbd.model.SalariesModel;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;

public class A24EditActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    private EditText a2403_et,a2404_et, a2405_et,a2406_et, a2407_et,a2408_et,a2409_et,a2410_et,
            a2411_et,a2412_et,a2413_et,a2414_et,a2415_et,a2416_et,a2417_et,a2418_et,a2419_et,a2420_et,a2421_et;
    private Button back_btn, update_btn;
    private String ga1101, ga1105;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a24_edit);

        mainViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        a2403_et = findViewById(R.id.et_a2403);
        a2404_et = findViewById(R.id.et_a2404);
        a2405_et = findViewById(R.id.et_a2405);
        a2406_et = findViewById(R.id.et_a2406);
        a2407_et = findViewById(R.id.et_a2407);
        a2408_et = findViewById(R.id.et_a2408);
        a2409_et = findViewById(R.id.et_a2409);
        a2410_et = findViewById(R.id.et_a2410);
        a2411_et = findViewById(R.id.et_a2411);
        a2412_et = findViewById(R.id.et_a2412);
        a2413_et = findViewById(R.id.et_a2413);
        a2414_et = findViewById(R.id.et_a2414);
        a2415_et = findViewById(R.id.et_a2415);
        a2416_et = findViewById(R.id.et_a2416);
        a2417_et = findViewById(R.id.et_a2417);
        a2418_et = findViewById(R.id.et_a2418);
        a2419_et = findViewById(R.id.et_a2419);
        a2420_et = findViewById(R.id.et_a2420);
        a2421_et = findViewById(R.id.et_a2421);

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
                updateSalaries();
                finish();
            }
        });

        mainViewModel.getSalaries(ga1101, ga1105);
        mainViewModel.getSalariesLiveData.observe(this, new Observer<SalariesModel>() {
            @Override
            public void onChanged(SalariesModel salariesModel) {
                a2403_et.setText(String.valueOf(salariesModel.getA2403()));
                a2404_et.setText(String.valueOf(salariesModel.getA2404()));
                a2405_et.setText(String.valueOf(salariesModel.getA2405()));
                a2406_et.setText(String.valueOf(salariesModel.getA2406()));
                a2407_et.setText(String.valueOf(salariesModel.getA2407()));
                a2408_et.setText(String.valueOf(salariesModel.getA2408()));
                a2409_et.setText(String.valueOf(salariesModel.getA2409()));
                a2410_et.setText(String.valueOf(salariesModel.getA2410()));
                a2411_et.setText(String.valueOf(salariesModel.getA2411()));
                a2412_et.setText(String.valueOf(salariesModel.getA2412()));
                a2413_et.setText(String.valueOf(salariesModel.getA2413()));
                a2414_et.setText(String.valueOf(salariesModel.getA2414()));
                a2415_et.setText(String.valueOf(salariesModel.getA2415()));
                a2416_et.setText(String.valueOf(salariesModel.getA2416()));
                a2417_et.setText(String.valueOf(salariesModel.getA2417()));
                a2418_et.setText(String.valueOf(salariesModel.getA2418()));
                a2419_et.setText(String.valueOf(salariesModel.getA2419()));
                a2420_et.setText(String.valueOf(salariesModel.getA2420()));
                a2421_et.setText(String.valueOf(salariesModel.getA2421()));
            }
        });

    }

    private void updateSalaries() {
        long a2403 = Long.parseLong(a2403_et.getText().toString());
        long a2404 = Long.parseLong(a2404_et.getText().toString());
        long a2405 = Long.parseLong(a2405_et.getText().toString());
        long a2406 = Long.parseLong(a2406_et.getText().toString());
        long a2407 = Long.parseLong(a2407_et.getText().toString());
        long a2408 = Long.parseLong(a2408_et.getText().toString());
        long a2409 = Long.parseLong(a2409_et.getText().toString());
        long a2410 = Long.parseLong(a2410_et.getText().toString());
        long a2411 = Long.parseLong(a2411_et.getText().toString());
        long a2412 = Long.parseLong(a2412_et.getText().toString());
        long a2413 = Long.parseLong(a2413_et.getText().toString());
        long a2414 = Long.parseLong(a2414_et.getText().toString());
        long a2415 = Long.parseLong(a2415_et.getText().toString());
        long a2416 = Long.parseLong(a2416_et.getText().toString());
        long a2417 = Long.parseLong(a2417_et.getText().toString());
        long a2418 = Long.parseLong(a2418_et.getText().toString());
        long a2419 = Long.parseLong(a2419_et.getText().toString());
        long a2420 = Long.parseLong(a2420_et.getText().toString());
        long a2421 = Long.parseLong(a2421_et.getText().toString());

        SalariesModel salariesModel = new SalariesModel(ga1101, ga1105,  a2403, a2404, a2405, a2406, a2407, a2408, a2409, a2410, a2411, a2412, a2413, a2414, a2415, a2416, a2417, a2418, a2419, a2420, a2421);

        mainViewModel.setSalaries(salariesModel);
        mainViewModel.setSalariesLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s == "Okay") {
                    Toast.makeText(A24EditActivity.this, "Salaries Model Update successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(A24EditActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}