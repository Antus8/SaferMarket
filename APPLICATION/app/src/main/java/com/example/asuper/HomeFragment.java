package com.example.asuper;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static java.lang.Thread.*;

public class HomeFragment extends Fragment {
    private Button supermercato;
    private Button prodotto,beacon;
    private static Utente utente;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);


        //supermercato = (Button) getView().findViewById(R.id.ricerca_sup);
        supermercato = (Button) view.findViewById(R.id.ricerca_sup);
        supermercato.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                
                /*
                Intent i = new Intent(getContext(), Ricerca_Supermercato.class);
                startActivity(i);*/
            }
        });

        prodotto = (Button) view.findViewById(R.id.ricerca_prod);
        beacon = (Button) view.findViewById(R.id.ricerca_beacon);
        beacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Ricerca_Beacon.class);
                startActivity(i);
            }
        });
        prodotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Ricerca_Prodotto.class);
                startActivity(i);
            }
        });
        utente = new Utente("campo@gmil.com", "Antonio", "Camposeo", "1234", "Via Tony", "Civitas", "70013");
        //return inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    // public void onRicercaSupClicked(){
    //BackgroundWorker b = new BackgroundWorker(this.getContext());
    //b.execute("supermercati");
    //   Intent i = new Intent(this.getContext(), Ricerca_Supermercato.class);
    // startActivity(i);
    // }

    public void onRicercaProdClicked(){
        Intent i = new Intent(this.getContext(), Ricerca_Prodotto.class);
        startActivity(i);
    }

    public void Entra(){
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(this.getContext(), utente.getNome() + " registrato nel Supermercato", Toast.LENGTH_LONG).show();

    }}