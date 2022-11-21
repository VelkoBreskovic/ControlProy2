package com.controlproyv2;



import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    CheckBox seleccionarChk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        seleccionarChk = (CheckBox)
                findViewById(R.id.chkSeleccionar);


    }

    public void mapa(View v) {
        Intent intent = new Intent(this, mapa.class);
        startActivity(intent);
    }

    public void hilo(View v) {
        Intent intent = new Intent(this, hilo.class);
        startActivity(intent);
    }

    public void openProximity(View v) {
        Intent intent = new Intent(this, Proximidad.class);
        startActivity(intent);
    }

    public void btnChek(View v) {
        if (seleccionarChk.isChecked()) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.coin);
            mp.start();

            Intent intent = new Intent(this, Spinner.class);
            startActivity(intent);
        } else {
            String mensaje = "Debes seleccionar para avanzar";
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        }

    }


}

