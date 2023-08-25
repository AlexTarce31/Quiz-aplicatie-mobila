package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Activitati extends AppCompatActivity {

    private TextView intrebari;
    private TextView intrebare;

    private AppCompatButton opt1,opt2,opt3,opt4;

    private AppCompatButton urmatorulBtn;

    private Timer apptimer;

    private int TimpinMin = 1;

    private int secunde = 0;

    private List<ListaIntrebari> listaintrebari ;

    private int PozIntrebareCurenta = 0;

    private String OptiuneSelectata = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitati);

        final ImageView backbtn = findViewById(R.id.backbtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView subiect = findViewById(R.id.subiect);

        intrebari = findViewById(R.id.intrebari);
        intrebare = findViewById(R.id.intrebare);

        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);

        urmatorulBtn = findViewById(R.id.urm);

        final String subiectulAles = getIntent().getStringExtra("Subiect");

        subiect.setText(subiectulAles);

        listaintrebari = BancaDeIntrebari.listaIntrebari(subiectulAles);

        startTimer(timer);

        intrebari.setText((PozIntrebareCurenta+1)+"/"+listaintrebari.size());
        intrebare.setText(listaintrebari.get(0).getIntrebare());
        opt1.setText(listaintrebari.get(0).getOpt1());
        opt2.setText(listaintrebari.get(0).getOpt2());
        opt3.setText(listaintrebari.get(0).getOpt3());
        opt4.setText(listaintrebari.get(0).getOpt4());

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(OptiuneSelectata.isEmpty())
                {
                    OptiuneSelectata = opt1.getText().toString();

                    opt1.setBackgroundResource(R.drawable.butonrosu);
                    opt1.setTextColor(Color.WHITE);

                    RaspunsCorect();

                    listaintrebari.get(PozIntrebareCurenta).setRaspunsSelectat(OptiuneSelectata);
                }

            }
        });

        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(OptiuneSelectata.isEmpty())
                {
                    OptiuneSelectata = opt2.getText().toString();

                    opt2.setBackgroundResource(R.drawable.butonrosu);
                    opt2.setTextColor(Color.WHITE);

                    RaspunsCorect();

                    listaintrebari.get(PozIntrebareCurenta).setRaspunsSelectat(OptiuneSelectata);
                }

            }
        });

        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(OptiuneSelectata.isEmpty())
                {
                    OptiuneSelectata = opt3.getText().toString();

                    opt3.setBackgroundResource(R.drawable.butonrosu);
                    opt3.setTextColor(Color.WHITE);

                    RaspunsCorect();

                    listaintrebari.get(PozIntrebareCurenta).setRaspunsSelectat(OptiuneSelectata);
                }

            }
        });

        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(OptiuneSelectata.isEmpty())
                {
                    OptiuneSelectata = opt4.getText().toString();

                    opt4.setBackgroundResource(R.drawable.butonrosu);
                    opt4.setTextColor(Color.WHITE);

                    RaspunsCorect();

                    listaintrebari.get(PozIntrebareCurenta).setRaspunsSelectat(OptiuneSelectata);
                }

            }
        });

        urmatorulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(subiectulAles.isEmpty())
                {
                    Toast.makeText(Activitati.this, "Selectati o optiune!", Toast.LENGTH_SHORT).show();
                }
                else{

                    urmatoareIntrebare();
                }

            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                apptimer.purge();
                apptimer.cancel();

                startActivity(new Intent(Activitati.this, MainActivity.class));
                finish();
            }
        });
    }

    private void urmatoareIntrebare()
    {
        PozIntrebareCurenta++;

        if ((PozIntrebareCurenta+1) == listaintrebari.size())
        {
            urmatorulBtn.setText("Termina test!");
        }
        if(PozIntrebareCurenta < listaintrebari.size())
        {
            OptiuneSelectata = "";

            opt1.setBackgroundResource(R.drawable.backgroundoptiune2);
            opt1.setTextColor(Color.parseColor("#000000"));

            opt2.setBackgroundResource(R.drawable.backgroundoptiune2);
            opt2.setTextColor(Color.parseColor("#000000"));

            opt3.setBackgroundResource(R.drawable.backgroundoptiune2);
            opt3.setTextColor(Color.parseColor("#000000"));

            opt4.setBackgroundResource(R.drawable.backgroundoptiune2);
            opt4.setTextColor(Color.parseColor("#000000"));

            intrebari.setText((PozIntrebareCurenta+1)+"/"+listaintrebari.size());
            intrebare.setText(listaintrebari.get(PozIntrebareCurenta).getIntrebare());
            opt1.setText(listaintrebari.get(PozIntrebareCurenta).getOpt1());
            opt2.setText(listaintrebari.get(PozIntrebareCurenta).getOpt2());
            opt3.setText(listaintrebari.get(PozIntrebareCurenta).getOpt3());
            opt4.setText(listaintrebari.get(PozIntrebareCurenta).getOpt4());
        }
        else
        {
            Intent intent = new Intent(Activitati.this, Rezultat.class);
            intent.putExtra("Corect!", IaRaspunsuriCorecte());
            intent.putExtra("Gresit!", IaRaspunsuriGresite());
            startActivity(intent);

            finish();

        }
    }

    private void startTimer(TextView timerTextView){
        apptimer = new Timer();
        apptimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(secunde == 0)
                {
                    TimpinMin--;
                    secunde = 59;
                }
                else if(secunde == 0 && TimpinMin == 0)
                {
                    apptimer.purge();
                    apptimer.cancel();

                    Toast.makeText(Activitati.this, "Timp terminat", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Activitati.this, Rezultat.class);
                    intent.putExtra("Corect", IaRaspunsuriCorecte());
                    intent.putExtra("Gresit", IaRaspunsuriGresite());
                    startActivity(intent);

                    finish();
                }

                else{
                    secunde--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        String minuteFinale = String.valueOf(TimpinMin);
                        String secundeFinale = String.valueOf(secunde);

                        if(minuteFinale.length() == 1)
                        {
                            minuteFinale = "0"+minuteFinale;
                        }

                        if(secundeFinale.length() == 1)
                        {
                            secundeFinale = "0"+secundeFinale;
                        }

                        timerTextView.setText(minuteFinale + ":" + secundeFinale);
                    }
                });

            }
        }, 1000, 1000);
    }

    private int IaRaspunsuriCorecte(){

        int raspunsuriCorecte = 0;

        for(int i=0;i<listaintrebari.size();i++)
        {
            final String getraspunsselectat = listaintrebari.get(i).getRaspunsSelectat();
            final String getRaspuns = listaintrebari.get(i).getRaspuns();

            if(getraspunsselectat.equals(getRaspuns))
            {
                raspunsuriCorecte++;
            }
        }

        return raspunsuriCorecte;

    }


    private int IaRaspunsuriGresite(){

        int raspunsuriGresite = 0;

        for(int i=0;i<listaintrebari.size();i++)
        {
            final String raspunsselectat = listaintrebari.get(i).getRaspunsSelectat();
            final String Raspuns = listaintrebari.get(i).getRaspuns();

            if(!raspunsselectat.equals(Raspuns))
            {
                raspunsuriGresite++;
            }
        }

        return raspunsuriGresite;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        apptimer.purge();
        apptimer.cancel();

        startActivity(new Intent(Activitati.this, MainActivity.class));
        finish();
    }

    private void RaspunsCorect()

    {
         final String getRaspunsCorect = listaintrebari.get(PozIntrebareCurenta).getRaspuns();

        if(opt1.getText().toString().equals(getRaspunsCorect))
        {
            opt1.setBackgroundResource(R.drawable.butonverde);
            opt1.setTextColor(Color.WHITE);
        }
        else if(opt2.getText().toString().equals(getRaspunsCorect))
        {
            opt2.setBackgroundResource(R.drawable.butonverde);
            opt2.setTextColor(Color.WHITE);
        }
        else if(opt3.getText().toString().equals(getRaspunsCorect))
        {
            opt3.setBackgroundResource(R.drawable.butonverde);
            opt3.setTextColor(Color.WHITE);
        }
        else if(opt4.getText().toString().equals(getRaspunsCorect))
        {
            opt4.setBackgroundResource(R.drawable.butonverde);
            opt4.setTextColor(Color.WHITE);
        }
    }
}