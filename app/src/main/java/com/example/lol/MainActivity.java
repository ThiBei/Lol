package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //start service and play music
        startService(new Intent(MainActivity.this, SoundService.class));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.btnStart);
        exitButton = findViewById(R.id.btnQuit);

        final MediaPlayer introSound = MediaPlayer.create(this, R.raw.sound1);
        final MediaPlayer introSoundEng = MediaPlayer.create(this, R.raw.welcome_eng);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Locale.getDefault().getDisplayLanguage()!="English") {
                    introSound.start();
                }
                else{
                    introSoundEng.start();
                }
                goNext();
            }
        });

        final MediaPlayer exitSound = MediaPlayer.create(this, R.raw.soundquit);
        final MediaPlayer exitSoundEng = MediaPlayer.create(this, R.raw.quit_eng);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Locale.getDefault().getDisplayLanguage()!="English"){
                    exitSound.start();
                }
                else{
                    exitSoundEng.start();
                }
                exitApp(v);
            }
        });
    }
    
    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(MainActivity.this, SoundService.class));
        super.onDestroy();
    }

    public void goNext(){
        Intent intent = new Intent(this, ActivityQuestion1.class);
        startActivity(intent);
    }

    public void exitApp(View view){
        finishAffinity();
    }
}