package br.edu.ifgoiano.ceres.eventoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.edu.ifgoiano.ceres.eventoapp.R;
import br.edu.ifgoiano.ceres.eventoapp.adapters.EventAdapter;
import br.edu.ifgoiano.ceres.eventoapp.service.EventoService;

public class HomeActivity extends AppCompatActivity implements EventAdapter.ItemClickListener {

    @Override
    protected void onStart() {
        super.onStart();
        //  adapter = new EventAdapter(this, null);
        //   adapter.setClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.GONE);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_home);

        ProgressBar progressBar = findViewById(R.id.progressBar);

        EventoService oEventoService = new EventoService(this);

        while (oEventoService.getListaDeEventos().size() == 0) {
            if (oEventoService.getListaDeEventos().size() != 0) {
                Log.e("Home", "evento vazio");
            }
        }
        progressBar.setVisibility(View.GONE);
        FloatingActionButton eventos = findViewById(R.id.btn_agenda);
        eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CalendarioEventosActivity.class));
            }
        });


        RecyclerView recyclerView = findViewById(R.id.rv_evento);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EventAdapter adapter = new EventAdapter(this, oEventoService.getListaDeEventos());
        recyclerView.setAdapter(adapter);

        //progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onItemClick(View view, int position) {
        //
        //  Toast.makeText(this, "You clicked " + adapter.getItem(position).getTickets().get(position).getPrices().get(position).getPrice() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

}
