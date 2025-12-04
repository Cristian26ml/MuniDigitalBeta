package com.crisdev.munidigitalbeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TramitesActivity extends AppCompatActivity {

    TextView txtBienvenida;
    Button btnCertificadoResidencia;
    Button btnPermisoCirculacion;
    String rut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tramites);

        txtBienvenida = findViewById(R.id.txtBienvenida);
        btnCertificadoResidencia = findViewById(R.id.btnCertificadoResidencia);
        btnPermisoCirculacion = findViewById(R.id.btnPermisoCirculacion);

        rut = getIntent().getStringExtra("rut");
        txtBienvenida.setText("Bienvenido/a. RUT: " + rut + "\nSeleccione un trámite:");

        btnCertificadoResidencia.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormularioResidenciaActivity.class);
            intent.putExtra("rut", rut);
            startActivity(intent);
        });

        btnPermisoCirculacion.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormularioPermisoCirculacionActivity.class);
            intent.putExtra("rut", rut);
            startActivity(intent);
        });
    }
}