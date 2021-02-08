package com.example.listviewfilteringandsearchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] countryNames;
    private ListView listView;
    ArrayAdapter<String> adapter;

    private SearchView searchView;//searchview k khuje neyar jonno variable nilam

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_names);
        listView = findViewById(R.id.lstviewId);
        searchView = findViewById(R.id.srchviewId);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {//searchview dara kono item khuje anar jonno
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);//amra j string likhbo se string jabe newText a ..then filter hobe r exact item search hye jabe
                return false;

            }
        });

         adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sample_view, R.id.txtviewId, countryNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);

                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }


}