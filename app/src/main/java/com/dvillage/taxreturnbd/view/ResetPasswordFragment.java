package com.dvillage.taxreturnbd.view;

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
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.viewmodel.RegisterViewModel;
import com.google.android.material.textfield.TextInputLayout;


public class ResetPasswordFragment extends Fragment {

    private RegisterViewModel registerViewModel;

    private FrameLayout register_frame_layout;
    private TextInputLayout registeredEmail_til;
    private Button resetPassword_btn;
    private TextView goBack_tv;
    private ViewGroup container;
    private ImageView emailIcon_iv;
    private TextView emailIcon_tv;
    private ProgressBar progressBar;

    public ResetPasswordFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory.getInstance(getActivity().getApplication()))
                .get(RegisterViewModel.class);

        register_frame_layout = getActivity().findViewById(R.id.register_frame_layout);

        registeredEmail_til = view.findViewById(R.id.til_ga1121);
        resetPassword_btn = view.findViewById(R.id.reset_password);
        goBack_tv = view.findViewById(R.id.go_back);

        container = view.findViewById(R.id.container);
        emailIcon_iv = view.findViewById(R.id.email_icon);
        emailIcon_tv = view.findViewById(R.id.email_icon_text);

        progressBar = view.findViewById(R.id.progress_bar);

        registeredEmail_til.getEditText().addTextChangedListener(new TextWatcher() {
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

        resetPassword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = registeredEmail_til.getEditText().getText().toString();
                TransitionManager.beginDelayedTransition(container);
                emailIcon_tv.setVisibility(View.GONE);

                TransitionManager.beginDelayedTransition(container);
                emailIcon_iv.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                resetPassword_btn.setEnabled(false);
                resetPassword_btn.setTextColor(Color.argb(50, 255,255, 255));

                registerViewModel.sendPasswordResetMail(email);
                registerViewModel.sendPasswordResetMailLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        if ( s == "Okay") {
                            TransitionManager.beginDelayedTransition(container);
                            emailIcon_tv.setVisibility(View.VISIBLE);

                            TransitionManager.beginDelayedTransition((container));
                            emailIcon_iv.setVisibility(View.GONE);
                            progressBar.setVisibility(View.GONE);

                            registeredEmail_til.getEditText().setText("");
                        } else {
                            Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        goBack_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignInFragment());
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(register_frame_layout.getId(),fragment);
        fragmentTransaction.commit();
    }

    private void checkInput() {
        if(TextUtils.isEmpty(registeredEmail_til.getEditText().getText())){
            resetPassword_btn.setEnabled(false);
            resetPassword_btn.setTextColor(Color.argb(50,255,255,255));
        } else {
            resetPassword_btn.setEnabled(true);
            resetPassword_btn.setTextColor(Color.rgb(255,255,255));
        }
    }
}