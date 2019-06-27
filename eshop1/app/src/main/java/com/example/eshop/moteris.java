package com.example.eshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class moteris extends AppCompatActivity {

    private Button s1, s2, s3, go, w1, w2, w3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moteris2);

        s1 = findViewById(R.id.foto1);
        s2 = findViewById(R.id.foto2);
        s3 = findViewById(R.id.foto3);
        go = findViewById(R.id.next2);
        w1 = findViewById(R.id.buy1);
        w2 = findViewById(R.id.buy2);
        w3 = findViewById(R.id.buy3);


        w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(moteris.this, wwd3.class);
                startActivity(intent);
            }
        });

        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(moteris.this, wwd2.class);
                startActivity(intent);
            }
        });

        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(moteris.this, wwd1.class);
                startActivity(intent);
            }
        });


        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(moteris.this, wwd3.class);
                startActivity(intent);
            }
        });

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(moteris.this, wwd1.class);
                startActivity(intent);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(moteris.this, wwd2.class);
                startActivity(intent);
            }
        });


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(moteris.this, moteris22.class);
                startActivity(intent);
            }
        });
    }
}
