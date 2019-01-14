package com.junicavi.gtatimers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.Random;

public class Register extends AppCompatActivity {

    RelativeLayout relativeLayout;
    int[] images = {R.drawable.lamar, R.drawable.mc, R.drawable.girl};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        relativeLayout =  findViewById(R.id.backLayout);
        relativeLayout.setBackgroundResource(images[getRandomNumber()]);
    }

    private int getRandomNumber() {

        return new Random().nextInt(images.length);
    }
}
