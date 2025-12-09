package com.crisdev.munidigitalbeta;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PatenteActivity extends AppCompatActivity {

    EditText txtNombreNegocio, txtRutTitular, txtDireccionNegocio;
    Spinner spinnerTipoPatente;
    Button btnEnviarPatente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patente);

        txtNombreNegocio = findViewById(R.id.txtNombreNegocio);
        txtRutTitular = findViewById(R.id.txtRutTitular);
        txtDireccionNegocio = findViewById(R.id.txtDireccionNegocio);
        spinnerTipoPatente = findViewById(R.id.spinnerTipoPatente);
        btnEnviarPatente = findViewById(R.id.btnEnviarPatente);

        // Opciones para tipo de patente
        ArrayAdapter<String> adapterPatente = new ArrayAdapter<>(this,
                R.layout.spinner_item,
                new String[]{"Comercial", "Profesional", "Industrial", "Alcoholes"});
        adapterPatente.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoPatente.setAdapter(adapterPatente);

        btnEnviarPatente.setOnClickListener(v -> {
            String negocio = txtNombreNegocio.getText().toString();
            String rut = txtRutTitular.getText().toString();
            String direccion = txtDireccionNegocio.getText().toString();
            String tipoPatente = spinnerTipoPatente.getSelectedItem().toString();

            Toast.makeText(this,
                    "Solicitud enviada:\n" +
                            "Negocio: " + negocio + "\n" +
                            "RUT: " + rut + "\n" +
                            "Dirección: " + direccion + "\n" +
                            "Tipo de patente: " + tipoPatente,
                    Toast.LENGTH_LONG).show();
        });

        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}