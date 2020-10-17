package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.Locale;

public class ActivityQuestion8 extends AppCompatActivity {

    private Button btnGauche;
    private Button btnDroit;

    private RatingBar rDemacia;
    private RatingBar rFreljord;
    private RatingBar rNoxus;
    private RatingBar rPiltover;
    private RatingBar rBandle;
    private RatingBar rIonia;
    private RatingBar rTargon;
    private RatingBar rBilgewater;
    private RatingBar rShurima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question8);

        btnGauche= findViewById(R.id.btnGauche);
        btnDroit= findViewById(R.id.btnDroit);

        rDemacia= findViewById(R.id.demaciaRating);
        rFreljord= findViewById(R.id.freljordRanking);
        rNoxus= findViewById(R.id.noxusRating);
        rPiltover= findViewById(R.id.piltoverRanking);
        rBandle= findViewById(R.id.bandleRating);
        rIonia= findViewById(R.id.ioniaRating);
        rTargon= findViewById(R.id.targonRating);
        rBilgewater= findViewById(R.id.bilgewaterRating);
        rShurima= findViewById(R.id.shurimaRating);

        final MediaPlayer go = MediaPlayer.create(this, R.raw.ping_omw);
        final MediaPlayer back = MediaPlayer.create(this, R.raw.champ_respawn);

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

    public void calcultate(){
        rDemacia.getRating();


    }
    public void goBack(){
        this.finish();
    }

    public void goNext(){

        //String var = ;
        //TODO

        //Toast toast = Toast.makeText(getApplicationContext(), var,Toast.LENGTH_SHORT);
        //toast.show();

        Intent intent = new Intent(this, ActivityResultat.class);
        intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
        intent.putExtra("Q2", getIntent().getStringExtra("Q2"));
        intent.putExtra("Q3", getIntent().getStringExtra("Q3"));
        intent.putExtra("Q4", getIntent().getStringExtra("Q4"));
        intent.putExtra("Q5", getIntent().getStringExtra("Q5"));
        intent.putExtra("Q6", getIntent().getStringExtra("Q6"));
        intent.putExtra("Q7", getIntent().getStringExtra("Q7"));
        intent.putExtra("Q8","TODO");
        startActivity(intent);
    }
}