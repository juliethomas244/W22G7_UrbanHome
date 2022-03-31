package com.example.urbanhomeapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.urbanhomeapp.model.Feedback;

@Database(entities = {Feedback.class}, version = 1)
public abstract class FeedbackDatabase extends RoomDatabase {
    public abstract FeedbackDao feedbackDao();
}
