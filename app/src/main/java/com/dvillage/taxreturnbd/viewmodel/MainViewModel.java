package com.dvillage.taxreturnbd.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dvillage.taxreturnbd.model.A24Model;
import com.dvillage.taxreturnbd.model.FormModel;
import com.dvillage.taxreturnbd.model.Ga11Model;
import com.dvillage.taxreturnbd.model.NoticeModel;
import com.dvillage.taxreturnbd.model.RebateModel;
import com.dvillage.taxreturnbd.model.SalariesModel;
import com.dvillage.taxreturnbd.model.TaxYearModel;
import com.dvillage.taxreturnbd.model.TinModel;
import com.dvillage.taxreturnbd.model.UserModel;
import com.dvillage.taxreturnbd.repository.MainRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MainRepository mainRepository;

    public LiveData<UserModel> getUserLiveData;
    public LiveData<TinModel> getTinLiveData;
    public LiveData<String> setTinLiveData;
    public LiveData<List<TaxYearModel>> getTaxYearListLiveData;
    public LiveData<String> setTaxYearDataLiveData;
    public LiveData<List<FormModel>> getFormListLiveData;
    public LiveData<SalariesModel> getSalariesLiveData;
    public LiveData<String> setSalariesLiveData;
    public LiveData<List<A24Model>> getA24LiveData;
    public LiveData<RebateModel> getRebateLiveData;
    public LiveData<String> setRebateLiveData;
    public LiveData<Ga11Model> getGa11LiveData;
    public LiveData<String> setGa11LiveData;
    public LiveData<NoticeModel> getNoticeLiveData;


    public MainViewModel(@NonNull Application application) {
        super(application);
        mainRepository = new MainRepository();
    }

    public void getUser() {
        getUserLiveData = mainRepository.getUserMutableLiveData();
    }

    public void getTin(String tin) {
        getTinLiveData = mainRepository.getTinMutableLiveData(tin);
    }

    public void setTin(TinModel tinModel) {
        setTinLiveData = mainRepository.setTinMutableLiveData(tinModel);
    }

    public void getTaxYearList() {
        getTaxYearListLiveData = mainRepository.getTaxYearListMutableLiveData();
    }

    public void setTaxYearData(TaxYearModel taxYearModel) {
        setTaxYearDataLiveData = mainRepository.setTaxYearModelMutableLiveData(taxYearModel);
    }

    public void getFormList(String taxYear) {
        getFormListLiveData = mainRepository.getFormListMutableLiveData(taxYear);
    }
    public void getSalaries(String ga1101, String ga1105) {
        getSalariesLiveData = mainRepository.getSalariesMutableLiveData(ga1101, ga1105);
    }

    public void setSalaries(SalariesModel salariesModel) {
        setSalariesLiveData = mainRepository.setSalariesMutableLiveData(salariesModel);
    }

    public void getA24(String taxYear, String tin) {
        getA24LiveData = mainRepository.getA24MutableLiveData(taxYear, tin);
    }

    public void getRebate(String ga1101, String ga1105) {
        getRebateLiveData = mainRepository.getRebateMutableLiveData(ga1101, ga1105);
    }

    public void setRebate(RebateModel rebateModel) {
        setRebateLiveData = mainRepository.setRebateMutableLiveData(rebateModel);
    }
     public void getG11Data(String ga1101, String ga1105){
         getGa11LiveData = mainRepository.getG11DataMutableLiveData(ga1101, ga1105);
     }
    public void setGa11(Ga11Model ga11Model) {
        setGa11LiveData = mainRepository.setGa11MutableLiveData(ga11Model);
    }
     public void getNotice(){
        getNoticeLiveData = mainRepository.getNoticeMutableLiveData();
     }
}