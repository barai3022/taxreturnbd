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
import android.widget.CheckBox;
import android.widget.TextView;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.Ga11Model;
import com.dvillage.taxreturnbd.model.Methods;
import com.dvillage.taxreturnbd.model.RebateModel;
import com.dvillage.taxreturnbd.model.SalariesModel;
import com.dvillage.taxreturnbd.model.TinModel;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;

public class Ga11Activity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private Toolbar toolbar_main;
    private TextView tv;
    private String ga1101, ga1105, name, title, desc;
    private TextView ga1101_tv;
    private CheckBox ga1102a_cb;
    private CheckBox ga1102b_cb;
    private TextView ga1103_tv;
    private CheckBox ga1104a_cb;
    private CheckBox ga1104b_cb;
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
    private TextView ga1112_tv;
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

    private TextView ga1124_tv;
    private TextView ga1125_tv;
    private TextView ga1126_tv;
    private TextView ga1127_tv;
    private TextView ga1128_tv;
    private TextView ga1129_tv;
    private TextView ga1130_tv;
    private TextView ga1131_tv;
    private TextView ga1132_tv;
    private TextView ga1133_tv;
    private TextView ga1134_tv;

    private TextView ga1135_tv;
    private TextView ga1136_tv;
    private TextView ga1137_tv;
    private TextView ga1138_tv;
    private TextView ga1139_tv;
    private TextView ga1140_tv;
    private TextView ga1141_tv;
    private TextView ga1142_tv;
    private TextView ga1143_tv;
    private TextView ga1144_tv;
    private TextView ga1145_tv;
    private TextView ga1146_tv;
    private TextView ga1147_tv;
    private TextView ga1148_tv;

    private long ga1124;
    private long ga1125;
    private long ga1126;
    private long ga1127;
    private long ga1128;
    private long ga1129;
    private long ga1130;
    private long ga1131;
    private long ga1132;
    private long ga1133;
    private long ga1134;
    private long ga1135;
    private long ga1136;
    private long ga1137;
    private long ga1138;
    private long ga1139;
    private long ga1140;
    private long ga1141;
    private long ga1142;
    private long ga1143;
    private long ga1144;
    private long ga1145;
    private long ga1146;
    private long ga1147;
    private long ga1148;

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

    private long d2413;
    private long min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ga11);

        toolbar_main = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar_main);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        ga1101_tv = findViewById(R.id.tv_ga1101);
        ga1102a_cb = findViewById(R.id.cb_ga1102a);
        ga1102b_cb = findViewById(R.id.cb_ga1102b);
        ga1103_tv = findViewById(R.id.tv_ga1103);
        ga1104a_cb = findViewById(R.id.cb_ga1104a);
        ga1104b_cb = findViewById(R.id.cb_ga1104b);
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
        ga1112_tv = findViewById(R.id.tv_ga1112);
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

        ga1124_tv = findViewById(R.id.tv_ga1124);
        ga1125_tv = findViewById(R.id.tv_ga1125);
        ga1126_tv = findViewById(R.id.tv_ga1126);
        ga1127_tv = findViewById(R.id.tv_ga1127);
        ga1128_tv = findViewById(R.id.tv_ga1128);
        ga1129_tv = findViewById(R.id.tv_ga1129);
        ga1130_tv = findViewById(R.id.tv_ga1130);
        ga1131_tv = findViewById(R.id.tv_ga1131);
        ga1132_tv = findViewById(R.id.tv_ga1132);
        ga1133_tv = findViewById(R.id.tv_ga1133);
        ga1134_tv = findViewById(R.id.tv_ga1134);

        ga1135_tv = findViewById(R.id.tv_ga1135);
        ga1136_tv = findViewById(R.id.tv_ga1136);
        ga1137_tv = findViewById(R.id.tv_ga1137);
        ga1138_tv = findViewById(R.id.tv_ga1138);
        ga1139_tv = findViewById(R.id.tv_ga1139);
        ga1140_tv = findViewById(R.id.tv_ga1140);
        ga1141_tv = findViewById(R.id.tv_ga1141);
        ga1142_tv = findViewById(R.id.tv_ga1142);
        ga1143_tv = findViewById(R.id.tv_ga1143);
        ga1144_tv = findViewById(R.id.tv_ga1144);
        ga1145_tv = findViewById(R.id.tv_ga1145);
        ga1146_tv = findViewById(R.id.tv_ga1146);
        ga1147_tv = findViewById(R.id.tv_ga1147);
        ga1148_tv = findViewById(R.id.tv_ga1148);

        mainViewModel.getTin(ga1105);
        mainViewModel.getTinLiveData.observe(this, new Observer<TinModel>() {
            @Override
            public void onChanged(TinModel tinModel) {
                if (tinModel.isGa1102()) { ga1102a_cb.setChecked(true); ga1102b_cb.setChecked(false);} else {ga1102b_cb.setChecked(true); ga1102a_cb.setChecked(false); }
                ga1103_tv.setText(tinModel.getGa1103());
                if (tinModel.getGa1104()=="Male") {ga1104a_cb.setChecked(true); ga1104b_cb.setChecked(false);} else {ga1104b_cb.setChecked(true); ga1104a_cb.setChecked(false);}
                ga1105_tv.setText(tinModel.getGa1105());
                ga1106_tv.setText(tinModel.getGa1106());
                ga1107_tv.setText(tinModel.getGa1107());
                ga1108_tv.setText(tinModel.getGa1108());
                if (tinModel.isGa1109()) {ga1109a_cb.setChecked(true); ga1109b_cb.setChecked(false);} else {ga1109b_cb.setChecked(true); ga1109a_cb.setChecked(false);}
                if (tinModel.isGa1110a()) {ga1110a_cb.setChecked(true);} else {ga1110a_cb.setChecked(false);}
                if (tinModel.isGa1110b()) {ga1110b_cb.setChecked(true);} else {ga1110b_cb.setChecked(false);}
                if (tinModel.isGa1110c()) {ga1110c_cb.setChecked(true);} else {ga1110c_cb.setChecked(false);}
                if (tinModel.isGa1110d()) {ga1110d_cb.setChecked(true);} else {ga1110d_cb.setChecked(false);}
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

        mainViewModel.getSalaries(ga1101, ga1105);
        mainViewModel.getSalariesLiveData.observe(Ga11Activity.this, new Observer<SalariesModel>() {
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


                mainViewModel.getG11Data(ga1101, ga1105);
                mainViewModel.getGa11LiveData.observe(Ga11Activity.this, new Observer<Ga11Model>() {
                    @Override
                    public void onChanged(Ga11Model ga11Model) {
                        long tax00,tax05, tax10, tax15, tax20;
                        ga1101_tv.setText(ga11Model.getGa1101());
                        ga1112_tv.setText(ga11Model.getGa1112());

                        tax00 = ga11Model.getTax_limit_00();
                        tax05 = ga11Model.getTax_limit_05();
                        tax10 = ga11Model.getTax_limit_10();
                        tax15 = ga11Model.getTax_limit_15();
                        tax20 = ga11Model.getTax_limit_20();


                        ga1124 = a24taxable;
                        ga1125 = ga11Model.getGa1125();
                        ga1126 = 0;
                        ga1127 = ga11Model.getGa1127();
                        ga1128 = 0;
                        ga1129 = ga11Model.getGa1129();
                        ga1130 = ga11Model.getGa1130();
                        ga1131 = ga11Model.getGa1131();
                        ga1132 = ga11Model.getGa1132();
                        ga1133 = ga11Model.getGa1133();
                        ga1138 = ga11Model.getGa1138();
                        ga1139 = ga11Model.getGa1139();
                        ga1140 = ga11Model.getGa1140();
                        ga1142 = ga11Model.getGa1142();
                        ga1143 = ga11Model.getGa1143();
                        ga1144 = ga11Model.getGa1144();
                        ga1145 = ga11Model.getGa1145();
                        ga1134 = ga1124+ga1125+ga1126+ga1127+ga1128+ga1129+ga1130+ga1131+ga1132+ga1133;


                        if (ga1134-tax00 <= tax05){
                            ga1135 =  (ga1134 - tax00)*05/100;
                        } else if (ga1134-tax00 <= tax05+tax10) {
                            ga1135 = tax05*05/100+ (ga1134-tax00-tax05)*10/100;
                        } else if (ga1134-tax00 <= tax05+tax10+tax15) {
                            ga1135 = tax05*05/100+ tax10*10/100 + (ga1134-tax10-tax05-tax00)*15/100;
                        } else if (ga1134-tax00 <= tax05+tax10+tax15+tax20) {
                            ga1135 = tax05*05/100+ tax10*10/100 +tax15*15/100 + (ga1134-tax15-tax10-tax05-tax00)*20/100;
                        } else if (ga1134-tax00 > tax05+tax10+tax15+tax20) {
                            ga1135 = tax05*05/100+ tax10*10/100 +tax15*15/100 +tax20*20/100 + (ga1134-tax20-tax15-tax10-tax05-tax00)*25/100;
                        }


                        mainViewModel.getRebate(ga1101, ga1105);
                        mainViewModel.getRebateLiveData.observe(Ga11Activity.this, new Observer<RebateModel>() {
                            @Override
                            public void onChanged(RebateModel rebateModel) {

                                d2413 = rebateModel.getD2403()+
                                        rebateModel.getD2404()+
                                        rebateModel.getD2405()+
                                        rebateModel.getD2406()+
                                        rebateModel.getD2407()+
                                        rebateModel.getD2409()+
                                        rebateModel.getD2410()+
                                        rebateModel.getD2411()+
                                        rebateModel.getD2412();

                                min = Math.min(d2413, Math.min(a24taxable/4,15000000));
                                if (a24taxable >1500000) {
                                    ga1136 = min*12/100;
                                } else {
                                    ga1136 = min*10/100;
                                }
                                ga1137 = ga1135 -ga1136;
                                ga1141 = Math.max(ga1137, ga1138) + ga1139 + ga1140;
                                ga1146 = ga1142 +ga1143 +ga1144 +ga1145;
                                ga1147 = ga1141 - ga1146;
                                ga1148 = a24exempted;


                                ga1124_tv.setText(Methods.indianCurrencyFormat(ga1124));
                                ga1125_tv.setText(Methods.indianCurrencyFormat(ga1125));
                                ga1126_tv.setText(Methods.indianCurrencyFormat(ga1126));
                                ga1127_tv.setText(Methods.indianCurrencyFormat(ga1127));
                                ga1128_tv.setText(Methods.indianCurrencyFormat(ga1128));
                                ga1129_tv.setText(Methods.indianCurrencyFormat(ga1129));
                                ga1130_tv.setText(Methods.indianCurrencyFormat(ga1130));
                                ga1131_tv.setText(Methods.indianCurrencyFormat(ga1131));
                                ga1132_tv.setText(Methods.indianCurrencyFormat(ga1132));
                                ga1133_tv.setText(Methods.indianCurrencyFormat(ga1133));
                                ga1134_tv.setText(Methods.indianCurrencyFormat(ga1134));
                                ga1135_tv.setText(Methods.indianCurrencyFormat(ga1135));
                                ga1136_tv.setText(Methods.indianCurrencyFormat(ga1136));
                                ga1137_tv.setText(Methods.indianCurrencyFormat(ga1137));
                                ga1138_tv.setText(Methods.indianCurrencyFormat(ga1138));
                                ga1139_tv.setText(Methods.indianCurrencyFormat(ga1139));
                                ga1140_tv.setText(Methods.indianCurrencyFormat(ga1140));
                                ga1141_tv.setText(Methods.indianCurrencyFormat(ga1141));
                                ga1142_tv.setText(Methods.indianCurrencyFormat(ga1142));
                                ga1143_tv.setText(Methods.indianCurrencyFormat(ga1143));
                                ga1144_tv.setText(Methods.indianCurrencyFormat(ga1144));
                                ga1145_tv.setText(Methods.indianCurrencyFormat(ga1145));
                                ga1146_tv.setText(Methods.indianCurrencyFormat(ga1146));
                                ga1147_tv.setText(Methods.indianCurrencyFormat(ga1147));
                                ga1148_tv.setText(Methods.indianCurrencyFormat(ga1148));

                            }
                        });

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
                editGa11();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void editGa11() {
        Intent intent = new Intent(this, Ga11EditActivity.class);
        intent.putExtra("tin", ga1105);
        intent.putExtra("tax_year", ga1101);
        startActivity(intent);
    }
}