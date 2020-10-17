package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ActivityQuestion9 extends AppCompatActivity {

    private SeekBar seekBar;
    private ImageView img;
    private TextView txt;

    private TextView txtQuestion;

    private Button btnGauche;
    private Button btnDroit;

    private String res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);


        seekBar= findViewById(R.id.seekBar);
        img= findViewById(R.id.img);

        txt= findViewById(R.id.txt);
        txtQuestion= findViewById(R.id.txtQuestion);

        btnGauche= findViewById(R.id.btnGauche);
        btnDroit= findViewById(R.id.btnDroit);

        seekBar.setMax(100);
        seekBar.setProgress(15);
        txt.setText("Ce telereporter derriere l'ennemies pour les surprendre !");
        res="top";

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(seekBar.getProgress()>0 & seekBar.getProgress()<25){
                    img.setImageResource(R.drawable.toptp);
                    txt.setText("Ce telereporter derriere l'ennemies pour les surprendre !");
                    res="top";
                }
                if(seekBar.getProgress()>26 & seekBar.getProgress()<50){
                    img.setImageResource(R.drawable.junglergank);
                    txt.setText("Sortir de la jungle, pour tuer et y retourner");
                    res="jungle";
                }
                if(seekBar.getProgress()>51 & seekBar.getProgress()<75){
                    img.setImageResource(R.drawable.midgank);
                    txt.setText("Decendre voir ces amis a pied pour abbatre les ennemies !");
                    res="mid";
                }
                if(seekBar.getProgress()>76 & seekBar.getProgress()<100){
                    img.setImageResource(R.drawable.botgank);
                    txt.setText("A 3 on devrais etre cabable d'en venir a bout ?");
                    res="supp-adc";
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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


        Intent intent = new Intent(this, ActivityQuestion10.class);
        intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
        intent.putExtra("Q2", getIntent().getStringExtra("Q2"));
        intent.putExtra("Q3", getIntent().getStringExtra("Q3"));
        intent.putExtra("Q4", getIntent().getStringExtra("Q4"));
        intent.putExtra("Q5", getIntent().getStringExtra("Q5"));
        intent.putExtra("Q6", getIntent().getStringExtra("Q6"));
        intent.putExtra("Q7", getIntent().getStringExtra("Q7"));
        intent.putExtra("Q9",res);
        startActivity(intent);
    }

}