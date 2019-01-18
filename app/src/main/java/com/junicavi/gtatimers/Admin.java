package com.junicavi.gtatimers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Random;

public class Admin extends AppCompatActivity {

    RelativeLayout relativeLayout;
    int[] images = {
            R.drawable.as_1,
            R.drawable.as_2,
            R.drawable.as_3,
            R.drawable.as_4,
            R.drawable.as_5,
            R.drawable.as_6,
            R.drawable.as_7};

    String currentPromo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        currentPromo = getIntent().getStringExtra("promo");
        relativeLayout =  findViewById(R.id.backLayout);
        relativeLayout.setBackgroundResource(images[getRandomNumber()]);

    }

    public void settingsActivity (View v){
      /*  Intent i = new Intent(this, Settings.class);
        startActivity(i);
        finish();*/
    }

    public void mainActivity (View v){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("promo",currentPromo );
        startActivity(i);
    }

    private int getRandomNumber() {

        return new Random().nextInt(images.length);
    }

}
