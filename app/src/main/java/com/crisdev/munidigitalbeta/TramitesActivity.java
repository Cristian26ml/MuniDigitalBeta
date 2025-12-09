package com.crisdev.munidigitalbeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class TramitesActivity extends AppCompatActivity {

    TextView txtBienvenida;
    LinearLayout btnResidencia, btnPermisoCirculacion, btnVerCirculacion,
            btnLicencia, btnPatente, btnObras, btnJuzgado;
    String rut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tramites);

        txtBienvenida = findViewById(R.id.txtBienvenida);
        rut = getIntent().getStringExtra("rut");
        txtBienvenida.setText("Bienvenido/a a la selección de trámites.\nPor favor, seleccione un trámite:");

        btnResidencia = findViewById(R.id.btnResidencia);
        btnPermisoCirculacion = findViewById(R.id.btnPermisoCirculacion);
        btnVerCirculacion = findViewById(R.id.btnVerCirculacion);
        btnLicencia = findViewById(R.id.btnLicencia);
        btnPatente = findViewById(R.id.btnPatente);
        btnObras = findViewById(R.id.btnObras);
        btnJuzgado = findViewById(R.id.btnJuzgado);

        btnResidencia.setOnClickListener(v -> startActivity(new Intent(this, FormularioResidenciaActivity.class)));
        btnPermisoCirculacion.setOnClickListener(v -> startActivity(new Intent(this, FormularioPermisoCirculacionActivity.class)));
        btnVerCirculacion.setOnClickListener(v -> startActivity(new Intent(this, ListaPermisosActivity.class)));
        btnLicencia.setOnClickListener(v -> startActivity(new Intent(this, LicenciaConducirActivity.class)));
        btnPatente.setOnClickListener(v -> startActivity(new Intent(this, PatenteActivity.class)));
        btnObras.setOnClickListener(v -> startActivity(new Intent(this, CertificadosObrasActivity.class)));
        btnJuzgado.setOnClickListener(v -> startActivity(new Intent(this, JuzgadoPoliciaLocalActivity.class)));

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> finish());
    }
}