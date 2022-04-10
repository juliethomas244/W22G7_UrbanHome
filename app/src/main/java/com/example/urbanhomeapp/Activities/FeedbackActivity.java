package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.urbanhomeapp.Daos.FeedbackDao;
import com.example.urbanhomeapp.Database.FeedbackDatabase;
import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.Feedback;

public class FeedbackActivity extends AppCompatActivity {
    EditText editTextEmail;
    EditText editTextMsg;
    Button btnSend;
    private FeedbackDao feedbackDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        FeedbackDatabase database = Room.databaseBuilder(getApplicationContext(), FeedbackDatabase.class,
                "Feedback_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        feedbackDao = database.feedbackDao();

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMsg = findViewById(R.id.editTextMsg);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener((View view)->{
            if (editTextEmail.getText().toString().isEmpty()) {
                Toast.makeText(this, "Email is invalid", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Thanks for contacting us. We'll get back to you as soon as possible.", Toast.LENGTH_SHORT).show();
                String email = editTextEmail.getText().toString();
                String msg = editTextMsg.getText().toString();

                Feedback feedback = new Feedback();
                feedback.setEmail(email);
                feedback.setFeedback(msg);

                feedbackDao.insert(feedback);

                editTextEmail.setText("");
                editTextMsg.setText("");
            }
        });
    }
}