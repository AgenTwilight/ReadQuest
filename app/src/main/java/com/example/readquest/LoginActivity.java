package com.example.readquest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextView SignUp;
    private Button Login;
    private TextInputEditText registUser;
    private TextInputEditText registPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        SignUp = findViewById(R.id.SignUp);
        Login = findViewById(R.id.registAcc);
        registUser = findViewById(R.id.registuser);
        registPass = findViewById(R.id.registPass);

        SharedPreferences preferencesLogin = getSharedPreferences("preferencesLogin", MODE_PRIVATE);
        boolean checkLogin = preferencesLogin.getBoolean("checkLogin", false);

        SharedPreferences preferences = getSharedPreferences("preferencesStart", MODE_PRIVATE);
        boolean checkStart = preferences.getBoolean("checkStart", false);

        if (!checkStart){
            Intent toStart = new Intent(LoginActivity.this, StartActivity.class);
            startActivity(toStart);
            finish();
        }

        if (checkLogin){
            Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(toMain);
            finish();
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(LoginActivity.this);
                String username = registUser.getText().toString();
                String password = registPass.getText().toString();

                SharedPreferences preferencesUsername = LoginActivity.this.getSharedPreferences("preferencesUsername", MODE_PRIVATE);
                SharedPreferences.Editor editorUsername = preferencesUsername.edit();
                editorUsername.putString("usernameLogin", username);
                editorUsername.apply();

                if (databaseHelper.checkUsernamePassword(username, password)){
                    SharedPreferences preferences = LoginActivity.this.getSharedPreferences("preferencesLogin", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("checkLogin", true);
                    editor.apply();
                    Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(toMain);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Username Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
