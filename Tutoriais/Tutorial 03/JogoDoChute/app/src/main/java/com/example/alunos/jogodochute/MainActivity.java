package com.example.alunos.jogodochute;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private int tentativas = 3, numero;
    private TextView txtTentativas, resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtTentativas = findViewById(R.id.tentativas);
        this.resultado = findViewById(R.id.resultado);
        this.numero = this.gerador();
    }

    public void verificador(View v){
        EditText entrada = findViewById(R.id.campo);
        int num = Integer.parseInt(entrada.getText().toString().replaceAll("[\\D]",""));
        if(num != this.numero && this.numero != 0){
            this.tentativas--;
            if(tentativas == 0) {
                this.dialog("Você perdeu!!", String.format("O número era %d... Tentar novamente?", this.numero));
            }
            else {
                this.resultado.setText("Errou!!");
                this.limpador();
            }
        } else if(this.numero != 0){
            this.dialog("Você acertou!!", "Jogar novamente?");
        }

        this.txtTentativas.setText(String.format(getResources().getString(R.string.tentativas), tentativas));
    }

    public int gerador(){
        tentativas = 3;
        this.txtTentativas.setText(String.format(getResources().getString(R.string.tentativas), tentativas));
        Random gerador = new Random();
        return gerador.nextInt(100)+1;
    }

    public void limpador(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resultado.setText("");
            }
        }, 3000);
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
}
