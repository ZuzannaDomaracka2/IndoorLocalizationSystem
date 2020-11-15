package com.pracowniatmib.indoorlocalizationsystem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button buttonStart;
    Button buttonCheckDbConnection;
    Button buttonCheckPermissions;
    Button buttonEnableBt;
    Button buttonEnableWiFi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        buttonStart =findViewById(R.id.buttonStartMenu);
        buttonCheckDbConnection =   findViewById(R.id.buttonCheckDbConnMenu);
        buttonCheckPermissions =  findViewById(R.id.buttonCheckPermissionsMenu);
        buttonEnableBt = findViewById(R.id.buttonEnableBtMenu);
        buttonEnableWiFi =findViewById(R.id.buttonEnableWiFiMenu);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MapActivity.class));

            }
        });
        buttonCheckDbConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "CHECK DB CONNECTION BUTTON CLICKED!", Toast.LENGTH_SHORT).show();

            }
        });
        buttonCheckPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "CHECK PERMISSIONS BUTTON CLICKED!", Toast.LENGTH_SHORT).show();

            }
        });
        buttonEnableBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ENABLE BLUETOOTH BUTTON CLICKED! ", Toast.LENGTH_SHORT).show();

            }
        });
        buttonEnableWiFi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ENABLE WI-FI BUTTON CLICKED!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}