package com.example.becomefluentin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.becomefluentin.modules.Word;

import java.util.ArrayList;
import java.util.List;

public class ModuleInfo extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WordAdapter wordAdapter;
    private List<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_info);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Пример данных
        wordList = new ArrayList<>();
        wordList.add(new Word("apple"));
        wordList.add(new Word("banana"));
        wordList.add(new Word("cherry"));
        wordList.add(new Word("date"));
        wordList.add(new Word("elderberry"));

        wordAdapter = new WordAdapter(wordList);
        recyclerView.setAdapter(wordAdapter);
    }
}
