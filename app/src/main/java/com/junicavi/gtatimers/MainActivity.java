package com.junicavi.gtatimers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
