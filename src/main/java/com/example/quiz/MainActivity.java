package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String Subiect = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);

        final LinearLayout adunare = findViewById(R.id.adunare);
        final LinearLayout scadere = findViewById(R.id.scadere);
        final LinearLayout inmultire = findViewById(R.id.inmultire);
        final LinearLayout impartire = findViewById(R.id.impartire);

        final Button startbtn = findViewById(R.id.butonstart);


        adunare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Subiect = "Adunare";

                adunare.setBackgroundResource(R.drawable.buton_start_spate);
                scadere.setBackgroundResource(R.drawable.butonalegere);
                inmultire.setBackgroundResource(R.drawable.butonalegere);
                impartire.setBackgroundResource(R.drawable.butonalegere);
            }
        });

        scadere.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Subiect = "Scadere";

                adunare.setBackgroundResource(R.drawable.butonalegere);
                scadere.setBackgroundResource(R.drawable.buton_start_spate);
                inmultire.setBackgroundResource(R.drawable.butonalegere);
                impartire.setBackgroundResource(R.drawable.butonalegere);
            }
        });

        inmultire.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Subiect = "Inmultire";

                adunare.setBackgroundResource(R.drawable.butonalegere);
                scadere.setBackgroundResource(R.drawable.butonalegere);
                inmultire.setBackgroundResource(R.drawable.buton_start_spate);
                impartire.setBackgroundResource(R.drawable.butonalegere);
            }
        });

        impartire.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Subiect = "Impartire";

                adunare.setBackgroundResource(R.drawable.butonalegere);
                scadere.setBackgroundResource(R.drawable.butonalegere);
                inmultire.setBackgroundResource(R.drawable.butonalegere);
                impartire.setBackgroundResource(R.drawable.buton_start_spate);
            }
        });

        startbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(Subiect.isEmpty()){
                    Toast.makeText(MainActivity.this, "Va rog alegeti subiectul", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, Activitati.class);
                    intent.putExtra("Subiect", Subiect);
                    startActivity(intent);
                }
            }

        });
    }
}