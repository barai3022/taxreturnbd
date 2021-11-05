package com.dvillage.taxreturnbd.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.adapter.FormAdapter;
import com.dvillage.taxreturnbd.model.FormModel;
import com.dvillage.taxreturnbd.viewmodel.MainViewModel;

import java.util.List;

public class FormActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    RecyclerView form_rv;
    private Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mainViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(MainViewModel.class);

        mainToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        form_rv = findViewById(R.id.rv_form);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        form_rv.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        String taxYear = intent.getStringExtra("tax_year");

        getSupportActionBar().setTitle(taxYear);
        mainViewModel.getFormList(taxYear);
        mainViewModel.getFormListLiveData.observe(this, new Observer<List<FormModel>>() {
            @Override
            public void onChanged(List<FormModel> formModels) {
                FormAdapter adapter = new FormAdapter(FormActivity.this, formModels);
                form_rv.setAdapter(adapter);
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
}