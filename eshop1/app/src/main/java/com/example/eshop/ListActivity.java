package com.example.eshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private WS _server;
    private ArrayList<HashMap<String, String>> _listProducts;
    private ListView _lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Aguarde...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent data = new Intent(ListActivity.this, MainActivity.class);
                startActivity(data);
            }
        });

        _server = new WS();
        _server.activity = ListActivity.this;
        _server._listProducts = new ArrayList<>();
        _server._lv = findViewById(R.id.lv_products);
        _server.execute();
    }
}
