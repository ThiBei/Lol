package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class ActivityQuestion10 extends AppCompatActivity {


    private Button btnGauche;
    private Button btnDroit;

    private Switch switch1;
    private Switch switch2;
    private Switch switch3;
    private Switch switch4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);

        btnGauche= findViewById(R.id.btnGauche);
        btnDroit= findViewById(R.id.btnDroit);

        switch1= findViewById(R.id.switch1);
        switch2= findViewById(R.id.switch2);
        switch3= findViewById(R.id.switch3);
        switch4= findViewById(R.id.switch4);


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
        intent.putExtra("Q9",getIntent().getStringExtra("Q9"));
        startActivity(intent);
    }



}