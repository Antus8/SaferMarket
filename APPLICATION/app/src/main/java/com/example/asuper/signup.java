package com.example.asuper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private static EditText nome;
    private static EditText cognome;
    public static EditText email;
    public static EditText password;
    private static EditText indirizzo;
    private Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nome = (EditText) findViewById(R.id.nome);
        cognome = (EditText) findViewById(R.id.cognome);
        email = (EditText) findViewById(R.id.email_reg);
        password = (EditText) findViewById(R.id.password_reg);
        indirizzo = (EditText) findViewById(R.id.indirizzo);
        reg = (Button) findViewById(R.id.register);
    }

    public void registrati(View view){
        String n = nome.getText().toString();
        String c = cognome.getText().toString();
        String e = email.getText().toString();
        String p = password.getText().toString();
        String i = indirizzo.getText().toString();

        if(!n.equals("")){
            if(!c.equals("")){
                if(!e.equals("")){
                    if(!p.equals("")){
                        if(!i.equals("")) {
                            String result = "";
                            //BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                            //backgroundWorker.execute("registrazione", n, c, e, p, i);
                            Toast.makeText(this, "Registrazione effettuata con successo!", Toast.LENGTH_LONG);
                            Intent in = new Intent(this, login.class);
                            startActivity(in);
                        } else Toast.makeText(this, "Inserire indirizzo!", Toast.LENGTH_LONG).show();
                    } else Toast.makeText(this, "Inserire password!", Toast.LENGTH_LONG).show();
                } else Toast.makeText(this, "Inserire email!", Toast.LENGTH_LONG).show();
            } else Toast.makeText(this, "Inserire cognome!", Toast.LENGTH_LONG).show();
        } else Toast.makeText(this, "Inserire nome!", Toast.LENGTH_LONG).show();
    }
}
