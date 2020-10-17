package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityQuestion5 extends AppCompatActivity {

    //RecyclerAdapter recyclerAdapter;
    private RadioButton rbtn1;
    private RadioButton rbtn2;
    private RadioButton rbtn3;
    private RadioButton rbtn4;

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;

    private Button btnGauche;
    private Button btnDroit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        rbtn1 = findViewById(R.id.rbtn1);
        rbtn1.setChecked(true);
        rbtn2 = findViewById(R.id.rbtn2);
        rbtn3 = findViewById(R.id.rbtn3);
        rbtn4 = findViewById(R.id.rbtn4);
        btnGauche= findViewById(R.id.btnGauche);
        btnDroit= findViewById(R.id.btnDroit);

        img1= findViewById(R.id.img1);
        img2= findViewById(R.id.img2);
        img3= findViewById(R.id.img3);
        img4= findViewById(R.id.img4);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtn1.setChecked(true);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtn2.setChecked(true);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtn3.setChecked(true);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtn4.setChecked(true);
            }
        });

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

        /*
        feu
        bouclier
        arc
        epee
         */
        String var = "";
        if(rbtn1.isChecked()){
            var="mid";
        }else if(rbtn2.isChecked()){
            var="supp";
        }else if(rbtn3.isChecked()){
            var="adc";
        }else if(rbtn4.isChecked()){
            var="top-jungle";
        }

        Toast toast = Toast.makeText(getApplicationContext(), var,Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, ActivityQuestion6.class);
        intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
        intent.putExtra("Q2", getIntent().getStringExtra("Q2"));
        intent.putExtra("Q3", getIntent().getStringExtra("Q3"));
        intent.putExtra("Q4", getIntent().getStringExtra("Q4"));
        intent.putExtra("Q5", var);
        startActivity(intent);
    }
}