package com.example.eshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity {

    private Button womanbutton, manbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        womanbutton = findViewById(R.id.woman_button);
        manbutton = findViewById(R.id.man_button);

        womanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
            Intent intent = new Intent(CategoryActivity.this, moteris.class);
            startActivity(intent);
            }
        });

        manbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, vyras.class);
                startActivity(intent);
            }
        });
    }
}
