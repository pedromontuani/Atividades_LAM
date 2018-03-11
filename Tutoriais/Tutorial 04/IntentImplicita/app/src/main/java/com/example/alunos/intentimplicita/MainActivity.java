package com.example.alunos.intentimplicita;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openURL(View v){
        EditText url = findViewById(R.id.url);
        String digitedURL = url.getText().toString();

        if(digitedURL.matches("")){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Digite um endereço web válido", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intencao = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(uriValidator(digitedURL)
            ));
            startActivity(intencao);
        }
    }

    public String uriValidator(String str){
        if(!str.contains("http://") || !str.contains("http://")){
            return "http://"+str;
        } else {
            return str;
        }
    }
}
