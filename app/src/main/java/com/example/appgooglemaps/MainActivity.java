package com.example.appgooglemaps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    GoogleMap Mapa;
    ArrayList<LatLng> puntos = new ArrayList<LatLng>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Mapa = googleMap;

        // Personalizar el mapa
        Mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Mapa.getUiSettings().setZoomControlsEnabled(true);

        // Crear una instancia del adaptador personalizado y asignarla al mapa
        CustomInfoWindowAdapter infoWindowAdapter = new CustomInfoWindowAdapter(this);
        Mapa.setInfoWindowAdapter(infoWindowAdapter);

        CameraUpdate camUpd1 = CameraUpdateFactory
                .newLatLngZoom(new LatLng(-1.0127046603246574, -79.46941689110616), 17);
        Mapa.moveCamera(camUpd1);

        // Agregar un marcador de prueba
        LatLng testLatLng = new LatLng(-1.0127046603246574, -79.46941689110616);
        Mapa.addMarker(new MarkerOptions()
                .position(testLatLng)
                .title("Marcador de prueba"));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        Mapa.addMarker(new MarkerOptions().position(latLng)
                .title("Punto"));
    }
}

