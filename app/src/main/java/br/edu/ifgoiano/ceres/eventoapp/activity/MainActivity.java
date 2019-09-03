package br.edu.ifgoiano.ceres.eventoapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ifgoiano.ceres.eventoapp.R;
import br.edu.ifgoiano.ceres.eventoapp.adapters.EventAdapter;
import br.edu.ifgoiano.ceres.eventoapp.service.EventoService;
import br.edu.ifgoiano.ceres.eventoapp.service.PessoaService;

public class MainActivity extends AppCompatActivity implements EventAdapter.ItemClickListener {
    private ProgressBar progressBar;
    private EventAdapter adapter;

    @Override
    protected void onStart() {
        super.onStart();
        adapter = new EventAdapter(this, null);
        adapter.setClickListener(this);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventoService oEventoService = new EventoService(this);
        PessoaService oPessoaService = new PessoaService(this);


        progressBar = findViewById(R.id.progressBar);
        RecyclerView recyclerView = findViewById(R.id.rv_enento);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventAdapter(this, oEventoService.getListaDeEventos());
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onItemClick(View view, int position) {
        //
        //  Toast.makeText(this, "You clicked " + adapter.getItem(position).getTickets().get(position).getPrices().get(position).getPrice() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
