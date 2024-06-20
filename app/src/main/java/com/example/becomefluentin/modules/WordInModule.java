package com.example.becomefluentin.modules;

import java.time.LocalDateTime;
import java.util.Date;

public class WordInModule {
    private int wordId;
    private Word word;
    private int moduleId;
    private Module module;
    private LocalDateTime addingTime;

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public LocalDateTime getAddingTime() {
        return addingTime;
    }

    public void setAddingTime(LocalDateTime addingTime) {
        this.addingTime = addingTime;
    }
}
