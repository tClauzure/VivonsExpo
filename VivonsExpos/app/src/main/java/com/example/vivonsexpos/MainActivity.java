package com.example.vivonsexpos;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonMenuConnexion = (Button) findViewById(R.id.buttonMenuConnexion);
        buttonMenuConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, menuConnexion.class);
                startActivity(intent);
            }
        });
        final Button buttonMenuVisiteur = (Button) findViewById(R.id.buttonMenuCatalogue);
        buttonMenuVisiteur.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, menuVisiteur.class);
                startActivity(intent);
            }
        }));

    }

}