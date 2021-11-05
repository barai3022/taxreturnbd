package com.dvillage.taxreturnbd.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.dvillage.taxreturnbd.R;

public class RegisterActivity extends AppCompatActivity {
    public static boolean isResetPasswordFragment = false;
    public static boolean isSignUpFragment = false;

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        frameLayout = findViewById(R.id.register_frame_layout);

        if (isSignUpFragment) {
            isSignUpFragment = false;
            setDefaultFragment(new SignUpFragment());
        } else {
            setDefaultFragment(new SignInFragment());
        }

    }

    private void setDefaultFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}