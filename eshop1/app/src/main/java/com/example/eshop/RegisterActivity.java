package com.example.eshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText regmail, regpass, regpass2;
    Button regbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regmail = findViewById(R.id.register_email);
        regpass = findViewById(R.id.register_password);
        regpass2 = findViewById(R.id.register_password_conirm);
        regbutton = findViewById(R.id.register_buttonas);
    }
}
