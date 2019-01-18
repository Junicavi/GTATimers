package com.junicavi.gtatimers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.Random;

public class First_b extends AppCompatActivity {

    RelativeLayout relativeLayout;
    int[] images = {
            R.drawable.ss_1,
            R.drawable.ss_2,
            R.drawable.ss_3,
            R.drawable.ss_4,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_b);
        relativeLayout =  findViewById(R.id.backLayout);
        relativeLayout.setBackgroundResource(images[getRandomNumber()]);
    }

    private int getRandomNumber() {

        return new Random().nextInt(images.length);
    }

}
