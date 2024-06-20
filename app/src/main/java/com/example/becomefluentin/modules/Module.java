package com.example.becomefluentin.modules;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Module {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("descriptions")
    private String descriptions;

    @SerializedName("userId")
    private int userId;

    @SerializedName("words")
    private List<Word> words;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    // Getters and setters
}