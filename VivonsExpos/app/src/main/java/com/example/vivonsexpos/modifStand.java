package com.example.vivonsexpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class modifStand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modif_stand);

        final Button buttonRetour = (Button) findViewById(R.id.buttonback);
        buttonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                modifStand.this.finish();
            }
        });
    }
}
