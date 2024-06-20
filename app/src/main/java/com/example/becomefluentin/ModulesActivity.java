package com.example.becomefluentin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.becomefluentin.api.Api;
import com.example.becomefluentin.api.ApiService;
import com.example.becomefluentin.modules.Module;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModulesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ModuleAdapter moduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_info);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        int userId = 1;
        getUserModules(userId);
    }

    private void getUserModules(int userId) {
        ApiService apiService = Api.getInsecureClient().create(ApiService.class);
        Call<List<Module>> call = apiService.getUserModules(userId);

        call.enqueue(new Callback<List<Module>>() {
            @Override
            public void onResponse(Call<List<Module>> call, Response<List<Module>> response) {
                if (response.isSuccessful()) {
                    List<Module> modules = response.body();
                    moduleAdapter = new ModuleAdapter(modules);
                    recyclerView.setAdapter(moduleAdapter);
                } else {
                    Toast.makeText(ModulesActivity.this, "Failed to fetch modules", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Module>> call, Throwable t) {
                Toast.makeText(ModulesActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

