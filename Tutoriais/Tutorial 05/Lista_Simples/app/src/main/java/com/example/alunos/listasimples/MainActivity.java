package com.example.alunos.listasimples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nomes[] = {"João", "Maria", "Jacinto", "Gertrudes", "Maria", "Jacinto", "Gertrudes", "Maria", "Jacinto", "Gertrudes", "Maria", "Jacinto", "Gertrudes"};
        String aniversarios[] = {"12/03", "12/04", "12/05", "12/06", "12/04", "12/05", "12/06", "12/04", "12/05", "12/06", "12/04", "12/05", "12/06"};

        ListView lista = findViewById(R.id.lista);

        ArrayList<HashMap<String, String>> valores = new ArrayList<>();

        for(int i=0; i<nomes.length; i++){
            HashMap<String, String> item = new HashMap<>();
            item.put("nome", nomes[i]);
            item.put("aniv", aniversarios[i]);
            valores.add(item);
        }
        String[] chaves = {"nome","aniv"};
        int[] labels = {R.id.lblFirst, R.id.lblSecond};

        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), valores, R.layout.item_lista, chaves, labels);

        lista.setAdapter(adapter);
    }
}
