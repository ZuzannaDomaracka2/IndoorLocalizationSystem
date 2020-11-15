package com.pracowniatmib.indoorlocalizationsystem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MapActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    MapFragment mapViewFragment;

    Button buttonSettings;
    Button buttonUpdateMap;
    Button buttonSensorMode;
    Button buttonAlgorithmMode;
    Button buttonTestMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Objects.requireNonNull(getSupportActionBar()).hide();

        fragmentManager = getSupportFragmentManager();

        buttonSettings = findViewById(R.id.buttonSettingsMap);
        buttonUpdateMap = findViewById(R.id.buttonUpdateMap);
        buttonSensorMode = findViewById(R.id.buttonSensorModeMap);
        buttonAlgorithmMode = findViewById(R.id.buttonAlgorithmModeMap);
        buttonTestMap = findViewById(R.id.buttonTestMap);

        buttonTestMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("X: " + mapViewFragment.getMapX() + ", Y: " + mapViewFragment.getMapY());
                mapViewFragment.moveMap(0,10);
                mapViewFragment.rotateCursor(30);
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MapActivity.this, "SETTINGS BUTTON CLICKED!", Toast.LENGTH_SHORT).show();

            }
        });

        buttonUpdateMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MapActivity.this, "UPDATE MAP BUTTON CLICKED!", Toast.LENGTH_SHORT).show();

            }
        });

        buttonSensorMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MapActivity.this, "SENSOR MODE BUTTON CLICKED!", Toast.LENGTH_SHORT).show();

            }
        });

        buttonAlgorithmMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MapActivity.this, "ALGORITHM MODE BUTTON CLICKED!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mapViewFragment = (MapFragment) fragmentManager.findFragmentById(R.id.mapViewFragment);
        mapViewFragment.setMap(R.drawable.default_indoor_map);
    }
}