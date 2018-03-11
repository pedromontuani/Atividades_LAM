package com.example.alunos.jogodochute;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private int tentativas = 0, numero, jogada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.numero = this.gerador();
        jogada = getJogada()+1;
        Log.d("numero", String.format("%d", numero));
    }

    public void verificador(View v){
        EditText entrada = findViewById(R.id.campo);
        int num = Integer.parseInt(entrada.getText().toString().replaceAll("[\\D]",""));
        tentativas++;

        if(num != numero){
            if(num < numero){
                msg(String.format("O número é maior que %d", num));
            } else {
                msg(String.format("O número é menor que %d", num));
            }
        } else {
            saveJogada(jogada, tentativas);
            this.dialog("Você acertou!!",
                    String.format("Você acertou na %dª tentativa. Jogar novamente?", tentativas));
        }

    }

    public int gerador(){
        tentativas = 0;
        Random gerador = new Random();
        return gerador.nextInt(1000)+1;
    }

    public void msg(String msg){
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void dialog(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle(title);
        builder.setMessage(msg);

        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                numero = gerador();
            }
        });
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
                System.exit(0);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public int getJogada(){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        return arquivo.getString("historico", "").split("#").length;
    }

    public void saveJogada(int a, int b){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);

        String historico = arquivo.getString("historico", "");
        historico = historico + Integer.toString(a) + "," + Integer.toString(b) + "#";

        arquivo.edit().putString("historico", historico).apply();
    }

    public void placar(View v){
        Intent intent = new Intent(MainActivity.this, Ranking.class);
        startActivity(intent);
    }
}
