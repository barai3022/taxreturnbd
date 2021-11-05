package com.dvillage.taxreturnbd.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.dvillage.taxreturnbd.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class RegisterRepository {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();


    public MutableLiveData<String> createUserMutableLiveData(String tin, String email, String password){
        MutableLiveData<String> createUserStatus = new MutableLiveData<>();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String uid = mAuth.getUid();
                            long timestamp = System.currentTimeMillis();

                            UserModel userModel = new UserModel(tin, email, uid, timestamp);
                            db.collection("user").document(uid)
                                    .set(userModel)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            String status = "Okay";
                                            createUserStatus.setValue(status);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            String status = e.toString();
                                            createUserStatus.setValue(status);
                                        }
                                    });
                        } else {
                            String error = task.getException().toString();
                            createUserStatus.setValue(error);
                        }
                    }
                });

        return createUserStatus;
    }

    public MutableLiveData<String> signInFirebaseMutableLiveData(String email, String password) {
        MutableLiveData<String> signInFirebaseStatus = new MutableLiveData<>();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String status = "Okay";
                            signInFirebaseStatus.setValue(status);
                        } else {
                            String error = task.getException().toString();
                            signInFirebaseStatus.setValue(error);
                        }
                    }
                });
        return signInFirebaseStatus;
    }

    public MutableLiveData<String> sendPasswordResetEmailMutableLiveData(String email) {
        MutableLiveData<String> sendMailStatus = new MutableLiveData<>();

        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            String status = "Okay";
                            sendMailStatus.setValue(status);
                        } else {
                            String error = task.getException().toString();
                            sendMailStatus.setValue(error);
                        }
                    }
                });

        return sendMailStatus;
    }


}
