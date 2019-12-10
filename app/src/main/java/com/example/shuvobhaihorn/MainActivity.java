package com.example.shuvobhaihorn;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton;
    GifImageView animationGif;
    private MediaPlayer mediaPlayer;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
        animationGif=findViewById(R.id.animationGif);

        imageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    //myMusic.seekTo(3);
                    animationGif.setVisibility(View.VISIBLE);
                    animationGif.getDisplay();

                    i++;

                    if (i == 1) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.closer);
                        mediaPlayer.start();
                        /*animationGif.setVisibility(View.VISIBLE);
                        animationGif.getDisplay();*/

                        Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                    } else if (i == 2) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.numb);
                        mediaPlayer.start();



                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();

                    } else {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.iphone11_pro);
                        mediaPlayer.start();

                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                        i = 0;

                    }

                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);

                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    animationGif.setVisibility(View.INVISIBLE);
                    animationGif.getDisplay();


                    mediaPlayer.pause();

                }

                return true;

            }
        });
    }
}
