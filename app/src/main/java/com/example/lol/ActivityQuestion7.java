package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class ActivityQuestion7 extends AppCompatActivity {

    private Button btnGauche;
    private Button btnDroit;
    private ImageView kledView;
    private ImageView heimerView;
    private ImageView garenView;
    private ImageView akaliView;
    private ImageView aniviaView;
    private String choix = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);

        btnGauche= findViewById(R.id.btnGauche);
        btnDroit= findViewById(R.id.btnDroit);
        kledView=findViewById(R.id.imageViewKled);
        heimerView=findViewById(R.id.imageViewHeimer);
        garenView=findViewById(R.id.imageViewGaren);
        akaliView=findViewById(R.id.imageViewAkali);
        aniviaView=findViewById(R.id.imageViewAnivia);

        final MediaPlayer go = MediaPlayer.create(this, R.raw.ping_omw);
        final MediaPlayer back = MediaPlayer.create(this, R.raw.champ_respawn);

        final MediaPlayer kledSound = MediaPlayer.create(this, R.raw.joke_kled_fr);
        final MediaPlayer heimerSound = MediaPlayer.create(this, R.raw.joke_heimer_fr);
        final MediaPlayer garenSound = MediaPlayer.create(this, R.raw.joke_garen_fr);
        final MediaPlayer akaliSound = MediaPlayer.create(this, R.raw.joke_aka_fr);
        final MediaPlayer aniviaSound = MediaPlayer.create(this, R.raw.joke_anivia_fr);
        final MediaPlayer kledSoundEng = MediaPlayer.create(this, R.raw.joke_kled_eng);
        final MediaPlayer heimerSoundEng = MediaPlayer.create(this, R.raw.joke_heimer_eng);
        final MediaPlayer garenSoundEng = MediaPlayer.create(this, R.raw.joke_garen_eng);
        final MediaPlayer akaliSoundEng = MediaPlayer.create(this, R.raw.joke_aka_eng);
        final MediaPlayer aniviaSoundEng = MediaPlayer.create(this, R.raw.joke_anivia_eng);



        kledView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Locale.getDefault().getDisplayLanguage()!="English"){
                    kledSound.start();
                }
                else {
                    kledSoundEng.start();
                }
                saveChoix("noxus-bandle-bilgewater-jungle");
            }
        });

        heimerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Locale.getDefault().getDisplayLanguage()!="English"){
                    heimerSound.start();
                }
                else {
                    heimerSoundEng.start();
                }
                saveChoix("piltover-adc");
            }
        });

        garenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Locale.getDefault().getDisplayLanguage()!="English"){
                    garenSound.start();
                }
                else {
                    garenSoundEng.start();
                }
                saveChoix("demacia-shurima-top");
            }
        });

        akaliView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Locale.getDefault().getDisplayLanguage()!="English"){
                    akaliSound.start();
                }
                else {
                    akaliSoundEng.start();
                }
                saveChoix("ionia-targon-mid");
            }
        });

        aniviaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Locale.getDefault().getDisplayLanguage()!="English"){
                    aniviaSound.start();
                }
                else {
                    aniviaSoundEng.start();
                }
                saveChoix("freljord-support");
            }
        });

        btnGauche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.start();
                goBack();
            }
        });

        btnDroit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go.start();
                goNext();
            }
        });
    }

    public void goBack(){
        this.finish();
    }

    public void saveChoix(String newChoix){
        this.choix=newChoix;
    }

    public void goNext(){

        String var = choix;

        Toast toast = Toast.makeText(getApplicationContext(), var,Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, ActivityQuestion8.class);
        intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
        intent.putExtra("Q2", getIntent().getStringExtra("Q2"));
        intent.putExtra("Q3", getIntent().getStringExtra("Q3"));
        intent.putExtra("Q4", getIntent().getStringExtra("Q4"));
        intent.putExtra("Q5", getIntent().getStringExtra("Q5"));
        intent.putExtra("Q6", getIntent().getStringExtra("Q6"));
        intent.putExtra("Q7", var);
        startActivity(intent);
    }
}