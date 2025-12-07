package com.crisdev.munidigitalbeta;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CertificadosObrasActivity extends AppCompatActivity {

    EditText txtDireccionObra, txtObservaciones;
    Spinner spinnerTipoCertificado;
    Button btnEnviarObras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificados_obras);

        txtDireccionObra = findViewById(R.id.txtDireccionObra);
        txtObservaciones = findViewById(R.id.txtObservaciones);
        spinnerTipoCertificado = findViewById(R.id.spinnerTipoCertificado);
        btnEnviarObras = findViewById(R.id.btnEnviarObras);

        // Opciones para tipo de certificado
        ArrayAdapter<String> adapterCertificado = new ArrayAdapter<>(this,
                R.layout.spinner_item,
                new String[]{"Número domiciliario", "Recepción final", "Subdivisión de terreno", "Otros"});
        adapterCertificado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoCertificado.setAdapter(adapterCertificado);

        btnEnviarObras.setOnClickListener(v -> {
            String direccion = txtDireccionObra.getText().toString();
            String observaciones = txtObservaciones.getText().toString();
            String tipoCertificado = spinnerTipoCertificado.getSelectedItem().toString();

            Toast.makeText(this,
                    "Solicitud enviada:\n" +
                            "Dirección: " + direccion + "\n" +
                            "Certificado: " + tipoCertificado + "\n" +
                            "Observaciones: " + observaciones,
                    Toast.LENGTH_LONG).show();
        });
    }
}