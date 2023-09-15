package com.example.appgooglemaps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final View mWindow;
    private Context mContext;

    public CustomInfoWindowAdapter(Context context) {

        mContext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        TextView titleTextView = mWindow.findViewById(R.id.placeNameTextView);
        titleTextView.setText(marker.getTitle());

        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        // Aquí personalizamos el contenido de la ventana de información
        View infoWindowView = LayoutInflater.from(mContext).inflate(R.layout.custom_info_window, null);

        // Obtener referencias a las vistas en el diseño
        ImageView placeImageView = infoWindowView.findViewById(R.id.placeImageView);
        TextView titleTextView = infoWindowView.findViewById(R.id.placeNameTextView);
        TextView addressTextView = infoWindowView.findViewById(R.id.placeAddressTextView);

        // Obtener información del marcador (nombre, dirección, URL de la imagen)
        String name = marker.getTitle();
        String address = marker.getSnippet();
        String imageUrl = "https://lh3.googleusercontent.com/p/AF1QipNNOtEm6kO8l6IJZ_yL4BCd0qVEaOpB9dS8aTkM=s680-w680-h510"; // URL de la imagen del lugar (puedes obtenerlo de tus datos)

        // Cargar la imagen usando una biblioteca como Picasso o Glide
        Picasso.get().load(imageUrl).into(placeImageView);

        // Establecer el nombre y la dirección en las vistas
        titleTextView.setText(name);
        addressTextView.setText(address);

        return infoWindowView;
    }


}
