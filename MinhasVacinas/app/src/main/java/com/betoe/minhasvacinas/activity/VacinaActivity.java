package com.betoe.minhasvacinas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.betoe.minhasvacinas.R;
import com.betoe.minhasvacinas.model.Vacina;

import java.util.ArrayList;
import java.util.List;

public class VacinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacina);

        ListView listaDeVacinas = (ListView) findViewById(R.id.vacina_lista);

        List<Vacina> vacinas = todasAsVacinas();

        ArrayAdapter<Vacina> adapter = new ArrayAdapter<Vacina>(this,
                android.R.layout.simple_list_item_1, vacinas);

        listaDeVacinas.setAdapter(adapter);
    }

    private List<Vacina> todasAsVacinas() {

        ArrayList<Vacina> vacinas = new ArrayList<>();
        Vacina v1 = new Vacina("Recombitek C6/CV", "06/06/17","06/06/18","Alana");
        Vacina v2 = new Vacina("Vacina inativada contra a raiva", "06/06/17","06/06/18","Alana");
        Vacina v3 = new Vacina("Vacina inativada contra a Giardiase", "06/06/17","06/06/18","Alana");

        vacinas.add(v1);
        vacinas.add(v2);
        vacinas.add(v3);

        return vacinas;
    }
}
