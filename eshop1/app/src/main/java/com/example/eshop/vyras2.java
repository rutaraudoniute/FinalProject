package com.example.eshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vyras2 extends AppCompatActivity {

    Button v2back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vyras2);

        v2back = findViewById(R.id.back11v);

        v2back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vyras2.this, vyras.class);
                startActivity(intent);
            }
        });
    }
}
