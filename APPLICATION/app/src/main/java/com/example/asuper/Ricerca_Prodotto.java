package com.example.asuper;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class Ricerca_Prodotto extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;

    String[] title;
    String[] desc;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricerca__prodotto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = new String[]{"BATTERY","BTERY","BRY","ERY"};
        desc = new String[]{"BATTERY detail..","BTERY detail..","BRY detail..","ERY detail.."};
        icon = new int[]{R.drawable.ic_baseline_storage_24,R.drawable.ic_baseline_storage_24,R.drawable.ic_baseline_storage_24,R.drawable.ic_baseline_storage_24};

        listView=findViewById(R.id.listview2);

                for(int i = 0 ; i<title.length;i++){
                    Model model = new Model(title[i],desc[i],icon[i]);
                    arrayList.add(model);
        }
        adapter = new ListViewAdapter(this, arrayList);
        listView.setAdapter(adapter);

    }

    @Override
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
                if(TextUtils.isEmpty(newText)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else
                {
                    adapter.filter(newText);
                }
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
