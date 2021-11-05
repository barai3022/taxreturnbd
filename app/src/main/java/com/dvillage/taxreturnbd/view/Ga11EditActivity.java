package com.dvillage.taxreturnbd.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.Toast;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.Ga11Model;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ga11EditActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    private TextInputLayout taxLimit00_til;
    private TextInputLayout taxLimit05_til;
    private TextInputLayout taxLimit10_til;
    private TextInputLayout taxLimit15_til;
    private TextInputLayout taxLimit20_til;

    private TextInputLayout ga1112_til;
    private TextInputLayout ga1125_til;
    private TextInputLayout ga1127_til;
    private TextInputLayout ga1129_til;
    private TextInputLayout ga1130_til;
    private TextInputLayout ga1131_til;
    private TextInputLayout ga1132_til;
    private TextInputLayout ga1133_til;

    private TextInputLayout ga1138_til;
    private TextInputLayout ga1139_til;
    private TextInputLayout ga1140_til;
    private TextInputLayout ga1142_til;
    private TextInputLayout ga1143_til;
    private TextInputLayout ga1144_til;
    private TextInputLayout ga1145_til;

    private CheckBox ga1150_cb;
    private CheckBox ga1151_cb;
    private CheckBox ga1152a_cb;
    private CheckBox ga1152b_cb;
    private CheckBox ga1152c_cb;
    private CheckBox ga1152d_cb;
    private CheckBox ga1153a_cb;
    private CheckBox ga1153b_cb;

    private TextInputEditText ga1154a_tet;
    private TextInputLayout ga1154b_til;

    private Button back_btn, update_btn;
    private String ga1101, ga1105;

    Calendar signDate;
    SimpleDateFormat formatter;
    private long signDate_ms, ga1154a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ga11_edit);

        mainViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        taxLimit00_til = findViewById(R.id.tax_limit_00);
        taxLimit05_til = findViewById(R.id.tax_limit_05);
        taxLimit10_til = findViewById(R.id.tax_limit_10);
        taxLimit15_til = findViewById(R.id.tax_limit_15);
        taxLimit20_til = findViewById(R.id.tax_limit_20);

        ga1112_til = findViewById(R.id.til_ga1112);
        ga1125_til = findViewById(R.id.til_ga1125);
        ga1127_til = findViewById(R.id.til_ga1127);
        ga1129_til = findViewById(R.id.til_ga1129);
        ga1130_til = findViewById(R.id.til_ga1130);
        ga1131_til = findViewById(R.id.til_ga1131);
        ga1132_til = findViewById(R.id.til_ga1132);
        ga1133_til = findViewById(R.id.til_ga1133);

        ga1138_til = findViewById(R.id.til_ga1138);
        ga1139_til = findViewById(R.id.til_ga1139);
        ga1140_til = findViewById(R.id.til_ga1140);
        ga1142_til = findViewById(R.id.til_ga1142);
        ga1143_til = findViewById(R.id.til_ga1143);
        ga1144_til = findViewById(R.id.til_ga1144);
        ga1145_til = findViewById(R.id.til_ga1145);

        ga1150_cb = findViewById(R.id.cb_ga1150);
        ga1151_cb = findViewById(R.id.cb_ga1151);
        ga1152a_cb = findViewById(R.id.cb_ga1152a);
        ga1152b_cb = findViewById(R.id.cb_ga1152b);
        ga1152c_cb = findViewById(R.id.cb_ga1152c);
        ga1152d_cb = findViewById(R.id.cb_ga1152d);
        ga1153a_cb = findViewById(R.id.cb_ga1153a);
        ga1153b_cb = findViewById(R.id.cb_ga1153b);

        ga1154a_tet = findViewById(R.id.tet_ga1154a);
        ga1154b_til = findViewById(R.id.til_ga1154b);

        back_btn = findViewById(R.id.btn_back);
        update_btn = findViewById(R.id.btn_update);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateGa11();
            }
        });

        Intent intent = getIntent();
        ga1105 = intent.getStringExtra("tin");
        ga1101 = intent.getStringExtra("tax_year");

        mainViewModel.getG11Data(ga1101,ga1105);
        mainViewModel.getGa11LiveData.observe(this, new Observer<Ga11Model>() {
            @Override
            public void onChanged(Ga11Model ga11Model) {
                taxLimit00_til.getEditText().setText(String.valueOf(ga11Model.getTax_limit_00()));
                taxLimit05_til.getEditText().setText(String.valueOf(ga11Model.getTax_limit_05()));
                taxLimit10_til.getEditText().setText(String.valueOf(ga11Model.getTax_limit_10()));
                taxLimit15_til.getEditText().setText(String.valueOf(ga11Model.getTax_limit_15()));
                taxLimit20_til.getEditText().setText(String.valueOf(ga11Model.getTax_limit_20()));

                ga1112_til.getEditText().setText(ga11Model.getGa1112());
                ga1125_til.getEditText().setText(String.valueOf(ga11Model.getGa1125()));
                ga1127_til.getEditText().setText(String.valueOf(ga11Model.getGa1127()));
                ga1129_til.getEditText().setText(String.valueOf(ga11Model.getGa1129()));
                ga1130_til.getEditText().setText(String.valueOf(ga11Model.getGa1130()));
                ga1131_til.getEditText().setText(String.valueOf(ga11Model.getGa1131()));
                ga1132_til.getEditText().setText(String.valueOf(ga11Model.getGa1132()));
                ga1133_til.getEditText().setText(String.valueOf(ga11Model.getGa1133()));

                ga1138_til.getEditText().setText(String.valueOf(ga11Model.getGa1138()));
                ga1139_til.getEditText().setText(String.valueOf(ga11Model.getGa1139()));
                ga1140_til.getEditText().setText(String.valueOf(ga11Model.getGa1140()));
                ga1142_til.getEditText().setText(String.valueOf(ga11Model.getGa1142()));
                ga1143_til.getEditText().setText(String.valueOf(ga11Model.getGa1143()));
                ga1144_til.getEditText().setText(String.valueOf(ga11Model.getGa1144()));
                ga1145_til.getEditText().setText(String.valueOf(ga11Model.getGa1145()));

                if (ga11Model.isGa1150()) {ga1150_cb.setChecked(true);} else {ga1150_cb.setChecked(false);}
                if (ga11Model.isGa1151()) {ga1151_cb.setChecked(true);} else {ga1151_cb.setChecked(false);}
                if (ga11Model.isGa1152a()) {ga1152a_cb.setChecked(true);} else {ga1152a_cb.setChecked(false);}
                if (ga11Model.isGa1152b()) {ga1152b_cb.setChecked(true);} else {ga1152b_cb.setChecked(false);}
                if (ga11Model.isGa1152c()) {ga1152c_cb.setChecked(true);} else {ga1152c_cb.setChecked(false);}
                if (ga11Model.isGa1152d()) {ga1152d_cb.setChecked(true);} else {ga1152d_cb.setChecked(false);}
                if (ga11Model.isGa1153a()) {ga1153a_cb.setChecked(true);} else {ga1153a_cb.setChecked(false);}
                if (ga11Model.isGa1153b()) {ga1153b_cb.setChecked(true);} else {ga1153b_cb.setChecked(false);}


                formatter = new SimpleDateFormat("dd/MM/yyyy");
                signDate = Calendar.getInstance();
                signDate.setTimeInMillis(ga11Model.getGa1154a());
                ga1154a_tet.setText(formatter.format(signDate.getTime()));
                ga1154a_tet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog datePickerDialog = new DatePickerDialog(Ga11EditActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                signDate.set(i, i1, i2);
                                ga1154a_tet.setText(formatter.format(signDate.getTime()));
                                signDate_ms = signDate.getTimeInMillis();

                            }
                        }, signDate.get(Calendar.YEAR), signDate.get(Calendar.MONTH), signDate.get(Calendar.DAY_OF_MONTH));
                        datePickerDialog.show();
                    }
                });

                ga1154b_til.getEditText().setText(ga11Model.getGa1154b());

            }
        });


    }

    private void updateGa11() {
        boolean ga1150, ga1151, ga1152a, ga1152b, ga1152c, ga1152d, ga1153a, ga1153b;
        long tax_limit_00 = Long.parseLong(taxLimit00_til.getEditText().getText().toString());
        long tax_limit_05 = Long.parseLong(taxLimit05_til.getEditText().getText().toString());
        long tax_limit_10 = Long.parseLong(taxLimit10_til.getEditText().getText().toString());
        long tax_limit_15 = Long.parseLong(taxLimit15_til.getEditText().getText().toString());
        long tax_limit_20 = Long.parseLong(taxLimit20_til.getEditText().getText().toString());

        String ga1112 = ga1112_til.getEditText().getText().toString();

        long ga1125 = Long.parseLong(ga1125_til.getEditText().getText().toString());
        long ga1127 = Long.parseLong(ga1127_til.getEditText().getText().toString());
        long ga1129 = Long.parseLong(ga1129_til.getEditText().getText().toString());
        long ga1130 = Long.parseLong(ga1130_til.getEditText().getText().toString());
        long ga1131 = Long.parseLong(ga1131_til.getEditText().getText().toString());
        long ga1132 = Long.parseLong(ga1132_til.getEditText().getText().toString());
        long ga1133 = Long.parseLong(ga1133_til.getEditText().getText().toString());
        long ga1138 = Long.parseLong(ga1138_til.getEditText().getText().toString());
        long ga1139 = Long.parseLong(ga1139_til.getEditText().getText().toString());
        long ga1140 = Long.parseLong(ga1140_til.getEditText().getText().toString());
        long ga1142 = Long.parseLong(ga1142_til.getEditText().getText().toString());
        long ga1143 = Long.parseLong(ga1143_til.getEditText().getText().toString());
        long ga1144 = Long.parseLong(ga1144_til.getEditText().getText().toString());
        long ga1145 = Long.parseLong(ga1145_til.getEditText().getText().toString());
        if ( ga1150_cb.isChecked()) { ga1150 = true; } else { ga1150 = false;}
        if ( ga1151_cb.isChecked()) { ga1151 = true; } else { ga1151 = false;}
        if ( ga1152a_cb.isChecked()) { ga1152a = true; } else { ga1152a = false;}
        if ( ga1152b_cb.isChecked()) { ga1152b = true; } else { ga1152b = false;}
        if ( ga1152c_cb.isChecked()) { ga1152c = true; } else { ga1152c = false;}
        if ( ga1152d_cb.isChecked()) { ga1152d = true; } else { ga1152d = false;}
        if ( ga1153a_cb.isChecked()) { ga1153a = true; } else { ga1153a = false;}
        if ( ga1153b_cb.isChecked()) { ga1153b = true; } else { ga1153b = false;}

        String ga1154b = ga1154b_til.getEditText().getText().toString();


        Ga11Model ga11Model = new Ga11Model(ga1101, ga1105, tax_limit_00, tax_limit_05, tax_limit_10, tax_limit_15, tax_limit_20, ga1112, ga1125, ga1127, ga1129, ga1130, ga1131, ga1132, ga1133, ga1138, ga1139, ga1140, ga1142,ga1143, ga1144, ga1145, ga1150, ga1151, ga1152a, ga1152b, ga1152c, ga1152d, ga1153a, ga1153b, ga1154a, ga1154b);

        mainViewModel.setGa11(ga11Model);
        mainViewModel.setGa11LiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if ( s == "Okay") {
                    Toast.makeText(Ga11EditActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        }
}