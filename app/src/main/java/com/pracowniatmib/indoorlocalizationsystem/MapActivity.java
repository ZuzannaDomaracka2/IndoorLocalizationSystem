package com.pracowniatmib.indoorlocalizationsystem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MapActivity extends AppCompatActivity {

    Button btn_set;
    Button btn_update;
    Button btn_smode;
    Button btn_almode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btn_set=findViewById(R.id.btn_1M);
        btn_update=findViewById(R.id.btn_2M);
        btn_smode=findViewById(R.id.btn_3M);
        btn_almode=findViewById(R.id.btn_4M);

        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MapActivity.this, " OK ", Toast.LENGTH_SHORT).show();

            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MapActivity.this, " OK ", Toast.LENGTH_SHORT).show();

            }
        });

        btn_smode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MapActivity.this, " OK! ", Toast.LENGTH_SHORT).show();

            }
        });

        btn_almode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MapActivity.this, " OK ", Toast.LENGTH_SHORT).show();

            }
        });


    }
}