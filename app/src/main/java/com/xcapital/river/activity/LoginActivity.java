package com.xcapital.river.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.xcapital.river.R;

/**
 * Created by kshivang on 07/03/17.
 *
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    public void Skip(View view) {
        startActivity(new Intent(LoginActivity.this, SwipeActivity.class));
    }

    public void Login(View view) {
        TextInputLayout tilMobile = ((TextInputLayout)findViewById(R.id.mobileInput));
        EditText etMobile = tilMobile.getEditText();

        if (etMobile != null) {
            String mobileNo = etMobile.getText().toString();
            if (mobileNo.length() >= 10) {
                Boolean status = checkNumber(mobileNo);
                if (status != null) if (status) onLogin(mobileNo);
                                    else onRegister(mobileNo);
                else tilMobile.setError("Incorrect Mobile No.");
            }
        }
    }

    /**
     * Check user is registered on not
     * @param mobileNo : Phone
     * @return true for user exist, false for new user, null for incorrect number
     */
    private Boolean checkNumber(String mobileNo) {
        if (mobileNo.length() > 12)
            return true;
        else
            return null;
    }

    private void onLogin(String mobileNo) {

    }

    private void onRegister(String mobileNo) {

    }
}
