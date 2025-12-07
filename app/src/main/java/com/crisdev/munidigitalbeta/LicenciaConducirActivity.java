package com.crisdev.munidigitalbeta;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class LicenciaConducirActivity extends AppCompatActivity {
    EditText txtNombre, txtRut, txtFechaExamen;
    Spinner spinnerTipoTramite, spinnerTipoLicencia;
    Button btnEnviarLicencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licencia_conducir);

        txtNombre = findViewById(R.id.txtNombre);
        txtRut = findViewById(R.id.txtRut);
        txtFechaExamen = findViewById(R.id.txtFechaExamen);
        spinnerTipoTramite = findViewById(R.id.spinnerTipoTramite);
        spinnerTipoLicencia = findViewById(R.id.spinnerTipoLicencia);
        btnEnviarLicencia = findViewById(R.id.btnEnviarLicencia);

        // Opciones para tipo de trámite
        ArrayAdapter<String> adapterTramite = new ArrayAdapter<>(this,
                R.layout.spinner_item,
                new String[]{"Nueva licencia", "Renovación", "Duplicado"});
        adapterTramite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoTramite.setAdapter(adapterTramite);

        // Opciones para tipo de licencia
        ArrayAdapter<String> adapterLicencia = new ArrayAdapter<>(this,
                R.layout.spinner_item,
                new String[]{"Clase B (autos)", "Clase C (motos)", "Clase A (profesional)"});
        adapterLicencia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoLicencia.setAdapter(adapterLicencia);

        btnEnviarLicencia.setOnClickListener(v -> {
            String nombre = txtNombre.getText().toString();
            String rut = txtRut.getText().toString();
            String fecha = txtFechaExamen.getText().toString();
            String tramite = spinnerTipoTramite.getSelectedItem().toString();
            String licencia = spinnerTipoLicencia.getSelectedItem().toString();

            Toast.makeText(this,
                    "Solicitud enviada:\n" +
                            "Nombre: " + nombre + "\n" +
                            "RUT: " + rut + "\n" +
                            "Trámite: " + tramite + "\n" +
                            "Licencia: " + licencia + "\n" +
                            "Fecha examen: " + fecha,
                    Toast.LENGTH_LONG).show();
        });
    }
}
