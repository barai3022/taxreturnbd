package com.dvillage.taxreturnbd.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Toast;


import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.TinModel;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TinEditActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    private Toolbar mToolbar;
    private CheckBox ga1102_cb;
    private TextInputLayout ga1103_til;
    private AutoCompleteTextView ga1104_act;
    private TextInputLayout ga1106_til;
    private TextInputLayout ga1107_til;
    private TextInputLayout ga1108_til;
    private CheckBox ga1109_cb;
    private CheckBox ga1110a_cb;
    private CheckBox ga1110b_cb;
    private CheckBox ga1110c_cb;
    private CheckBox ga1110d_cb;
    private TextInputEditText ga1111_tet;
    private TextInputLayout ga1113_til;
    private TextInputLayout ga1114_til;
    private TextInputLayout ga1115_til;
    private TextInputLayout ga1116_til;
    private TextInputLayout ga1117_til;
    private TextInputLayout ga1118_til;
    private TextInputLayout ga1119_til;
    private TextInputLayout ga1120_til;
    private TextInputLayout ga1121_til;
    private TextInputLayout ga1122_til;
    private TextInputLayout ga1123_til;
    private long birthDate_ms, birthDate_ms1, ga1111;
    Calendar birthDate;
    SimpleDateFormat formatter;

    Boolean ga1102,ga1109, ga1110a, ga1110b, ga1110c, ga1110d;


    private Button update_btn;
    private String tin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_edit);

        mainViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ga1102_cb = findViewById(R.id.cb_ga1102);
        ga1103_til = findViewById(R.id.til_ga1103);
        ga1104_act = findViewById(R.id.act_ga1104);
        ga1106_til = findViewById(R.id.til_ga1106);
        ga1107_til = findViewById(R.id.til_ga1107);
        ga1108_til = findViewById(R.id.til_ga1108);
        ga1109_cb = findViewById(R.id.cb_ga1109);
        ga1110a_cb = findViewById(R.id.cb_ga1110a);
        ga1110b_cb = findViewById(R.id.cb_ga1110b);
        ga1110c_cb = findViewById(R.id.cb_ga1110c);
        ga1110d_cb = findViewById(R.id.cb_ga1110d);
        ga1111_tet = findViewById(R.id.tet_ga1111);
        ga1113_til = findViewById(R.id.til_ga1113);
        ga1114_til = findViewById(R.id.til_ga1114);
        ga1115_til = findViewById(R.id.til_ga1115);
        ga1116_til = findViewById(R.id.til_ga1116);
        ga1117_til = findViewById(R.id.til_ga1117);
        ga1118_til = findViewById(R.id.til_ga1118);
        ga1119_til = findViewById(R.id.til_ga1119);
        ga1120_til = findViewById(R.id.til_ga1120);
        ga1121_til = findViewById(R.id.til_ga1121);
        ga1122_til = findViewById(R.id.til_ga1122);
        ga1123_til = findViewById(R.id.til_ga1123);
        update_btn = findViewById(R.id.update_btn);
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTin();
            }
        });


        Intent intent = getIntent();
        tin = intent.getStringExtra("tin");






        mainViewModel.getTin(tin);
        mainViewModel.getTinLiveData.observe(this, new Observer<TinModel>() {
            @Override
            public void onChanged(TinModel tinModel) {
                Boolean ga1102 = tinModel.isGa1102();
                String ga1103 = tinModel.getGa1103();
                String ga1104 = tinModel.getGa1104();
                String ga1106 = tinModel.getGa1106();
                String ga1107 = tinModel.getGa1107();
                String ga1108 = tinModel.getGa1108();
                Boolean ga1109 = tinModel.isGa1109();
                Boolean ga1110a = tinModel.isGa1110a();
                Boolean ga1110b = tinModel.isGa1110b();
                Boolean ga1110c = tinModel.isGa1110c();
                Boolean ga1110d = tinModel.isGa1110d();

                String ga1113 = tinModel.getGa1113();
                String ga1114 = tinModel.getGa1114();
                String ga1115 = tinModel.getGa1115();
                String ga1116 = tinModel.getGa1116();
                String ga1117 = tinModel.getGa1117();
                String ga1118 = tinModel.getGa1118();
                String ga1119 = tinModel.getGa1119();
                String ga1120 = tinModel.getGa1120();
                String ga1121 = tinModel.getGa1121();
                String ga1122 = tinModel.getGa1122();
                String ga1123 = tinModel.getGa1123();


                if (ga1102) { ga1102_cb.setChecked(true); } else  { ga1102_cb.setChecked(false); }
                ga1103_til.getEditText().setText(ga1103);
                ga1104_act.setText(ga1104);
                List<String> genderList = new ArrayList<>();
                genderList.add("Male");
                genderList.add("Female");

                ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(TinEditActivity.this, android.R.layout.simple_spinner_dropdown_item, genderList);
                genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ga1104_act.setAdapter(genderAdapter);



                ga1106_til.getEditText().setText(ga1106);
                ga1107_til.getEditText().setText(ga1107);
                ga1108_til.getEditText().setText(ga1108);
                if (ga1109) { ga1109_cb.setChecked(true); } else  { ga1109_cb.setChecked(false); }
                if (ga1110a) { ga1110a_cb.setChecked(true); } else  { ga1110a_cb.setChecked(false); }
                if (ga1110b) { ga1110b_cb.setChecked(true); } else  { ga1110b_cb.setChecked(false); }
                if (ga1110c) { ga1110c_cb.setChecked(true); } else  { ga1110c_cb.setChecked(false); }
                if (ga1110d) { ga1110d_cb.setChecked(true); } else  { ga1110d_cb.setChecked(false); }
                birthDate_ms = tinModel.getGa1111();
                ga1113_til.getEditText().setText(ga1113);
                ga1114_til.getEditText().setText(ga1114);
                ga1115_til.getEditText().setText(ga1115);
                ga1116_til.getEditText().setText(ga1116);
                ga1117_til.getEditText().setText(ga1117);
                ga1118_til.getEditText().setText(ga1118);
                ga1119_til.getEditText().setText(ga1119);
                ga1120_til.getEditText().setText(ga1120);
                ga1121_til.getEditText().setText(ga1121);
                ga1122_til.getEditText().setText(ga1122);
                ga1123_til.getEditText().setText(ga1123);



                formatter = new SimpleDateFormat("dd/MM/yyyy");
                birthDate = Calendar.getInstance();
                birthDate.setTimeInMillis(birthDate_ms);
                ga1111_tet.setText(formatter.format(birthDate.getTime()));
                ga1111_tet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog  datePickerDialog = new DatePickerDialog(TinEditActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                birthDate.set(i, i1, i2);
                                ga1111_tet.setText(formatter.format(birthDate.getTime()));
                                birthDate_ms1 = birthDate.getTimeInMillis();
                            }
                        }, birthDate.get(Calendar.YEAR), birthDate.get(Calendar.MONTH), birthDate.get(Calendar.DAY_OF_MONTH));
                        datePickerDialog.show();
                    }
                });



            }
        });






    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void updateTin() {
        if (ga1102_cb.isChecked()){ ga1102 = true; } else { ga1102 = false; }
        String ga1103 = ga1103_til.getEditText().getText().toString();
        String ga1104 = ga1104_act.getText().toString();
        String ga1106 = ga1106_til.getEditText().getText().toString();
        String ga1107 = ga1107_til.getEditText().getText().toString();
        String ga1108 = ga1108_til.getEditText().getText().toString();
         if (ga1109_cb.isChecked()){ ga1109 = true; } else { ga1109 = false; }
         if (ga1110a_cb.isChecked()){ ga1110a = true; } else { ga1110a = false; }
         if (ga1110b_cb.isChecked()){ ga1110b = true; } else { ga1110b = false; }
         if (ga1110c_cb.isChecked()){ ga1110c = true; } else { ga1110c = false; }
         if (ga1110d_cb.isChecked()){ ga1110d = true; } else { ga1110d = false; }
         if (birthDate_ms1 == 0) { ga1111 = birthDate_ms; } else { ga1111 = birthDate_ms1; }

        String ga1113 = ga1113_til.getEditText().getText().toString();
        String ga1114 = ga1114_til.getEditText().getText().toString();
        String ga1115 = ga1115_til.getEditText().getText().toString();
        String ga1116 = ga1116_til.getEditText().getText().toString();
        String ga1117 = ga1117_til.getEditText().getText().toString();
        String ga1118 = ga1118_til.getEditText().getText().toString();
        String ga1119 = ga1119_til.getEditText().getText().toString();
        String ga1120 = ga1120_til.getEditText().getText().toString();
        String ga1121 = ga1121_til.getEditText().getText().toString();
        String ga1122 = ga1122_til.getEditText().getText().toString();
        String ga1123 = ga1123_til.getEditText().getText().toString();

        TinModel tinModel = new TinModel(ga1102,ga1103, ga1104,tin, ga1106, ga1107, ga1108,
                ga1109, ga1110a,ga1110b,ga1110c,ga1110d,ga1111, ga1113, ga1114, ga1115, ga1116, ga1117,
                ga1118, ga1119, ga1120, ga1121, ga1122, ga1123);

        mainViewModel.setTin(tinModel);
        mainViewModel.setTinLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if ( s == "Okay") {
                    Toast.makeText(TinEditActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}