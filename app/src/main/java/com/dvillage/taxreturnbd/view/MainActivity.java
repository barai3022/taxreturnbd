package com.dvillage.taxreturnbd.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.adapter.TaxYearAdapter;
import com.dvillage.taxreturnbd.model.NoticeModel;
import com.dvillage.taxreturnbd.model.TaxYearModel;
import com.dvillage.taxreturnbd.model.UserModel;
import com.dvillage.taxreturnbd.pdf.A24PDFUtility;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;


    private TextView notice1_tv;
    private TextView notice2_tv;
    private TextView tin_tv;
    private RecyclerView taxYear_rv;
    private TaxYearAdapter taxYearAdapter;
    private AppCompatButton next_btn;

    private String tin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        notice1_tv = findViewById(R.id.tv_notice);
        notice2_tv = findViewById(R.id.tv_notice2);
        tin_tv = findViewById(R.id.tin);
        next_btn = findViewById(R.id.btn_next);


        mainViewModel.getUser();
        mainViewModel.getUserLiveData.observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                tin_tv.setText(userModel.getTin());
                tin = tin_tv.getText().toString();
            }
        });

        mainViewModel.getNotice();
        mainViewModel.getNoticeLiveData.observe(this, new Observer<NoticeModel>() {
            @Override
            public void onChanged(NoticeModel noticeModel) {
                notice1_tv.setText(noticeModel.getNotice1());
                notice2_tv.setText(noticeModel.getNotice2());
            }
        });



        tin_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TinActivity.class);
                intent.putExtra("tin", tin);
                startActivity(intent);
            }
        });


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaxYearActivity.class);
                intent.putExtra("tin", tin);
                startActivity(intent);
            }
        });


    }
}