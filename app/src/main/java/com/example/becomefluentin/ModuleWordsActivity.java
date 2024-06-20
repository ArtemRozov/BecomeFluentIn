package com.example.becomefluentin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.becomefluentin.api.Api;
import com.example.becomefluentin.api.ApiService;
import com.example.becomefluentin.modules.Word;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModuleWordsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_words);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Получаем ID модуля из Intent
        int moduleId = getIntent().getIntExtra("moduleId", -1);
        if (moduleId != -1) {
            getModuleWords(1);
        } else {
            Toast.makeText(this, "Module ID not found", Toast.LENGTH_SHORT).show();
            finish(); // Завершаем активность, если ID модуля не был передан
        }
    }

    private void getModuleWords(int userId) {
        ApiService apiService = Api.getInsecureClient().create(ApiService.class);
        Call<List<Word>> call = apiService.getModuleWords(userId);

        call.enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {
                if (response.isSuccessful()) {
                    List<Word> words = response.body();
                    for(Word w: words){
                        System.out.println("Word name: " + w.getName());
                    }
                    wordAdapter = new WordAdapter(words);
                    recyclerView.setAdapter(wordAdapter);
                } else {
                    Toast.makeText(ModuleWordsActivity.this, "Failed to fetch module words", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Word>> call, Throwable t) {
                Toast.makeText(ModuleWordsActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error: " + t.getMessage());
            }
        });
    }
}