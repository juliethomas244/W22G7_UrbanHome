package com.example.urbanhomeapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Feedback {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String email;
    private String feedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}