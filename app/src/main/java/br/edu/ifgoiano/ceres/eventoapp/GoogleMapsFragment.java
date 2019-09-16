package br.edu.ifgoiano.ceres.eventoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;


public class GoogleMapsFragment extends Fragment implements OnMapReadyCallback {
    private MapView mMapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_google_maps, container, false);

        mMapView = view.findViewById(R.id.mapViewLocalizacao);
        mMapView.onCreate(savedInstanceState);

        mMapView.getMapAsync(this);
        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLngBounds oLatLngBounds = new LatLngBounds(new LatLng(-15.3515951, -49.5954592),
                new LatLng(-15.3515951, -49.5954592));
        googleMap.setLatLngBoundsForCameraTarget(oLatLngBounds);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(oLatLngBounds, 0));
        googleMap.setLatLngBoundsForCameraTarget(oLatLngBounds);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-15.3515951, -49.5954592), 30.0f));
        googleMap.setTrafficEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
