package com.example.vivonsexpos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class confirmationValidation extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button buttonRetour = (Button) findViewById(R.id.buttonback);
        buttonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                confirmationValidation.this.finish();
            }
        });

        final Button buttonConfirmer = (Button) findViewById(R.id.buttonConfirmer);
        buttonConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    enregistrerInscrit();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void enregistrerInscrit() throws IOException{

        String  login =  null;
        JSONObject  jsonInscrit = new JSONObject();

        try{
            login = jsonInscrit.getString("login");
        } catch (JSONException  e){
            e.printStackTrace();
        }

        RequestBody  formBody = new FormBody.Builder()
                .add("login",login)
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.1.23/php/enregistrerInscrit.php")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onResponse(Call  call, Response response)  throws IOException{
                String responseStr = response.body().string();
                if(responseStr.compareTo("false")!=0){
                    Intent intent = new Intent(confirmationValidation.this,validationInscription.class);
                    startActivity(intent);
                }else{
                    Log.d("Test","Login ou mot de  passe non valide !");
                }
            }
            public void onFailure(Call call, IOException e){
                Log.d("Test",e.getMessage());
            }
        });
    }


}
