package com.crisdev.munidigitalbeta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class JuzgadoPoliciaLocalActivity extends AppCompatActivity {

    EditText txtNumeroCausa, txtRutInfractor, txtFechaInfraccion;
    Button btnEnviarJuzgado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juzgado);

        txtNumeroCausa = findViewById(R.id.txtNumeroCausa);
        txtRutInfractor = findViewById(R.id.txtRutInfractor);
        txtFechaInfraccion = findViewById(R.id.txtFechaInfraccion);
        btnEnviarJuzgado = findViewById(R.id.btnEnviarJuzgado);

        btnEnviarJuzgado.setOnClickListener(v -> {
            String causa = txtNumeroCausa.getText().toString();
            String rut = txtRutInfractor.getText().toString();
            String fecha = txtFechaInfraccion.getText().toString();

            Toast.makeText(this,
                    "Consulta enviada:\n" +
                            "Causa Nº: " + causa + "\n" +
                            "RUT: " + rut + "\n" +
                            "Fecha: " + fecha,
                    Toast.LENGTH_LONG).show();
        });
    }
}