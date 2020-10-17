package com.example.lol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityQuestion2 extends AppCompatActivity {

    private RadioButton rbtn1;
    private RadioButton rbtn2;
    private RadioButton rbtn3;
    private RadioButton rbtn4;

    private Button btnGauche;
    private Button btnDroit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        rbtn1 = findViewById(R.id.rbtn1);
        rbtn1.setChecked(true);
        rbtn2 = findViewById(R.id.rbtn2);
        rbtn3 = findViewById(R.id.rbtn3);
        rbtn4 = findViewById(R.id.rbtn4);
        btnGauche= findViewById(R.id.btnGauche);
        btnDroit= findViewById(R.id.btnDroit);

        rbtn1.setSelected(true);

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
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // outState.putString("namePokemon","txtSearch.getText().toString()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    public void goBack(){
        this.finish();
    }

    public void goNext() {
        if (rbtn1.isChecked() || rbtn2.isChecked() || rbtn3.isChecked() || rbtn4.isChecked()){
            /*
            seul
            animaux
            plus on est de fou
            j'alterne
             */
                String var = null;
            if (rbtn1.isChecked()) {
                var = "top-freljord-targon";
            } else if (rbtn2.isChecked()) {
                var = "jungle-bandle-ionia";
            } else if (rbtn3.isChecked()) {
                var = "adc-supp-ionia-shurima";
            } else if (rbtn4.isChecked()) {
                var = "mid-demacia-noxus";
            }
            Toast toast = Toast.makeText(getApplicationContext(), var, Toast.LENGTH_SHORT);
            toast.show();

            Intent intent = new Intent(this, ActivityQuestion3.class);
            intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
            intent.putExtra("Q2", var);

            startActivity(intent);
        }
    }

}