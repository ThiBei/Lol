package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActivityQuestion3 extends AppCompatActivity {
    private Button btnGauche;

    private ImageButton btnBundle;
    private ImageButton btnBilgewater;
    private ImageButton btnTargon;

    private ImageButton btnIonia;
    private ImageButton btnDemacia;
    private ImageButton btnNoxus;

    private ImageButton btnShurima;
    private ImageButton btnFreljord;
    private ImageButton btnPiltover;



    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);


        btnGauche= findViewById(R.id.btnGauche);
        btnBundle=findViewById(R.id.btnBundle);
        btnBilgewater=findViewById(R.id.btnBilgewater);
        btnTargon=findViewById(R.id.btnTargon);

        btnIonia=findViewById(R.id.btnIonia);
        btnDemacia=findViewById(R.id.btnDemacia);
        btnNoxus=findViewById(R.id.btnNoxus);

        btnShurima=findViewById(R.id.btnShurima);
        btnFreljord=findViewById(R.id.btnFreljord);
        btnPiltover=findViewById(R.id.btnPiltover);


        final MediaPlayer back = MediaPlayer.create(this, R.raw.champ_respawn);

        btnGauche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.start();
                goBack();
            }
        });

        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("bandle");
            }
        });
        btnBilgewater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("bilgewater");
            }
        });
        btnTargon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("targon");
            }
        });

        btnIonia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("ionia");
            }
        });
        btnDemacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("demacia");
            }
        });
        btnNoxus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("noxus");
            }
        });

        btnShurima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("shurima");
            }
        });
        btnFreljord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("freljord");
            }
        });
        btnPiltover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext("piltover");
            }
        });

    }

    public void goBack(){
        this.finish();
    }

    public void goNext(String btnName){

        final MediaPlayer go = MediaPlayer.create(this, R.raw.ping_omw);
        go.start();
        Toast toast = Toast.makeText(getApplicationContext(), btnName,Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, ActivityQuestion4.class);
        intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
        intent.putExtra("Q2",  getIntent().getStringExtra("Q2"));
        intent.putExtra("Q3", btnName);


        startActivity(intent);
    }


}

