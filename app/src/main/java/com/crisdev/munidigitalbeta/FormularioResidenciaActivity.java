package com.crisdev.munidigitalbeta;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class FormularioResidenciaActivity extends AppCompatActivity {

    EditText editNombre, editRut, editDireccion, editComuna, editTelefono;
    Spinner spinnerMotivo;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_residencia);

        editNombre = findViewById(R.id.editNombre);
        editRut = findViewById(R.id.editRut);
        editDireccion = findViewById(R.id.editDireccion);
        editComuna = findViewById(R.id.editComuna);
        editTelefono = findViewById(R.id.editTelefono);
        spinnerMotivo = findViewById(R.id.spinnerMotivo);
        btnEnviar = findViewById(R.id.btnEnviar);

        ArrayAdapter<String> adapterMotivo = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                new String[]{
                        "Trámite escolar",
                        "Postulación a beneficios",
                        "Proceso judicial",
                        "Otros"
                }
        );
        adapterMotivo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMotivo.setAdapter(adapterMotivo);

        if (getIntent().hasExtra("nombre")) {
            editNombre.setText(getIntent().getStringExtra("nombre"));
            editRut.setText(getIntent().getStringExtra("rut"));
            editDireccion.setText(getIntent().getStringExtra("direccion"));
            editComuna.setText(getIntent().getStringExtra("comuna"));
            editTelefono.setText(getIntent().getStringExtra("telefono"));

            String motivoExtra = getIntent().getStringExtra("motivo");
            if (motivoExtra != null) {
                int pos = adapterMotivo.getPosition(motivoExtra);
                if (pos >= 0) spinnerMotivo.setSelection(pos);
            }
        }

        btnEnviar.setOnClickListener(v -> {
            String nombre = editNombre.getText().toString().trim();
            String rut = editRut.getText().toString().trim();
            String direccion = editDireccion.getText().toString().trim();
            String comuna = editComuna.getText().toString().trim();
            String telefono = editTelefono.getText().toString().trim();
            String motivo = spinnerMotivo.getSelectedItem().toString();

            if (nombre.isEmpty() || rut.isEmpty() || direccion.isEmpty() || comuna.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos.", Toast.LENGTH_LONG).show();
                return;
            }

            if (!rut.matches("^\\d{7,8}-[\\dkK]$")) {
                Toast.makeText(this, "RUT inválido. Ejemplo: 12345678-9", Toast.LENGTH_LONG).show();
                return;
            }

            if (!Patterns.PHONE.matcher(telefono).matches()) {
                Toast.makeText(this, "Teléfono inválido. Ejemplo: 912345678", Toast.LENGTH_LONG).show();
                return;
            }

            Intent intent = new Intent(this, ResumenResidenciaActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("rut", rut);
            intent.putExtra("direccion", direccion);
            intent.putExtra("comuna", comuna);
            intent.putExtra("telefono", telefono);
            intent.putExtra("motivo", motivo);
            startActivity(intent);
        });
        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}