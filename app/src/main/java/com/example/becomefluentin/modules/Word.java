package com.example.becomefluentin.modules;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

public class Word {
    private String name;
    private List<Translation> translations;
    private int userId;
    @SerializedName("addingTime")
    private LocalDateTime addingTime;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getAddingTime() {
        return addingTime;
    }

    public void setAddingTime(LocalDateTime addingTime) {
        this.addingTime = addingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

