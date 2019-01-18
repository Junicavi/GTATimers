package com.junicavi.gtatimers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class Login extends AppCompatActivity {
    // Declaring layout button, edit texts
    Button login;
    EditText username,password;
    ProgressBar progressBar;
    // End Declaring layout button, edit texts
    Boolean state = false;
    Boolean ended = false;
    // Declaring connection variables
    Connection con;
    String un,pass,db,ip;
    String promo;
    int rolType;
    //End Declaring connection variables



    RelativeLayout relativeLayout;
    int[] images = {R.drawable.franklin, R.drawable.michael, R.drawable.trevor};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        relativeLayout =  findViewById(R.id.backLayout);
        relativeLayout.setBackgroundResource(images[getRandomNumber()]);
        // Getting values from button, texts and progress bar
        login = (Button) findViewById(R.id.loginButton);
        username = (EditText) findViewById(R.id.userField);
        password = (EditText) findViewById(R.id.passwordField);
        progressBar = (ProgressBar) findViewById(R.id.progressbar1);
        // End Getting values from button, texts and progress bar

        // Declaring Server ip, username, database name and password
        ip = "107.180.78.125";
        db = "JunicaviPruebas";
        un = "sa";
        pass = "sTG_7E1A%!*@Us";
        // Declaring Server ip, username, database name and password

        // Setting up the function when button login is clicked
        /*login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CheckLogin checkLogin = new CheckLogin();// this is the Asynctask, which is used to process in background to reduce load on app process
                checkLogin.execute("");
            }
        });*/
        //End Setting up the function when button login is clicked
    }

    public void changeActivity(){
        Intent i1 = new Intent(this, MainActivity.class);
        Intent i2= new Intent(this, Admin.class);
        if(rolType == 1){
            i2.putExtra("promo", promo);
            startActivity(i2);
        }
        else{
            i1.putExtra("promo", promo);
            startActivity(i1);
        }
        finish();
    }

    public void RegisterForm(View v){
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    public void startLogin (View v){
        String usernam = username.getText().toString();
        String passwordd = password.getText().toString();
        CheckLogin checkLogin = new CheckLogin();// this is the Asynctask, which is used to process in background to reduce load on app process
        checkLogin.execute(usernam, passwordd);
    }

    private int getRandomNumber() {

        return new Random().nextInt(images.length);
    }

    public class CheckLogin extends AsyncTask<String,String,String>
    {
        String z = "";
        Boolean isSuccess = false;


        @Override
        protected void onPreExecute()
        {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r)
        {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(Login.this, r, Toast.LENGTH_SHORT).show();
            if(isSuccess)
            {
                Toast.makeText(Login.this , "Acceso Correcto. Bienvenido "+ username.getText().toString() , Toast.LENGTH_LONG).show();
                //finish();
            }
        }
        @Override
        protected String doInBackground(String... params)
        {
            String usernam = params[0], passwordd = params[1];

            if(usernam.trim().equals("")|| passwordd.trim().equals(""))
                z = "Por favor ingrese su usuario y contraseña";
            else
            {
                try
                {
                    con = connectionclass(un, pass, db, ip);        // Connect to database
                    if (con == null)
                    {
                        z = "Verifique su conexión a internet";
                    }
                    else
                    {
                        // Change below query according to your own database.
                        String query = "select * from users where username= '" + usernam + "' and password = '"+ passwordd +"'  ";
                        String query2 = "select * from promo where ID = 1";
                        Statement stmt = con.createStatement();
                        Statement stmt2 = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        ResultSet rs2 = stmt2.executeQuery(query2);
                        if(rs.next())
                        {
                            z = "Acceso Correcto. Bienvenido "+usernam;
                            isSuccess=true;
                            state = true;
                            rolType = rs.getInt("rol_id");
                            if(rs2.next()){
                                promo = rs2.getString("description");
                            }
                            con.close();
                        }
                        else
                        {
                            z = "Datos Incorrectos";
                            isSuccess = false;
                        }
                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = ex.getMessage();
                }
            }
            if(state == true){
                changeActivity();
            }
            return z;
        }
    }



    @SuppressLint("NewApi")
    public Connection connectionclass(String user, String password, String database, String server)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://"+server+";databaseName="+database+";user="+user+";password="+password+"";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }


}





