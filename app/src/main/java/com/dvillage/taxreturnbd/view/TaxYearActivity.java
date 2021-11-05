package com.dvillage.taxreturnbd.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.adapter.TaxYearAdapter;
import com.dvillage.taxreturnbd.model.TaxYearModel;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class TaxYearActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private Toolbar mainToolbar;
    String tin;
    private RecyclerView taxYear_rv;
    private TaxYearAdapter taxYearAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_year);

        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mainViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        Intent intent = getIntent();
        tin = intent.getStringExtra("tin");
        setTitle(tin);

        taxYear_rv = findViewById(R.id.tax_year_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        taxYear_rv.setLayoutManager(layoutManager);

        mainViewModel.getTaxYearList();
        mainViewModel.getTaxYearListLiveData.observe(this, new Observer<List<TaxYearModel>>() {
            @Override
            public void onChanged(List<TaxYearModel> taxYearModels) {
                taxYearAdapter = new TaxYearAdapter(TaxYearActivity.this, taxYearModels);
                taxYear_rv.setAdapter(taxYearAdapter);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_icon_black, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.add:
                setTaxYear();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setTaxYear() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_tax_year, null);
        TextInputLayout taxYear_til = view.findViewById(R.id.tax_year);
        TextInputLayout taxYearText_til = view.findViewById(R.id.tax_year_text);

        builder.setView(view).setTitle("Add New Tax Year").setIcon(R.drawable.ic_baseline_add_24).setCancelable(true)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String taxYear = taxYear_til.getEditText().getText().toString();
                        String taxYearText = taxYearText_til.getEditText().getText().toString();
                        long timestamp = System.currentTimeMillis();
                        TaxYearModel taxYearModel = new TaxYearModel(taxYear, taxYearText, timestamp);

                        mainViewModel.setTaxYearData(taxYearModel);
                        mainViewModel.setTaxYearDataLiveData.observe(TaxYearActivity.this, new Observer<String>() {
                            @Override
                            public void onChanged(String s) {
                                if (s == "Okay") {
                                    Toast.makeText(TaxYearActivity.this, "Tax Year added", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(TaxYearActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.create().show();
    }

}