package com.example.ejercicio13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TriviaActivity extends AppCompatActivity {

    private RadioGroup answerOptions;
    private String correctAnswer = "Pertenece a Whatsapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        TextView usernameGreeting = findViewById(R.id.usernameGreeting);
        String username = getIntent().getStringExtra("USERNAME");
        usernameGreeting.setText("Hola, " + username + "!");

        answerOptions = findViewById(R.id.answerOptions);
        Button submitAnswer = findViewById(R.id.submitAnswer);

        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = answerOptions.getCheckedRadioButtonId();
                RadioButton selectedAnswer = findViewById(selectedId);
                String answer = selectedAnswer.getText().toString();

                Intent intent = new Intent(TriviaActivity.this, ResultActivity.class);
                if (answer.equals(correctAnswer)) {
                    intent.putExtra("RESULT", "¡Genial " + username + ", Ganaste!");
                } else {
                    intent.putExtra("RESULT", "Te equivocaste " + username + ", ¡Inténtalo otra vez!");
                }
                startActivity(intent);
            }
        });
    }
}

