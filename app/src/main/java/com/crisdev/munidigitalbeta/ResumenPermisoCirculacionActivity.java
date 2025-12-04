package com.crisdev.munidigitalbeta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ResumenPermisoCirculacionActivity extends AppCompatActivity {

    TextView txtRut, txtPatente, txtMarca, txtModelo, txtAnio, txtTipo, txtFecha;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_permiso_circulacion);

        // Enlazar vistas
        txtRut = findViewById(R.id.txtRut);
        txtPatente = findViewById(R.id.txtPatente);
        txtMarca = findViewById(R.id.txtMarca);
        txtModelo = findViewById(R.id.txtModelo);
        txtAnio = findViewById(R.id.txtAnio);
        txtTipo = findViewById(R.id.txtTipo);
        txtFecha = findViewById(R.id.txtFecha);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Obtener datos del intent
        String rut = getIntent().getStringExtra("rut");
        String patente = getIntent().getStringExtra("patente");
        String marca = getIntent().getStringExtra("marca");
        String modelo = getIntent().getStringExtra("modelo");
        String anio = getIntent().getStringExtra("anio");
        String tipo = getIntent().getStringExtra("tipo");
        String fecha = getIntent().getStringExtra("fecha");

        // Mostrar datos
        txtRut.setText("RUT: " + rut);
        txtPatente.setText("Patente: " + patente);
        txtMarca.setText("Marca: " + marca);
        txtModelo.setText("Modelo: " + modelo);
        txtAnio.setText("Año: " + anio);
        txtTipo.setText("Tipo de vehículo: " + tipo);
        txtFecha.setText("Fecha de vencimiento anterior: " + fecha);

        // Acción del botón
        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(this, "Trámite finalizado correctamente", Toast.LENGTH_LONG).show();
            finish(); // O puedes redirigir a otra pantalla
        });
    }
}
