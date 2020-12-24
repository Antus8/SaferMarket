package com.example.asuper;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private Button supermercato;
    private Button prodotto;
    private static Utente utente;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        supermercato = (Button) view.findViewById(R.id.ricerca_sup);
        prodotto = (Button) view.findViewById(R.id.ricerca_prod);
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    public void onRicercaSupClicked(){
        BackgroundWorker b = new BackgroundWorker(this.getContext());
        b.execute("supermercati");
    }

    public void onRicercaProdClicked(){

    }
}
