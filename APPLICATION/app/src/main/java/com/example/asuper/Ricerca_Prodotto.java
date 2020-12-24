package com.example.asuper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Ricerca_Prodotto extends AppCompatActivity  {
    private ExampleAdapter adapter;
    private List<Prodotto> exampleList;
    public static ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricerca__prodotto);
        fillExampleList();
        setUpRecyclerView();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        System.out.println("--------------------------------------"+prodotti.get(0).getNome());
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new Prodotto("1223","1111","mela") );
        exampleList.add(new Prodotto("1223","3333","sushi") );
        exampleList.add(new Prodotto("1223","4444","caffè") );
        exampleList.add(new Prodotto("1223","55555","banana") );
        exampleList.add(new Prodotto("1223","13333","pera") );

    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(prodotti);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search);

        android.widget.SearchView searchView= (android.widget.SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search) {

            return true;

        }


        return super.onOptionsItemSelected(item);
    }


}