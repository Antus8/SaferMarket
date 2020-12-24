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
                BackgroundWorker b = new BackgroundWorker(getContext());
                b.execute("supermercati");
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
                BackgroundWorker b = new BackgroundWorker(getContext());
                b.execute("prodotto");
            }
        });
        return view;
    }
    }