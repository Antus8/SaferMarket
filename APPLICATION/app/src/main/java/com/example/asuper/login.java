package com.example.asuper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.lang.Thread.sleep;

public class login extends AppCompatActivity {
    private Button b;
    private EditText email;
    private EditText password;
    private TextView registrazione;
    private BackgroundWorker backgroundWorker;
    public boolean set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        registrazione = (TextView) findViewById(R.id.registrazione);
        Button b = findViewById(R.id.login);
        backgroundWorker = new BackgroundWorker(this);
    }

    public void apriRegistrazione(View view){
        Intent i = new Intent(login.this, signup.class);
        startActivity(i);
    }

    public void onLogin(View view){
        String user_email = email.getText().toString();
        String user_pw = password.getText().toString();
        String result = "";
        if(!user_email.equals("") && !user_pw.equals("") && user_email != null && user_pw != null){
            //backgroundWorker.execute("login", user_email, user_pw);
            Intent i = new Intent(this, HomeFragment.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Inserire correttamente email o password!", Toast.LENGTH_LONG).show();
        }
    }
}