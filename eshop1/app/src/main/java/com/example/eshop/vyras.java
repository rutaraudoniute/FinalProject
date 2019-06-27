package com.example.eshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vyras extends AppCompatActivity {

    Button nextv, v1, v2, v3, m1, m2, m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vyras);

        nextv =findViewById(R.id.next2v);
        v1 = findViewById(R.id.foto1v);
        v2 = findViewById(R.id.foto2v);
        v3 = findViewById(R.id.foto3v);
        m1 = findViewById(R.id.buy1v);
        m2 = findViewById(R.id.buy2v);
        m3 = findViewById(R.id.buy3v);

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vyras.this, vyrs3.class);
                startActivity(intent);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vyras.this, vyrs2.class);
                startActivity(intent);
            }
        });


        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vyras.this, vyrs1.class);
                startActivity(intent);
            }
        });

        nextv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vyras.this, vyras2.class);
                startActivity(intent);
            }
        });

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vyras.this, vyrs1.class);
                startActivity(intent);
            }
        });

        nextv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vyras.this, vyrs2.class);
                startActivity(intent);
            }
        });

        nextv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vyras.this, vyrs3.class);
                startActivity(intent);
            }
        });
    }
}
