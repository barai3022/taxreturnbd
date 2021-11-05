package com.dvillage.taxreturnbd.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.adapter.A24Adapter;
import com.dvillage.taxreturnbd.model.A24Model;
import com.dvillage.taxreturnbd.model.Methods;
import com.dvillage.taxreturnbd.model.SalariesModel;
import com.dvillage.taxreturnbd.pdf.A24PDFUtility;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;

import com.google.firebase.firestore.CollectionReference;
import com.itextpdf.text.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class A24Activity extends AppCompatActivity implements A24PDFUtility.OnDocumentClose {

    private static final String TAG = A24Activity.class.getSimpleName();

    private MainViewModel mainViewModel;
    private Toolbar toolbar_main;
    private TextView title_tv;
    private RecyclerView a24_rv;
    private A24Adapter adapter;
    private String ga1101, ga1105,name, title, desc;
    private Button createPdf_btn;
    Document document;
    List<String[]> temp;
    List<String[]> sampleData;
    private List<String[]> getSampleData1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a24);

        toolbar_main = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar_main);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title_tv = findViewById(R.id.tv_title);
        createPdf_btn = findViewById(R.id.btn_createPdf);
        a24_rv = findViewById(R.id.rv_a24);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        a24_rv.setLayoutManager(layoutManager);

        ActivityCompat.requestPermissions(A24Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        mainViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        Intent intent = getIntent();
        ga1101 = intent.getStringExtra("tax_year");
        ga1105 = intent.getStringExtra("tin");
        name = intent.getStringExtra("name");
        title = intent.getStringExtra("title");
        desc = intent.getStringExtra("desc");

        setTitle(title);
        title_tv.setText(desc);

        mainViewModel.getA24(ga1101, ga1105);
        mainViewModel.getA24LiveData.observe(this, new Observer<List<A24Model>>() {
            @Override
            public void onChanged(List<A24Model> a24Models) {
                adapter = new A24Adapter(A24Activity.this, a24Models);
                a24_rv.setAdapter(adapter);
            }
        });

        createPdf_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()+"/A24.pdf";
                try {
                    A24PDFUtility.createPdf(view.getContext(), A24Activity.this, getSampleData(), path, true);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(TAG, "Error Creating Pdf");
                    Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_down_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.download:
                downloadA24();
                return true; 
            case R.id.edit:
                editA24();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void downloadA24() {


    }

    private void editA24() {
        Intent intent = new Intent(this, A24EditActivity.class);
        intent.putExtra("ga1101", ga1101);
        intent.putExtra("ga1105", ga1105);
        startActivity(intent);
    }



    @Override
    public void onPDFDocumentClose(File file) {
        Toast.makeText(this,"Sample Pdf Created",Toast.LENGTH_SHORT).show();
    }

    private List<String[]> getSampleData(){
         sampleData = new ArrayList<>();


        mainViewModel.getSalaries(ga1101, ga1105);
        mainViewModel.getSalariesLiveData.observe(A24Activity.this, new Observer<SalariesModel>() {
            @Override
            public void onChanged(SalariesModel salariesModel) {
                temp = new ArrayList<>();
                long a03, b03, c03;
                long a04, b04, c04;
                long a05, b05, c05;
                long a06, b06, c06;
                long a07, b07, c07;
                long a08, b08, c08;
                long a09, b09, c09;
                long a10, b10, c10;
                long a11, b11, c11;
                long a12, b12, c12;
                long a13, b13, c13;
                long a14, b14, c14;
                long a15, b15, c15;
                long a16, b16, c16;
                long a17, b17, c17;
                long a18, b18, c18;
                long a19, b19, c19;
                long a20, b20, c20;
                long a21, b21, c21;
                long a22, b22, c22;

                a03 = salariesModel.getA2403(); b03 = 0; c03 = a03-b03;
                a04 = salariesModel.getA2404(); b04 = 0; c04 = a04-b04;
                a05 = salariesModel.getA2405(); b05 = 0; c05 = a05-b05;
                a06 = salariesModel.getA2406(); b06 = 0; c06 = a06-b06;
                a07 = salariesModel.getA2407(); if (a07 > 300000) {  b07 = 300000; } else { b07 = a07;}  c07 = a07-b07;
                a08 = salariesModel.getA2408(); b08 = 0; c08 = a08-b08;
                a09 = salariesModel.getA2409(); b09 = 0; c09 = a09-b09;
                a10 = salariesModel.getA2410(); b10 = 0; c10 = a10-b10;
                a11 = salariesModel.getA2411(); b11 = 0; c11 = a11-b11;
                a12 = salariesModel.getA2412(); b12 = 0; c12 = a12-b12;
                a13 = salariesModel.getA2413(); b13 = 0; c13 = a13-b13;
                a14 = salariesModel.getA2414(); b14 = 0; c14 = a14-b14;
                a15 = salariesModel.getA2415(); b15 = 0; c15 = a15-b15;
                a16 = salariesModel.getA2416(); b16 = 0; c16 = a16-b16;
                a17 = salariesModel.getA2417(); b17 = 0; c17 = a17-b17;
                a18 = salariesModel.getA2418(); b18 = 0; c18 = a18-b18;
                a19 = salariesModel.getA2419(); b19 = 0; c19 = a19-b19;
                a20 = salariesModel.getA2420(); b20 = 0; c20 = a20-b20;
                a21 = salariesModel.getA2421(); b21 = 0; c21 = a21-b21;
                a22 = a03+a04+a05+a06+a07+a08;
                b22 = b03+b04+b05+b06+b07+b08;
                c22 = a22-b22;


                String s03 = getString(R.string.a2403);
                String s04 = getString(R.string.a2404);
                String s05 = getString(R.string.a2405);
                String s06 = getString(R.string.a2406);
                String s07 = getString(R.string.a2407);
                String s08 = getString(R.string.a2408);
                String s09 = getString(R.string.a2409);
                String s10 = getString(R.string.a2410);
                String s11 = getString(R.string.a2411);
                String s12 = getString(R.string.a2412);
                String s13 = getString(R.string.a2413);
                String s14 = getString(R.string.a2414);
                String s15 = getString(R.string.a2415);
                String s16 = getString(R.string.a2416);
                String s17 = getString(R.string.a2417);
                String s18 = getString(R.string.a2418);
                String s19 = getString(R.string.a2419);
                String s20 = getString(R.string.a2420);
                String s21 = getString(R.string.a2421);
                String s22 = getString(R.string.a2422);

                String[] col1 = new String[]{"03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22"};
                String[] col2 = new String[]{s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22};
                String[] col3 = new String[] { Methods.indianCurrencyFormat(a03),
                        Methods.indianCurrencyFormat(a04),
                        Methods.indianCurrencyFormat(a05),
                        Methods.indianCurrencyFormat(a06),
                        Methods.indianCurrencyFormat(a07),
                        Methods.indianCurrencyFormat(a08),
                        Methods.indianCurrencyFormat(a09),
                        Methods.indianCurrencyFormat(a10),
                        Methods.indianCurrencyFormat(a11),
                        Methods.indianCurrencyFormat(a12),
                        Methods.indianCurrencyFormat(a13),
                        Methods.indianCurrencyFormat(a14),
                        Methods.indianCurrencyFormat(a15),
                        Methods.indianCurrencyFormat(a16),
                        Methods.indianCurrencyFormat(a17),
                        Methods.indianCurrencyFormat(a18),
                        Methods.indianCurrencyFormat(a19),
                        Methods.indianCurrencyFormat(a20),
                        Methods.indianCurrencyFormat(a21),
                        Methods.indianCurrencyFormat(a22),
                };

                String[] col4 = new String[] { Methods.indianCurrencyFormat(b03),
                        Methods.indianCurrencyFormat(b04),
                        Methods.indianCurrencyFormat(b05),
                        Methods.indianCurrencyFormat(b06),
                        Methods.indianCurrencyFormat(b07),
                        Methods.indianCurrencyFormat(b08),
                        Methods.indianCurrencyFormat(b09),
                        Methods.indianCurrencyFormat(b10),
                        Methods.indianCurrencyFormat(b11),
                        Methods.indianCurrencyFormat(b12),
                        Methods.indianCurrencyFormat(b13),
                        Methods.indianCurrencyFormat(b14),
                        Methods.indianCurrencyFormat(b15),
                        Methods.indianCurrencyFormat(b16),
                        Methods.indianCurrencyFormat(b17),
                        Methods.indianCurrencyFormat(b18),
                        Methods.indianCurrencyFormat(b19),
                        Methods.indianCurrencyFormat(b20),
                        Methods.indianCurrencyFormat(b21),
                        Methods.indianCurrencyFormat(b22),
                };

                String[] col5 = new String[] { Methods.indianCurrencyFormat(c03),
                        Methods.indianCurrencyFormat(c04),
                        Methods.indianCurrencyFormat(c05),
                        Methods.indianCurrencyFormat(c06),
                        Methods.indianCurrencyFormat(c07),
                        Methods.indianCurrencyFormat(c08),
                        Methods.indianCurrencyFormat(c09),
                        Methods.indianCurrencyFormat(c10),
                        Methods.indianCurrencyFormat(c11),
                        Methods.indianCurrencyFormat(c12),
                        Methods.indianCurrencyFormat(c13),
                        Methods.indianCurrencyFormat(c14),
                        Methods.indianCurrencyFormat(c15),
                        Methods.indianCurrencyFormat(c16),
                        Methods.indianCurrencyFormat(c17),
                        Methods.indianCurrencyFormat(c18),
                        Methods.indianCurrencyFormat(c19),
                        Methods.indianCurrencyFormat(c20),
                        Methods.indianCurrencyFormat(c21),
                        Methods.indianCurrencyFormat(c22),
                };


             //   temp1.equals(temp);

                for (int i = 0; i < 20; i++)
                {
                    //temp.add(new String[] {col1[i],col2[i],col3[i],col4[i],col5[i]});
                    temp.add(new String[] {"1","1","1","1","1"});

                }
               sampleData.addAll(temp);
            }
        });

        return sampleData;
    }
}