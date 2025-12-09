package com.crisdev.munidigitalbeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout btnTramites, btnNoticias, btnReportes, btnContacto, btnAyuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTramites = findViewById(R.id.btnTramites);
        btnNoticias = findViewById(R.id.btnNoticias);
        btnReportes = findViewById(R.id.btnReportes);
        btnContacto = findViewById(R.id.btnContacto);
        btnAyuda = findViewById(R.id.btnAyuda);

        btnTramites.setOnClickListener(v -> {
            Intent intent = new Intent(this, IngresoRutActivity.class);
            intent.putExtra("tramite", "inicio");
            startActivity(intent);
        });

        btnNoticias.setOnClickListener(v -> startActivity(new Intent(this, NoticiasActivity.class)));
        btnReportes.setOnClickListener(v -> startActivity(new Intent(this, ReportesActivity.class)));
        btnContacto.setOnClickListener(v -> startActivity(new Intent(this, ContactoActivity.class)));
        btnAyuda.setOnClickListener(v -> startActivity(new Intent(this, AyudaActivity.class)));

        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}
