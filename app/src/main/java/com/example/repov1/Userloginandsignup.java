
package com.example.repov1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Userloginandsignup extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    CheckBox cbRemember;
    TextView tvLoginMessage, tvForgotPassword, tvCreateAccount;

    int loginAttempts = 0;
    boolean isLoggedIn = false;

    // Sample account for testing
    String correctUsername = "admin";
    String correctPassword = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userloginandsignup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        cbRemember = findViewById(R.id.cbRemember);
        tvLoginMessage = findViewById(R.id.tvLoginMessage);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                tvLoginMessage.setText("Please enter your username and password.");
                return;
            }

            loginAttempts++;

            if (username.equals(correctUsername)
                    && password.equals(correctPassword)) {

                isLoggedIn = true;
                tvLoginMessage.setTextColor(
                        Color.rgb(0, 128, 0));
                tvLoginMessage.setText("Login successful!");

                Toast.makeText(
                        Userloginandsignup.this,
                        "Welcome, " + username + "!",
                        Toast.LENGTH_SHORT
                ).show();

                if (cbRemember.isChecked()) {
                    Toast.makeText(
                            Userloginandsignup.this,
                            "Remember me selected",
                            Toast.LENGTH_SHORT
                    ).show();
                }

            } else {
                isLoggedIn = false;
                tvLoginMessage.setTextColor(
                        Color.RED);

                tvLoginMessage.setText(
                        "Invalid username or password. Attempts: "
                                + loginAttempts
                );
            }
        });

        tvForgotPassword.setOnClickListener(v -> {
            Toast.makeText(
                    Userloginandsignup.this,
                    "Please contact the administrator to reset your password.",
                    Toast.LENGTH_LONG
            ).show();
        });

        tvCreateAccount.setOnClickListener(v -> {
            Toast.makeText(
                    Userloginandsignup.this,
                    "Create Account selected",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}
