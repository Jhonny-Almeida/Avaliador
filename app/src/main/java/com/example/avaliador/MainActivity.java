package com.example.avaliador;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Filme> filmes = new ArrayList<>();
        Spinner spinner = findViewById(R.id.spinner);
        ImageView imageView = findViewById(R.id.capaFilme);
        TextView textView = findViewById(R.id.textoInfo);
        Button button = findViewById(R.id.btnEnviar);
        filmes.add(new Filme("Selecionar", R.drawable.popcorn, ""));
        filmes.add(new Filme("Almélie", R.drawable.amelie, "Amélie - 8 de fevereiro de 2002 \n\nDirigido por: Jean-Pierre Jeunet \n\nGênero: Comédia/Romance "));
        filmes.add(new Filme("Challengers", R.drawable.challengers, "Challengers - 26 de abril de 2024 \n\nDirigido por: Luca Guadagnino \n\nGênero:  Esporte/Romance "));
        filmes.add(new Filme("Five Nights at Freddy's", R.drawable.fnaf, "Five Nights at Freddy's - 26 de outubro de 2023  \n\nDirigido por: Emma Tammi  \n\nGênero: Terror/Mistério "));
        filmes.add(new Filme("Quarteto Fantastico", R.drawable.quartetofantastico, "Quarteto Fantastico - 24 de julho de 2025 \n\nDirigido por: Matt Shakman  \n\nGênero: Ação/Ficção científica"));
        filmes.add(new Filme("Superman", R.drawable.superman, "Superman - 10 de julho de 2025 \n\nDirigido por: James Gunn  \n\nGênero: Ação/Ficção científica "));
        filmes.add(new Filme("A Substancia", R.drawable.thesubstance, "A Substancia - 20 de setembro de 2024 \n\nDirigido por: Coralie Fargeat  \n\nGênero: Terror/Ficção científica "));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Avaliação Enviada!", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<Filme> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                filmes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Filme opcaoSelecionada = (Filme) adapterView.getItemAtPosition(position);
                imageView.setImageResource(opcaoSelecionada.getCapaFilme());
                textView.setText(opcaoSelecionada.getInfo());
                Toast.makeText(MainActivity.this, "Opção selecionada: " + opcaoSelecionada.getTitulo(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


    }
}