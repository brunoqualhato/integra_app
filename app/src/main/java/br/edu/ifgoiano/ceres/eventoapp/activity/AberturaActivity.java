package br.edu.ifgoiano.ceres.eventoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifgoiano.ceres.eventoapp.R;

public class AberturaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {

                startActivity(new Intent(AberturaActivity.this, CalendarioEventosActivity.class));


                finish();
            }
        }, 3000);
    }
}
