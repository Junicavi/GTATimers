package com.junicavi.gtatimers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    int[] images = {
            R.drawable.mm_1,
            R.drawable.mm_2,
            R.drawable.mm_3,
            R.drawable.mm_4,
            R.drawable.mm_5,
            R.drawable.mm_6,
            R.drawable.mm_7,
            R.drawable.mm_7,
            R.drawable.mm_9,
            R.drawable.mm_10,
            R.drawable.mm_11,
            R.drawable.mm_12,
            R.drawable.mm_13,
            R.drawable.mm_14,
            R.drawable.mm_15,
            R.drawable.mm_16,
            R.drawable.mm_17,
            R.drawable.mm_18,
            R.drawable.mm_19,
            R.drawable.mm_20,
            R.drawable.mm_21,
            R.drawable.mm_22,
            R.drawable.mm_23,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String currentPromo = getIntent().getStringExtra("promo");
        relativeLayout =  findViewById(R.id.backLayout);
        relativeLayout.setBackgroundResource(images[getRandomNumber()]);
        final Animation splashAnimation = AnimationUtils.loadAnimation(this, R.anim.splashtransition);

        final Handler handler = new Handler();
        final int delay = 7000; //milliseconds

        handler.postDelayed(new Runnable(){
            public void run(){
                //do something
                //relativeLayout.startAnimation(splashAnimation);
                relativeLayout.setBackgroundResource(images[getRandomNumber()]);

                handler.postDelayed(this, delay);
            }
        }, delay);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(currentPromo)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private int getRandomNumber() {

        return new Random().nextInt(images.length);
    }



    public void securoServ(View view)
    {
        Intent intent = new Intent(MainActivity.this, First_b.class);
        startActivity(intent);

    }
    public void bikers(View view)
    {
        Intent intent = new Intent(MainActivity.this, Second_b.class);
        startActivity(intent);

    }
    public void gunrunning(View view)
    {
        Intent intent = new Intent(MainActivity.this, Third_b.class);
        startActivity(intent);

    }
    public void smugglers(View view)
    {
        Intent intent = new Intent(MainActivity.this, Fourth_b.class);
        startActivity(intent);

    }
    public void afterhours(View view)
    {
        Intent intent = new Intent(MainActivity.this, Fifth_b.class);
        startActivity(intent);

    }
}
