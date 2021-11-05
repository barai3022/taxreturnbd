package com.dvillage.taxreturnbd.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.Methods;
import com.dvillage.taxreturnbd.model.RebateModel;
import com.dvillage.taxreturnbd.model.SalariesModel;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;

public class D24Activity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private Toolbar toolbar_main;
    private TextView title_tv;
    private String ga1101, ga1105, name, title, desc;

    private TextView d2403_tv;
    private TextView d2404_tv;
    private TextView d2405_tv;
    private TextView d2406_tv;
    private TextView d2407_tv;
    private TextView d2408_tv;
    private TextView d2409_tv;
    private TextView d2410_tv;
    private TextView d2411_tv;
    private TextView d2412l_tv;
    private TextView d2412_tv;
    private TextView d2413_tv;
    private TextView d2414_tv;
    private TextView d2414a_tv;
    private TextView d2414b_tv;
    private TextView d2414c_tv;
    private TextView d2415_tv;
    private long d2413 =0;
    private long a24amount=0;
    private long a24exempted =0;
    private long a24taxable=0;
    private long a2403;
    private long a2404;
    private long a2405;
    private long a2406;
    private long a2407;
    private long a2408;
    private long a2409;
    private long a2410;
    private long a2411;
    private long a2412;
    private long a2413;
    private long a2414;
    private long a2415;
    private long a2416;
    private long a2417;
    private long a2418;
    private long a2419;
    private long a2420;
    private long a2421;
    private long min;
    private long rebate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d24);

        toolbar_main = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar_main);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title_tv = findViewById(R.id.tv_title);

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


        d2403_tv = findViewById(R.id.tv_d2403);
        d2404_tv = findViewById(R.id.tv_d2404);
        d2405_tv = findViewById(R.id.tv_d2405);
        d2406_tv = findViewById(R.id.tv_d2406);
        d2407_tv = findViewById(R.id.tv_d2407);
        d2408_tv = findViewById(R.id.tv_d2408);
        d2409_tv = findViewById(R.id.tv_d2409);
        d2410_tv = findViewById(R.id.tv_d2410);
        d2411_tv = findViewById(R.id.tv_d2411);
        d2412l_tv = findViewById(R.id.tv_d2412l);
        d2412_tv = findViewById(R.id.tv_d2412);
        d2413_tv = findViewById(R.id.tv_d2413);
        d2414_tv = findViewById(R.id.tv_d2414);
        d2414a_tv = findViewById(R.id.tv_d2414a);
        d2414b_tv = findViewById(R.id.tv_d2414b);
        d2414c_tv = findViewById(R.id.tv_d2414c);
        d2415_tv = findViewById(R.id.tv_d2415);


        mainViewModel.getRebate(ga1101, ga1105);
        mainViewModel.getRebateLiveData.observe(D24Activity.this, new Observer<RebateModel>() {
            @Override
            public void onChanged(RebateModel rebateModel) {
                d2403_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2403()));
                d2404_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2404()));
                d2405_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2405()));
                d2406_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2406()));
                d2407_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2407()));
                d2409_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2409()));
                d2410_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2410()));
                d2411_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2411()));
                d2412l_tv.setText(rebateModel.getD2412l());
                d2412_tv.setText(Methods.indianCurrencyFormat(rebateModel.getD2412()));
                d2413 = rebateModel.getD2403()+
                        rebateModel.getD2404()+
                        rebateModel.getD2405()+
                        rebateModel.getD2406()+
                        rebateModel.getD2407()+
                        rebateModel.getD2409()+
                        rebateModel.getD2410()+
                        rebateModel.getD2411()+
                        rebateModel.getD2412();
                d2413_tv.setText(Methods.indianCurrencyFormat(d2413));
                d2414a_tv.setText(Methods.indianCurrencyFormat(d2413));


                mainViewModel.getSalaries(ga1101, ga1105);
                mainViewModel.getSalariesLiveData.observe(D24Activity.this, new Observer<SalariesModel>() {
                    @Override
                    public void onChanged(SalariesModel salariesModel) {
                        a2403 = salariesModel.getA2403();
                        a2404 = salariesModel.getA2404();
                        a2405 = salariesModel.getA2405();
                        a2406 = salariesModel.getA2406();
                        a2407 = salariesModel.getA2407();
                        a2408 = salariesModel.getA2408();
                        a2409 = salariesModel.getA2409();
                        a2410 = salariesModel.getA2410();
                        a2411 = salariesModel.getA2411();
                        a2412 = salariesModel.getA2412();
                        a2413 = salariesModel.getA2413();
                        a2414 = salariesModel.getA2414();
                        a2415 = salariesModel.getA2415();
                        a2416 = salariesModel.getA2416();
                        a2417 = salariesModel.getA2417();
                        a2418 = salariesModel.getA2418();
                        a2419 = salariesModel.getA2419();
                        a2420 = salariesModel.getA2420();
                        a2421 = salariesModel.getA2421();





                        d2408_tv.setText(Methods.indianCurrencyFormat(a2417*2));
                        d2413 = d2413 + a2417*2;

                        d2413_tv.setText(Methods.indianCurrencyFormat(d2413));

                        a24amount += a2403; a24exempted += 0; a24taxable += a2403-0;
                        a24amount += a2404; a24exempted += 0; a24taxable += a2404-0;
                        a24amount += a2405; a24exempted += 0; a24taxable += a2405-0;
                        a24amount += a2406; a24exempted += 0; a24taxable += a2406-0;
                        a24amount += a2407;if (a2407 > 300000) {a24exempted += 300000; a24taxable += a2407-300000; } else { a24exempted += a2407; a24taxable += 0;}
                        a24amount += a2408;if (a2408 > 120000) {a24exempted += 120000; a24taxable += a2408-120000; } else { a24exempted += a2408; a24taxable += 0;}
                        a24amount += a2409;if (a2408 > 30000) {a24exempted += 30000; a24taxable += a2409-30000; } else { a24exempted += a2409; a24taxable += 0;}
                        a24amount += a2410; a24exempted += 0; a24taxable += a2410;
                        a24amount += a2411; a24exempted += 0; a24taxable += a2411;
                        a24amount += a2412; a24exempted += 0; a24taxable += a2412;
                        a24amount += a2413; a24exempted += 0; a24taxable += a2413;
                        a24amount += a2414; a24exempted += 0; a24taxable += a2414;
                        a24amount += a2415; a24exempted += 0; a24taxable += a2415;
                        a24amount += a2416; a24exempted += 0; a24taxable += a2416;
                        a24amount += a2417; a24exempted += 0; a24taxable += a2417;
                        a24amount += a2418; a24exempted += a2418; a24taxable += 0;
                        a24amount += a2419; a24exempted += 0; a24taxable += a2419;
                        a24amount += a2420; a24exempted += 0; a24taxable += a2420;
                        a24amount += a2421; a24exempted += 0; a24taxable += a2421;



                        min = Math.min(d2413, Math.min(a24taxable/4,15000000));
                        d2414_tv.setText(Methods.indianCurrencyFormat(min));
                        d2414a_tv.setText(Methods.indianCurrencyFormat(d2413));
                        d2414b_tv.setText(Methods.indianCurrencyFormat(a24taxable/4));
                        d2414c_tv.setText(Methods.indianCurrencyFormat(15000000));
                        if (a24taxable >1500000) {
                            rebate = min*12/100;
                        } else {
                            rebate = min*10/100;
                        }
                        d2415_tv.setText(Methods.indianCurrencyFormat(rebate));
                        a24taxable = a24amount-a24exempted;

                        a24amount = 0; a24exempted=0; a24taxable=0;

                    }
                });
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
                editD24();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void editD24() {
        Intent intent = new Intent(this, D24EditActivity.class);
        intent.putExtra("ga1101", ga1101);
        intent.putExtra("ga1105", ga1105);
        startActivity(intent);
    }
}