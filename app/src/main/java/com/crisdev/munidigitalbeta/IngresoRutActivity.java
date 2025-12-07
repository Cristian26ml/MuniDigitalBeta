package com.crisdev.munidigitalbeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class IngresoRutActivity extends AppCompatActivity {

    EditText editRut;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_rut);

        editRut = findViewById(R.id.editRut);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(v -> {
            String rut = editRut.getText().toString().trim();

            // Validación con expresión regular
            if (rut.matches("^\\d{7,8}-[\\dkK]$")) {
                // Si el RUT es válido, pasa a TramitesActivity
                Intent intent = new Intent(this, TramitesActivity.class);
                intent.putExtra("rut", rut);
                startActivity(intent);
                finish();
            } else {
                // Si el RUT no cumple el formato, muestra error
                Toast.makeText(this, "RUT inválido. Ejemplo: 12345678-9", Toast.LENGTH_LONG).show();
            }
        });
    }
}