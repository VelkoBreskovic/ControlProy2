package com.controlproyv2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Activity2 extends AppCompatActivity {
    private Bundle bundle;
    private TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvSaludo = (TextView) findViewById(R.id.tvSaludo);

        bundle = getIntent().getExtras();

        String saludo = bundle.getString("nombre");

        tvSaludo.append(" " + saludo + " :D");
    }
}
