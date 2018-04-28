package com.example.alunos.androidqrcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnScan;
    private TextView lblNome, lblEndereco;
    private IntentIntegrator qrScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        lblNome = findViewById(R.id.lblNome);
        lblEndereco =findViewById(R.id.lblEndereco);

        qrScan = new IntentIntegrator(this);

        btnScan.setOnClickListener(this);
    }

    public void onClick(View v){
        qrScan.initiateScan();
    }

    protected void  onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result =IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if( result.getContents() == null){
                Toast.makeText(this,
                        "Result not found",
                        Toast.LENGTH_SHORT).show();
            } else {
                try {
                    JSONObject obj = new JSONObject(result.getContents());
                    if (obj.has("url")) {
                        intentUrl(obj.getString("url"));
                    } else if (obj.has("URL")) {
                        intentUrl(obj.getString("URL"));
                    } else if(result.getContents().contains("http")) {
                        intentUrl(result.getContents());
                    } else {
                        lblNome.setText(obj.getString("name"));
                        lblEndereco.setText(obj.getString("address"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this,
                            result.getContents(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void intentUrl(String url){
        if(!url.contains("http://") || !url.contains("http://")){
            url = "http://"+url;
        }
        Intent intencao = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(intencao);
    }
}