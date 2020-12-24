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

public class Ricerca_Supermercato extends AppCompatActivity  {
    private ExampleAdapterSupermercato adapter; //oggetto adapeter per settare la -reclycer vire
    private List<Supermarket> exampleList; // lista dei supermercati
    public static ArrayList<Supermarket> supermarkets = new ArrayList<Supermarket>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricerca__supermercato);
        fillExampleList(); // richiama classe per la creazione della lista
        setUpRecyclerView();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        System.out.println("--------------------------------------"+supermarkets.get(0).getCivico());
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new Supermarket("1111","SUPER MARKET 1"," VIA SAN GIACOMO 2","1","1222",3));
        exampleList.add(new Supermarket("222","SUPER MARKET 2"," VIA SAN GIACOMO 3","3","1222",10));
        exampleList.add(new Supermarket("1232","SUPER MARKET 3"," VIA SAN GIACOMO 1","52","1222",9));
        exampleList.add(new Supermarket("1322","SUPER MARKET 4"," VIA  GIACOMO ","32","1222",10));

    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapterSupermercato(exampleList);

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
