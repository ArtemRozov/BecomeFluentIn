package com.example.becomefluentin.modules;

public class Module {
    private String name;
    private int wordCount;

    public Module(String name, int wordCount) {
        this.name = name;
        this.wordCount = wordCount;
    }

    public String getName() {
        return name;
    }

    public int getWordCount() {
        return wordCount;
    }
}