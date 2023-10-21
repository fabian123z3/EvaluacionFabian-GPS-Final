package cl.santotomas.evaluacionfabian_gps;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaMain extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String[] coordenadas = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_main);

        Intent intent = getIntent();
        coordenadas[0] = intent.getStringExtra("coordenadas 1");
        coordenadas[1] = intent.getStringExtra("coordenadas 2");
        coordenadas[2] = intent.getStringExtra("coordenadas 3");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //Importante activar la ubicacion
        mMap.setMyLocationEnabled(true);

        for (String coordenada : coordenadas) {
            if (coordenada == null) continue;
            String[] coordenadasArray = coordenada.split(",");
            if (coordenadasArray.length != 2) continue;
            double latitud = Double.parseDouble(coordenadasArray[0]);
            double longitud = Double.parseDouble(coordenadasArray[1]);
            LatLng ubicacion = new LatLng(latitud, longitud);
            mMap.addMarker(new MarkerOptions().position(ubicacion));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        }
    }
}
