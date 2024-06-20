package com.example.becomefluentin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.becomefluentin.api.Api;
import com.example.becomefluentin.api.ApiService;
import com.example.becomefluentin.modules.AuthResponse;
import com.example.becomefluentin.modules.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private ApiService authService;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.button);
        usernameEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        Retrofit retrofit = Api.getInsecureClient();
        authService = retrofit.create(ApiService.class);

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            loginUser(username, password);});
    }

    private void loginUser(String username, String password) {
        ApiService apiService = Api.getInsecureClient().create(ApiService.class);
        LoginModel loginModel = new LoginModel(username, password);

        Call<AuthResponse> call = apiService.login(loginModel);
        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()) {
                    AuthResponse loginResponse = response.body();
                    if (loginResponse != null) {
                        saveToken(loginResponse.getToken());
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        // Перейти на следующую активность
                        Intent intent = new Intent(MainActivity.this, ModulesActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveToken(String token) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.apply();
    }
}