package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    private EditText name,email,password;
    private RetroFitClient RetrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextPersonName2);
        password = findViewById(R.id.editTextTextPassword);

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });
    }

    private void registerUser() {
        String name1 = name.getText().toString().trim();
        String email1 = email.getText().toString().trim();
        String password1 = password.getText().toString().trim();

        if (name1.isEmpty()) {
            name.setError("Username is required");
            name.requestFocus();
            return;
        } else if (password1.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        else if (email1.isEmpty()) {
            email.setError("email is required");
            email.requestFocus();
            return;
        }
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getAPI()
                .createUser(new RegistrationForm(name1,email1,password1));

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = "";
                try {
                    s = response.body().string();
                    System.out.println(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String s1=s.substring(1,8);
                if (s1.equals("SUCCESS")) {
                    Toast.makeText(RegistrationActivity.this, "Successfully registered. Please login", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(RegistrationActivity.this, "User already exists!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println( t.getMessage());
                Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
