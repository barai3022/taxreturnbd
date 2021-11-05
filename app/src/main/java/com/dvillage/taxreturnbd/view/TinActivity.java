package com.dvillage.taxreturnbd.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.Methods;
import com.dvillage.taxreturnbd.model.TinModel;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class TinActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    private CheckBox ga1102a_cb;
    private CheckBox ga1102b_cb;
    private TextView ga1103_tv;
    private TextView ga1104_tv;
    private TextView ga1105_tv;
    private TextView ga1106_tv;
    private TextView ga1107_tv;
    private TextView ga1108_tv;
    private CheckBox ga1109a_cb;
    private CheckBox ga1109b_cb;
    private CheckBox ga1110a_cb;
    private CheckBox ga1110b_cb;
    private CheckBox ga1110c_cb;
    private CheckBox ga1110d_cb;
    private TextView ga1111_tv;
    private TextView ga1113_tv;
    private TextView ga1114_tv;
    private TextView ga1115_tv;
    private TextView ga1116_tv;
    private TextView ga1117_tv;
    private TextView ga1118_tv;
    private TextView ga1119_tv;
    private TextView ga1120_tv;
    private TextView ga1121_tv;
    private TextView ga1122_tv;
    private TextView ga1123_tv;


    private Toolbar mainToolbar;
    String tin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin);

        mainToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mainViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        ga1102a_cb = findViewById(R.id.cb_ga1102a);
        ga1102b_cb = findViewById(R.id.cb_ga1102b);
        ga1103_tv = findViewById(R.id.tv_ga1103);
        ga1104_tv = findViewById(R.id.tv_ga1104);
        ga1105_tv = findViewById(R.id.tv_ga1105);
        ga1106_tv = findViewById(R.id.tv_ga1106);
        ga1107_tv = findViewById(R.id.tv_ga1107);
        ga1108_tv = findViewById(R.id.tv_ga1108);
        ga1109a_cb = findViewById(R.id.cb_ga1109a);
        ga1109b_cb = findViewById(R.id.cb_ga1109b);
        ga1110a_cb = findViewById(R.id.cb_ga1110a);
        ga1110b_cb = findViewById(R.id.cb_ga1110b);
        ga1110c_cb = findViewById(R.id.cb_ga1110c);
        ga1110d_cb = findViewById(R.id.cb_ga1110d);
        ga1111_tv = findViewById(R.id.tv_ga1111);
        ga1113_tv = findViewById(R.id.tv_ga1113);
        ga1114_tv = findViewById(R.id.tv_ga1114);
        ga1115_tv = findViewById(R.id.tv_ga1115);
        ga1116_tv = findViewById(R.id.tv_ga1116);
        ga1117_tv = findViewById(R.id.tv_ga1117);
        ga1118_tv = findViewById(R.id.tv_ga1118);
        ga1119_tv = findViewById(R.id.tv_ga1119);
        ga1120_tv = findViewById(R.id.tv_ga1120);
        ga1121_tv = findViewById(R.id.tv_ga1121);
        ga1122_tv = findViewById(R.id.tv_ga1122);
        ga1123_tv = findViewById(R.id.tv_ga1123);


        Intent intent = getIntent();
        tin = intent.getStringExtra("tin");
        getSupportActionBar().setTitle(tin);

        mainViewModel.getTin(tin);
        mainViewModel.getTinLiveData.observe(this, new Observer<TinModel>() {
            @Override
            public void onChanged(TinModel tinModel) {
                if (tinModel.isGa1102()) {
                    ga1102a_cb.setChecked(true);
                    ga1102b_cb.setChecked(false);
                } else {
                    ga1102b_cb.setChecked(true);
                    ga1102a_cb.setChecked(false);
                }
                ga1103_tv.setText(tinModel.getGa1103());
                ga1104_tv.setText(tinModel.getGa1104());
                ga1105_tv.setText(tinModel.getGa1105());
                ga1106_tv.setText(tinModel.getGa1106());
                ga1107_tv.setText(tinModel.getGa1107());
                ga1108_tv.setText(tinModel.getGa1108());

                if (tinModel.isGa1109()) {
                    ga1109a_cb.setChecked(true);
                    ga1109b_cb.setChecked(false);
                } else {
                    ga1109b_cb.setChecked(true);
                    ga1109a_cb.setChecked(false);
                }
                if(tinModel.isGa1110a()) {
                    ga1110a_cb.setChecked(true);
                } else {
                    ga1110a_cb.setChecked(false);
                }
                if(tinModel.isGa1110b()) {
                    ga1110b_cb.setChecked(true);
                } else {
                    ga1110b_cb.setChecked(false);
                }
                if(tinModel.isGa1110c()) {
                    ga1110c_cb.setChecked(true);
                } else {
                    ga1110c_cb.setChecked(false);
                }
                if(tinModel.isGa1110d()) {
                    ga1110d_cb.setChecked(true);
                } else {
                    ga1110d_cb.setChecked(false);
                }

                ga1111_tv.setText(Methods.dateText(tinModel.getGa1111()));
                ga1113_tv.setText(tinModel.getGa1113());
                ga1114_tv.setText(tinModel.getGa1114());
                ga1115_tv.setText(tinModel.getGa1115());
                ga1116_tv.setText(tinModel.getGa1116());
                ga1117_tv.setText(tinModel.getGa1117());
                ga1118_tv.setText(tinModel.getGa1118());
                ga1119_tv.setText(tinModel.getGa1119());
                ga1120_tv.setText(tinModel.getGa1120());
                ga1121_tv.setText(tinModel.getGa1121());
                ga1122_tv.setText(tinModel.getGa1122());
                ga1123_tv.setText(tinModel.getGa1123());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.edit:
                //addTinInfo();
                editTinIntent();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void editTinIntent() {
        Intent intent = new Intent(this, TinEditActivity.class);
        intent.putExtra("tin", tin);
        startActivity(intent);
    }

}