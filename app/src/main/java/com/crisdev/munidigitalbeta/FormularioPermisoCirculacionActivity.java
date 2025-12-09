package com.crisdev.munidigitalbeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioPermisoCirculacionActivity extends AppCompatActivity {

    private EditText etNombre, etRut, etDireccion, etComuna, etTelefono;
    private EditText etPatente, etMarca, etModelo, etAnio, etTipo, etFecha;
    private Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_permiso_circulacion);

        // Enlazar vistas
        etNombre = findViewById(R.id.etNombre);
        etRut = findViewById(R.id.etRut);
        etDireccion = findViewById(R.id.etDireccion);
        etComuna = findViewById(R.id.etComuna);
        etTelefono = findViewById(R.id.etTelefono);
        etPatente = findViewById(R.id.etPatente);
        etMarca = findViewById(R.id.etMarca);
        etModelo = findViewById(R.id.etModelo);
        etAnio = findViewById(R.id.etAnio);
        etTipo = findViewById(R.id.etTipo);
        etFecha = findViewById(R.id.etFecha);

        btnContinuar = findViewById(R.id.btnContinuar);


        btnContinuar.setOnClickListener(v -> {

            String nombre = etNombre.getText().toString();
            String rut = etRut.getText().toString();
            String direccion = etDireccion.getText().toString();
            String comuna = etComuna.getText().toString();
            String telefono = etTelefono.getText().toString();
            String patente = etPatente.getText().toString();
            String marca = etMarca.getText().toString();
            String modelo = etModelo.getText().toString();
            String anio = etAnio.getText().toString();
            String tipo = etTipo.getText().toString();
            String fecha = etFecha.getText().toString();

            Intent intent = new Intent(FormularioPermisoCirculacionActivity.this, ResumenPermisoCirculacionActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("rut", rut);
            intent.putExtra("direccion", direccion);
            intent.putExtra("comuna", comuna);
            intent.putExtra("telefono", telefono);
            intent.putExtra("patente", patente);
            intent.putExtra("marca", marca);
            intent.putExtra("modelo", modelo);
            intent.putExtra("anio", anio);
            intent.putExtra("tipo", tipo);
            intent.putExtra("fecha", fecha);

            startActivity(intent);
        });
        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}