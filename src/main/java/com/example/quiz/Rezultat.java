package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Rezultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultat);

        final AppCompatButton restart = findViewById(R.id.butonrestart);
        final TextView raspunsuricorecte = findViewById(R.id.raspunsuricorecte);
        final TextView raspincorecte = findViewById(R.id.raspunsuriincorecte);

        final int IaRaspunsuriCorecte = getIntent().getIntExtra("Raspunsuri corecte", 0);
        final int IaRaspunsuriGresite = getIntent().getIntExtra("Raspunsuri incorecte", 0);

        raspunsuricorecte.setText(String.valueOf(IaRaspunsuriCorecte));
        raspincorecte.setText(String.valueOf(IaRaspunsuriGresite));

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Rezultat.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(Rezultat.this, MainActivity.class));
        finish();
    }
}