package com.crisdev.munidigitalbeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetallePermisoActivity extends AppCompatActivity {

    private TextView txtNombre, txtRut, txtDireccion, txtComuna, txtTelefono,
            txtPatente, txtMarca, txtModelo, txtAnio, txtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_permiso);

        txtNombre = findViewById(R.id.txtNombre);
        txtRut = findViewById(R.id.txtRut);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtComuna = findViewById(R.id.txtComuna);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtPatente = findViewById(R.id.txtPatente);
        txtMarca = findViewById(R.id.txtMarca);
        txtModelo = findViewById(R.id.txtModelo);
        txtAnio = findViewById(R.id.txtAnio);
        txtEstado = findViewById(R.id.txtEstado);

        Intent intent = getIntent();
        txtNombre.setText("Nombre: " + intent.getStringExtra("nombre"));
        txtRut.setText("RUT: " + intent.getStringExtra("rut"));
        txtDireccion.setText("Dirección: " + intent.getStringExtra("direccion"));
        txtComuna.setText("Comuna: " + intent.getStringExtra("comuna"));
        txtTelefono.setText("Teléfono: " + intent.getStringExtra("telefono"));
        txtPatente.setText("Patente: " + intent.getStringExtra("patente"));
        txtMarca.setText("Marca: " + intent.getStringExtra("marca"));
        txtModelo.setText("Modelo: " + intent.getStringExtra("modelo"));
        txtAnio.setText("Año: " + intent.getStringExtra("anio"));
        txtEstado.setText("Estado: " + intent.getStringExtra("estado"));

        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}