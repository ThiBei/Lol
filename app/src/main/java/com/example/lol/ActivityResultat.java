package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class ActivityResultat extends AppCompatActivity {


    private TextView textView;
    private Button btnSend;
    private TextView txtMail;
    private ImageView imgChampion;
    private Button btnSkip;


    int top=0;
    int jungle=0;
    int mid=0;
    int adc=0;
    int supp=0;

    int bandle=0;
    int bilgwater=0;
    int targon=0;
    int ionia=0;
    int demacia=0;
    int noxus=0;
    int shurima=0;
    int freljord=0;
    int piltover=0;


    int error=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        textView = findViewById(R.id.textView);
        txtMail = findViewById(R.id.txtMail);
        imgChampion = findViewById(R.id.imgChampion);
        imgChampion.setImageResource(R.drawable.lol_leona_splash_hd);

        textView.setText(calculResulat());
        btnSkip= findViewById(R.id.btnSkip);


        final MediaPlayer go = MediaPlayer.create(this, R.raw.ping_omw);
        final MediaPlayer back = MediaPlayer.create(this, R.raw.champ_respawn);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtMail.getText().toString().equals(""))
                    back.start();
                    sendMail();
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go.start();
                Intent intent = new Intent(getApplicationContext(), ActivityEnd.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }


    private String calculResulat() {

        String resQ1 = getIntent().getStringExtra("Q1");//ce définire
        String[] partsQ1 = resQ1.split("-");
        for (String uneValeur : partsQ1) {
            asignePoint(uneValeur);
        }

        String resQ2 = getIntent().getStringExtra("Q2");//Comment vivre
        String[] partsQ2 = resQ2.split("-");
        for (String uneValeur : partsQ2) {
            asignePoint(uneValeur);
        }

        String resQ3 = getIntent().getStringExtra("Q3");// Quelle région
        String[] partsQ3 = resQ3.split("-");
        for (String uneValeur : partsQ3) {
            asignePoint(uneValeur);
        }

        String resQ4 = getIntent().getStringExtra("Q4");//lors d'un comabt (multi Choice)
        String[] partsQ4 = resQ4.split("-");
        for (String uneValeur : partsQ4) {
            asignePoint(uneValeur);
        }

        String resQ5 = getIntent().getStringExtra("Q5");//arme
        String[] partsQ5 = resQ5.split("-");
        for (String uneValeur : partsQ5) {
            asignePoint(uneValeur);
        }

        String resQ6 = getIntent().getStringExtra("Q6");//comboBox


        String resQ9 = getIntent().getStringExtra("Q9");//la start qui te conviens
        String[] partsQ9 = resQ9.split("-");
        for (String uneValeur : partsQ9) {
            asignePoint(uneValeur);
        }


        HashMap<String, Integer> allPoste = new HashMap<String, Integer>();
        allPoste.put("top", top);
        allPoste.put("jungle", jungle);
        allPoste.put("mid", mid);
        allPoste.put("adc", adc);
        allPoste.put("supp", supp);

        Map.Entry<String, Integer> maxEntryPost = null;
        for (Map.Entry<String, Integer> entry : allPoste.entrySet()) {
            if (maxEntryPost == null || entry.getValue().compareTo(maxEntryPost.getValue()) > 0) {
                maxEntryPost = entry;
            }
        }

        HashMap<String, Integer> allRegions = new HashMap<String, Integer>();
        allRegions.put("bandle", bandle);
        allRegions.put("bilgwater", bilgwater);
        allRegions.put("targon", targon);
        allRegions.put("ionia", ionia);
        allRegions.put("demacia", demacia);
        allRegions.put("noxus", noxus);
        allRegions.put("shurima", shurima);
        allRegions.put("freljord", freljord);
        allRegions.put("piltover", piltover);

        Map.Entry<String, Integer> maxEntryRegion = null;
        for (Map.Entry<String, Integer> entry : allRegions.entrySet()) {
            if (maxEntryRegion == null || entry.getValue().compareTo(maxEntryRegion.getValue()) > 0) {
                maxEntryRegion = entry;
            }
        }

        if (maxEntryRegion.getKey().equals("bundle")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.teemo);
                return "Teemo !";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.tristana);
                return "Tristana";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.veigar);
                return "Veigar !";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.tristana);
                return "Tristana !";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.lulu);
                return "Lulu !";
            }
        } else if (maxEntryRegion.getKey().equals("bilgwater")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.illaoo);
                return "Illaoi";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.graves);
                return "Graves";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.fizz);
                return "Fizz";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.missfortune);
                return "Miss Fortune";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.pyke);
                return "Pyke";
            }
        } else if (maxEntryRegion.getKey().equals("targon")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.penthon);
                return "Pantheon";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.diana);
                return "Diana";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.aurelion);
                return "Aurelion Sol";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.aphelios);
                return "Aphelios";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.lol_leona_splash_hd);
                return "Leona";
            }
        } else if (maxEntryRegion.getKey().equals("ionia")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.irelia);
                return "Irelia";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.lee_sin);
                return "Lee Sin";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.ahri);
                return "Ahri";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.splash_art_rakan);
                return "Xayah";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.splash_art_rakan);
                return "Rakan";
            }
        } else if (maxEntryRegion.getKey().equals("demacia")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.garen);
                return "Garen";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.jarvan);
                return "Jarvan";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.lux_splash_0);
                return "Lux";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.lucian);
                return "Lucian";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.morgana);
                return "Morgana";
            }
        } else if (maxEntryRegion.getKey().equals("noxus")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.spash_darius);
                return "Darius";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.cassio);
                return "Cassiopea";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.katarina);
                return "Katarina";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.spash_draven);
                return "Draven";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.swain);
                return "Swain";
            }
        } else if (maxEntryRegion.getKey().equals("shurima")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.nasus);
                return "Nasus";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.rammus);
                return "Rammus";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.spash_azir);
                return "Azir";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.sivir);
                return "Sivir";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.xerath);
                return "Xerath";
            }
        } else if (maxEntryRegion.getKey().equals("freljord")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.volibear);
                return "Volibear";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.sejuani);
                return "Sejuani";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.lissandra);
                return "Lissandra";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.ashe);
                return "Ashe";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.braum);
                return "Braum";
            }
        } else   {//piltover
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.camille);
                return "Camille";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.vi);
                return "Vi";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.orianna);
                return "Oriana";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.jinx);
                return "Jinx";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.blitzcrank);
                return "Blitzkrank";
            }
        }

        return "gg";
        //return "top "+Integer.toString(top)+"\njugnle "+Integer.toString(jungle)+"\nmid "+Integer.toString(mid)+"\nadc "+Integer.toString(adc)+"\nsupp "+Integer.toString(supp)+"\nerror "+Integer.toString(error);
    }

    private void asignePoint(String val){
        if(val.equals("top")){
            top+=1;
        }else if(val.equals("jungle")){
            jungle+=1;
        }else if(val.equals("mid")){
            mid+=1;
        }else if(val.equals("adc")){
            adc+=1;
        }else if(val.equals("supp")){
            supp+=1;
        }else if(val.equals("bandle")){
            bandle+=1;
        }else if(val.equals("bilgwater")){
            bilgwater+=1;
        }else if(val.equals("targon")){
            targon+=1;
        }else if(val.equals("ionia")){
            ionia+=1;
        }else if(val.equals("demacia")){
            demacia+=1;
        }else if(val.equals("noxus")){
            noxus+=1;
        }else if(val.equals("shurima")){
            shurima+=1;
        }else if(val.equals("freljord")){
            freljord+=1;
        }else if(val.equals("piltover")) { //dernier cas possible
            piltover+=1;
        }else{
            error+=1;
        }

    }

    private void sendMail(){
        String mMail = txtMail.getText().toString();
        String mSubject = "Résultat du questionnaire de League of Legends !";
        String mMessage = " tu es super !";

        JavaMainAPI javaMainAPI = new JavaMainAPI(this,mMail,mSubject,mMessage);
        javaMainAPI.execute();

        Intent intent = new Intent(this, ActivityEnd.class);
        startActivity(intent);

       /* Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{mail});
        i.putExtra(Intent.EXTRA_SUBJECT, "Results");//objet
        i.putExtra(Intent.EXTRA_TEXT   , "Voici les résultats de votre GPHY test :\n\n" +"blabla");//corps
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }*/
    }

    private void  goMain(){
        Intent intent = new Intent(getApplicationContext(), ActivityEnd.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}