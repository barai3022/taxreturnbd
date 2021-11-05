package com.dvillage.taxreturnbd.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dvillage.taxreturnbd.repository.RegisterRepository;

public class RegisterViewModel extends AndroidViewModel {
    private RegisterRepository registerRepository;
    public LiveData<String> createUserLiveData;
    public LiveData<String> signInLiveData;
    public LiveData<String> sendPasswordResetMailLiveData;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        registerRepository = new RegisterRepository();
    }

    public void createUser(String tin, String email, String password) {
        createUserLiveData = registerRepository.createUserMutableLiveData(tin, email, password);
    }

    public void signIn(String email, String password) {
        signInLiveData = registerRepository.signInFirebaseMutableLiveData(email, password);
    }

    public void sendPasswordResetMail(String email){
        sendPasswordResetMailLiveData = registerRepository.sendPasswordResetEmailMutableLiveData(email);
    }
}
