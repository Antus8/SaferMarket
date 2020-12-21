package com.example.asuper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SupermercatiDetails extends AppCompatActivity {

    TextView nome,indirizzo,numero_persone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermercati_details);

        nome = (TextView) findViewById(R.id.nomeSupermercato);
        indirizzo = (TextView) findViewById(R.id.indirizzosupermercato);
        numero_persone = (TextView) findViewById(R.id.TextView3);

        Intent i  = getIntent();
        String nome1 = i.getStringExtra("nome");
        String indirizzo1= i.getStringExtra("codice");
        String numero_persone1 = i.getStringExtra("codiceSupermercato");
        nome.setText("nome  :"+"\t"+nome1);
        indirizzo.setText("codice :"+"\t"+indirizzo1);
        numero_persone.setText("numeroPersone :"+ "\t"+numero_persone1);

    }
}