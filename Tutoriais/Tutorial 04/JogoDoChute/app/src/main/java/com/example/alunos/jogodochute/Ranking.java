package com.example.alunos.jogodochute;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Ranking extends AppCompatActivity {
    public int[][] historico;
    public List<String> dados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        setHistorico((ListView) findViewById(R.id.lista));
    }

    public void setHistorico(ListView v){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String jogadas = arquivo.getString("historico", "");
        if(jogadas.matches("")){

        } else {
            String[] temp = jogadas.split("#");
            String[][] temp2 = new String[temp.length][2];
            int[][] historico = new int[temp.length][2];


            for(int i=0; i<temp.length; i++){
                temp2[i][0] = temp[i].split(",")[0];
                temp2[i][1] = temp[i].split(",")[1];

                historico[i][0] = Integer.parseInt(temp2[i][0]);
                historico[i][0] = Integer.parseInt(temp2[i][1]);
                dados.add(String.format("Jogada nº %d\n%d tentativas", historico[i][0], historico[i][1]));
            }
            this.historico = historico;

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
            v.setAdapter(adapter);

            setBest((TextView)findViewById(R.id.melhorPartida));
        }
    }

    public void setBest(TextView v){
        int primeiro = historico[0][1];
        int pos = 0;
        for(int i=0; i<this.historico.length; i++){
            if(historico[i][1] < primeiro){
                primeiro = historico[i][1];
                pos = i;
            }
        }
        v.setText(String.format("Jogada nº %d\n%d tentativas", pos, primeiro));
    }
}