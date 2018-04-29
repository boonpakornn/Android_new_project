package com.example.thiti.project_application;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//references : https://medium.com/@sutthichai.tm/android-google-map-api-%E0%B8%AA%E0%B8%B3%E0%B8%AB%E0%B8%A3%E0%B8%B1%E0%B8%9A%E0%B8%9C%E0%B8%B9%E0%B9%89%E0%B9%80%E0%B8%A3%E0%B8%B4%E0%B9%88%E0%B8%A1%E0%B8%95%E0%B9%89%E0%B8%99-%E0%B8%A0%E0%B8%B2%E0%B8%84-1-5-583763f1bb7f
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * and add the marker in important place in Mahidol university.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in each point and move the camera
        LatLng muict = new LatLng(13.7941886, 100.3248333);
        mMap.addMarker(new MarkerOptions().position(muict).title("Faculty of ICT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(muict));

        LatLng socialcanteen = new LatLng(13.7928404, 100.3248672);
        mMap.addMarker(new MarkerOptions().position(socialcanteen).title("Social Fac. Canteen"));

        LatLng mlc = new LatLng(13.7939351, 100.3211026);
        mMap.addMarker(new MarkerOptions().position(mlc).title("MU learning Center"));

        LatLng salayastore = new LatLng(13.7933321,100.3227543);
        mMap.addMarker(new MarkerOptions().position(salayastore).title("Salaya Store"));

        LatLng tramstation = new LatLng(13.7947309, 100.3188644);
        mMap.addMarker(new MarkerOptions().position(tramstation).title("Tram Station"));

        LatLng princemahidolhall = new LatLng(13.7895719, 100.3212429);
        mMap.addMarker(new MarkerOptions().position(princemahidolhall).title("Prince Mahidol Hall"));

        LatLng seven = new LatLng(13.7962007, 100.3257342);
        mMap.addMarker(new MarkerOptions().position(seven).title("Seven Eleven"));

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {


            @Override
            // Return null here, so that getInfoContents() is called next.
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View infoWindow = getLayoutInflater().inflate(R.layout.info_map, null);


                TextView title = ((TextView) infoWindow.findViewById(R.id.textViewName));
                title.setText(marker.getTitle());


                TextView snippet = ((TextView) infoWindow.findViewById(R.id.textViewSnippet));
                snippet.setText(marker.getSnippet());

                ImageView imageView = (ImageView) infoWindow.findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.laptop);

                //show the imageView in each marker when user clicked
                if ("Social Fac. Canteen".equals(marker.getTitle())) {
                    imageView.setImageResource(R.drawable.food);
                }
                else if("MU learning Center".equals(marker.getTitle())) {
                    imageView.setImageResource(R.drawable.learning);
                }
                else if("Salaya Store".equals(marker.getTitle())) {
                    imageView.setImageResource(R.drawable.store);
                }
                else if("Tram Station".equals(marker.getTitle())) {
                    imageView.setImageResource(R.drawable.tram);
                }
                else if("Prince Mahidol Hall".equals(marker.getTitle())) {
                    imageView.setImageResource(R.drawable.stage);
                }
                else if("Seven Eleven".equals(marker.getTitle())) {
                    imageView.setImageResource(R.drawable.seven);
                }
                return infoWindow;
            }
        });
    }


}
