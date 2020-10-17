package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
//doit devenir Activité 1
public class ActivityQuestion4 extends AppCompatActivity {

    private TextView textView;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private Button btnGauche;
    private Button btnDroit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);


        textView= findViewById(R.id.textView);

        checkBox1= findViewById(R.id.checkBox1);
        checkBox2= findViewById(R.id.checkBox2);
        checkBox3= findViewById(R.id.checkBox3);
        checkBox4= findViewById(R.id.checkBox4);

        btnGauche= findViewById(R.id.btnGauche);
        btnDroit= findViewById(R.id.btnDroit);

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
        String res="";

        if(checkBox1.isChecked()){
            res=res+"ionia-piltover-jungle-";
        }
        if(checkBox2.isChecked()){
            res=res+"targon-bilgewater-freljord-top-support-";
        }
        if(checkBox3.isChecked()){
            res=res+"demacia-shurima-noxus-mid-";
        }
        if(checkBox4.isChecked()){
            res=res+"bandle-adc-";
        }


        if(!res.equals("")) {
            Intent intent = new Intent(this, ActivityQuestion5.class);
            intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
            intent.putExtra("Q2", getIntent().getStringExtra("Q2"));
            intent.putExtra("Q3", getIntent().getStringExtra("Q3"));
            intent.putExtra("Q4", res);
            Toast toasti = Toast.makeText(getApplicationContext(), res,Toast.LENGTH_SHORT);
            toasti.show();
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "CHOIX MANQUANT",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}