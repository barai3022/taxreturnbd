package com.dvillage.taxreturnbd.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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


public class SignUpFragment extends Fragment {

    private TextView haveAccount_tv;
    private FrameLayout register_fl;
    private ProgressDialog progressDialog;
    private TextInputLayout tin_til, email_til, password_til, confirmPassword_til;

    private Button createUser_btn;
    private ProgressBar progressBar;

    private RegisterViewModel registerViewModel;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViewModel();

        register_fl = getActivity().findViewById(R.id.register_frame_layout);
        haveAccount_tv = view.findViewById(R.id.have_account);
        tin_til = view.findViewById(R.id.tin);
        email_til = view.findViewById(R.id.til_ga1121);
        password_til = view.findViewById(R.id.password);
        confirmPassword_til = view.findViewById(R.id.confirm_password);
        createUser_btn = view.findViewById(R.id.sign_in_btn);
        progressBar = view.findViewById(R.id.progress_bar);
        progressDialog = new ProgressDialog(getContext());

        haveAccount_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignInFragment());
            }
        });

        tin_til.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        email_til.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
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
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        confirmPassword_til.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        createUser_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUserWithEmailAndPassword();
            }
        });

    }

    private void createUserWithEmailAndPassword() {
        Drawable customErrorIcon = getResources().getDrawable(R.drawable.ic_email_red_24);
        customErrorIcon.setBounds(0,0,customErrorIcon.getIntrinsicWidth(), customErrorIcon.getIntrinsicHeight());

        String tin = tin_til.getEditText().getText().toString();
        String email = email_til.getEditText().getText().toString();
        String password = password_til.getEditText().getText().toString();
        String confirmPassword = confirmPassword_til.getEditText().getText().toString();

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (password.equals(confirmPassword)) {
                progressBar.setVisibility(View.VISIBLE);
                createUser_btn_Disabled();

                progressDialog.setMessage("Creating Account...");
                progressDialog.show();

                registerViewModel.createUser(tin, email, password);
                registerViewModel.createUserLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        if (s == "Okay") {
                            Toast.makeText(getActivity(), "Data stored in FireStore", Toast.LENGTH_SHORT).show();
                            mainIntent();
                        } else {
                            progressDialog.dismiss();
                            progressBar.setVisibility(View.VISIBLE);
                            createUser_btn_Enabled();
                            Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                confirmPassword_til.getEditText().setError("Password doesn't matched!", customErrorIcon);
            }
        } else {
            email_til.getEditText().setError("Invalid Email!", customErrorIcon);
        }
    }

    private void initViewModel() {
        registerViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(getActivity().getApplication()))
                .get(RegisterViewModel.class);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(register_fl.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void mainIntent() {
        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void checkInput() {
        if (!TextUtils.isEmpty(tin_til.getEditText().getText()) && tin_til.getEditText().length() == 12
                && !TextUtils.isEmpty(email_til.getEditText().getText())
                && !TextUtils.isEmpty(password_til.getEditText().getText()) && password_til.getEditText().length() >= 6
                && !TextUtils.isEmpty(confirmPassword_til.getEditText().getText())
                && confirmPassword_til.getEditText().length() >= 6) {
            createUser_btn_Enabled();
        } else {
            createUser_btn_Disabled();
        }
    }

    private void createUser_btn_Enabled() {
        createUser_btn.setEnabled(true);
        createUser_btn.setTextColor(Color.rgb(255, 255, 255));
    }

    private void createUser_btn_Disabled() {
        createUser_btn.setEnabled(false);
        createUser_btn.setTextColor(Color.argb(50, 255, 255, 255));
    }
}