package com.example.readquest;

import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisterActivity extends AppCompatActivity {
    private TextView Login;
    private TextInputEditText name;
    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputEditText conrmpass;
    private Button register;
    private LinearLayout ll;
    private ProgressBar progressBar;
//    private Button register;
//    private EditText password;
//    private EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        Login = findViewById(R.id.Login);
        name = findViewById(R.id.name);
        username = findViewById(R.id.registUsername);
        password = findViewById(R.id.registPass);
        conrmpass = findViewById(R.id.registConfirmPass);
        register = findViewById(R.id.registerbtn);
        ll = findViewById(R.id.ll);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        ll.setVisibility(View.GONE);

        ExecutorService eexecutors = Executors.newSingleThreadExecutor();
        eexecutors.execute(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            runOnUiThread(()->{
                ll.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                register.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        DatabaseHelper databaseHelper = new DatabaseHelper(RegisterActivity.this);
                        String nameReg = name.getText().toString().trim();
                        String userReg = username.getText().toString().trim();
                        String passReg = password.getText().toString().trim();
                        String conpassReg = conrmpass.getText().toString().trim();
                        SharedPreferences preferences = RegisterActivity.this.getSharedPreferences("preferences", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("name", nameReg);
                        editor.putString("username", userReg);
                        editor.apply();


                        if (nameReg.isEmpty() || userReg.isEmpty()){
                            Toast.makeText(RegisterActivity.this, "Please enter the field", Toast.LENGTH_SHORT).show();
                        } else {
                            if (databaseHelper.checkUsername(userReg)){
                                Toast.makeText(RegisterActivity.this, "Username Already Exists", Toast.LENGTH_SHORT).show();
                            } else {
                                if (passReg.equalsIgnoreCase(conpassReg)){
                                    databaseHelper.insertDataUser(nameReg,userReg,passReg);
                                    Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(toLogin);
                                    finish();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Your confirm password is not match", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
                Login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
            });

        });



    }
}