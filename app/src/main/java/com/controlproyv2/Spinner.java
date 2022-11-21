package com.controlproyv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button btnEnviar;
    private TextView nombreproyecto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        android.widget.Spinner spinner = findViewById(R.id.spinner_metodologia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Metodologia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        nombreproyecto2 = (TextView) findViewById(R.id.tipometodo);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nombreproyecto2.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Spinner.this, com.controlproyv2.Activity2.class);
                    intent.putExtra("nombre", nombreproyecto2.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(Spinner.this, "Debes indicar un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void foto(View v) {
        Intent intent = new Intent(this, TomarFoto2.class);
        startActivity(intent);
    }

}

