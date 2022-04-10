package com.example.urbanhomeapp.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.urbanhomeapp.model.Feedback;

import java.util.List;

@Dao
public interface FeedbackDao {
    @Insert
    void insert(Feedback feedback);

    @Delete
    void delete(Feedback feedback);

    @Delete
    void delete(List<Feedback> feedbacks);

    @Query("SELECT * FROM Feedback")
    List<Feedback> getFeedbackAll();
}
