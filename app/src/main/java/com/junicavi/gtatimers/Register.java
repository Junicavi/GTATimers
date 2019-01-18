package com.junicavi.gtatimers;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Register extends AppCompatActivity {

    boolean state = false;
    String user,password,database,server;
    EditText userName, userPassword, userMail ;
    RelativeLayout relativeLayout;
    int[] images = {R.drawable.lamar, R.drawable.mc, R.drawable.girl};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        relativeLayout =  findViewById(R.id.backLayout);
        relativeLayout.setBackgroundResource(images[getRandomNumber()]);
        server = "107.180.78.125";
        database = "JunicaviPruebas";
        user = "sa";
        password = "sTG_7E1A%!*@Us";

        userName = findViewById(R.id.userField);
        userPassword = findViewById(R.id.passwordField);
        userMail = findViewById(R.id.mailField);

    }

    private int getRandomNumber() {

        return new Random().nextInt(images.length);
    }

    public void changeActivity(){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }

    public Connection connectDB(){
        Connection cn = null;
        String ConnectionURL;

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            ConnectionURL = "jdbc:jtds:sqlserver://" + server + ";databaseName=" + database + ";user=" + user + ";password=" + password + "";
            cn = DriverManager.getConnection(ConnectionURL);
        }catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return cn;
    }

    public void registerUser(View v){
        try{

            PreparedStatement pst = connectDB().prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
            //pst.setString(1,null);
            pst.setString(1, userName.getText().toString());
            pst.setString(2, userPassword.getText().toString());
            pst.setString(3, userMail.getText().toString());
            pst.setString(4, "2");
            pst.executeUpdate();
            state = true;
            Toast.makeText(getApplicationContext(), "Usuario Agregado Correctamente", Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if(state == true){
            changeActivity();
        }
    }


}


