package com.controlproyv2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TomarFoto2 extends AppCompatActivity {
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityfoto);
        iv1 = findViewById(R.id.iv1);
    }

    final int CAPTURA_IMAGEN = 1;

    public void tomarFoto(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAPTURA_IMAGEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURA_IMAGEN && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap1 = (Bitmap) extras.get("data");
            iv1.setImageBitmap(bitmap1);
            try {
                FileOutputStream fos = openFileOutput(crearNombreArchivoJPG(), Context.MODE_PRIVATE);
                bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.close();
            } catch (Exception e) {

            }
        }
    }

    private String crearNombreArchivoJPG() {
        String fecha = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return fecha + ".jpg";

    }

    public void verTodaslasFotos(View v) {
        Intent intent = new Intent(this, com.controlproyv2.TomarFoto3.class);
        startActivity(intent);

    }
}