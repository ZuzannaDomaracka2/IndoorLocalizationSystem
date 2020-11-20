package com.pracowniatmib.indoorlocalizationsystem;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
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

        buttonStart = findViewById(R.id.buttonStartMenu);
        buttonCheckDbConnection = findViewById(R.id.buttonCheckDbConnMenu);
        buttonCheckPermissions = findViewById(R.id.buttonCheckPermissionsMenu);
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
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    Toast.makeText(MainActivity.this, "Device does not support BLUETOOTH! ", Toast.LENGTH_SHORT).show();
                    buttonEnableBt.setText("Device does not support BLUETOOTH");
                } else if (mBluetoothAdapter.isEnabled()) {
                    Toast.makeText(MainActivity.this, "BLUETOOTH is ENABLE! ", Toast.LENGTH_SHORT).show();
                    buttonEnableBt.setText("BLUETOOTH is ENABLE");
                } else {
                    Toast.makeText(MainActivity.this, "BLUETOOTH is DISABLE", Toast.LENGTH_SHORT).show();
                    buttonEnableBt.setText("BLUETOOTH is DISABLE");
                }

            }
        });
        buttonEnableWiFi.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
              if (wifi.isWifiEnabled())
                {
                    Toast.makeText(MainActivity.this, "WI-FI is ENABLE!", Toast.LENGTH_SHORT).show();
                    buttonEnableWiFi.setText("WI-FI_is ENABLE");
                }
              else
                  Toast.makeText(MainActivity.this, "WI-FI is DISABLE!", Toast.LENGTH_SHORT).show();
                {
                    buttonEnableWiFi.setText("WI-FI is DISABLE");
                }
            }
        });

    }
}