package com.dvillage.taxreturnbd.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.viewmodel.RegisterViewModel;
import com.google.android.material.textfield.TextInputLayout;


public class SignInFragment extends Fragment {

    private RegisterViewModel registerViewModel;

    private TextView createAccount_tv;
    private TextView forgotPassword_tv;
    private FrameLayout register_fl;
    private ProgressDialog progressDialog;
    private TextInputLayout email_til;
    private TextInputLayout password_til;

    private Button signIn_btn;
    private ProgressBar progressBar;

    private String email, password;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(getActivity().getApplication()))
                .get(RegisterViewModel.class);

        register_fl = getActivity().findViewById(R.id.register_frame_layout);
        createAccount_tv = view.findViewById(R.id.create_account);
        forgotPassword_tv = view.findViewById(R.id.forgot_password);
        email_til = view.findViewById(R.id.til_ga1121);
        password_til = view.findViewById(R.id.password);
        signIn_btn = view.findViewById(R.id.sign_in_btn);
        progressBar = view.findViewById(R.id.progress_bar);

        createAccount_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignUpFragment());
            }
        });

        forgotPassword_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new ResetPasswordFragment());
            }
        });

        email_til.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password_til.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithEmailAndPassword();
            }
        });

    }

    private void signInWithEmailAndPassword() {
        email = email_til.getEditText().getText().toString();
        password = password_til.getEditText().getText().toString();

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && password_til.getEditText().length() >=6) {
            progressBar.setVisibility(View.VISIBLE);
            disableSignInBtn();

            registerViewModel.signIn(email, password);
            registerViewModel.signInLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    if (s == "Okay") {
                        mainIntent();
                    } else {
                        progressBar.setVisibility(View.INVISIBLE);
                        enableSignInBtn();
                        Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(getActivity(), "Input correct Email and Password", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(email_til.getEditText().getText()) && !TextUtils.isEmpty(password_til.getEditText().getText())) {
            enableSignInBtn();

        } else {
            disableSignInBtn();
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(register_fl.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void enableSignInBtn(){
        signIn_btn.setEnabled(true);
        signIn_btn.setTextColor(Color.rgb(255, 255, 255));
    }

    private void disableSignInBtn(){
        signIn_btn.setEnabled(false);
        signIn_btn.setTextColor(Color.argb(50, 255, 255, 255));
    }

    private void mainIntent() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}