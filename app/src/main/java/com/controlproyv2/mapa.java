package com.controlproyv2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;


public class mapa extends AppCompatActivity {

    private MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa2);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS);
    }

}