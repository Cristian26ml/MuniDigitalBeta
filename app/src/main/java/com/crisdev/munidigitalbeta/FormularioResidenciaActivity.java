package com.crisdev.munidigitalbeta;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class FormularioResidenciaActivity extends AppCompatActivity {

    EditText editNombre, editRut, editDireccion, editComuna, editTelefono, editMotivo;
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
        editMotivo = findViewById(R.id.editMotivo);
        if (getIntent().hasExtra("nombre")) {
            editNombre.setText(getIntent().getStringExtra("nombre"));
            editRut.setText(getIntent().getStringExtra("rut"));
            editDireccion.setText(getIntent().getStringExtra("direccion"));
            editComuna.setText(getIntent().getStringExtra("comuna"));
            editTelefono.setText(getIntent().getStringExtra("telefono"));
            editMotivo.setText(getIntent().getStringExtra("motivo"));
        }
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            String nombre = editNombre.getText().toString().trim();
            String rut = editRut.getText().toString().trim();
            String direccion = editDireccion.getText().toString().trim();
            String comuna = editComuna.getText().toString().trim();
            String telefono = editTelefono.getText().toString().trim();
            String motivo = editMotivo.getText().toString().trim();

            if (nombre.isEmpty() || rut.isEmpty() || direccion.isEmpty() || comuna.isEmpty() || telefono.isEmpty() || motivo.isEmpty()) {
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

            //Toast.makeText(this, "Formulario enviado correctamente ✅", Toast.LENGTH_LONG).show();
            // Aquí puedes guardar en Firebase o mostrar resumen
            Intent intent = new Intent(this, ResumenResidenciaActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("rut", rut);
            intent.putExtra("direccion", direccion);
            intent.putExtra("comuna", comuna);
            intent.putExtra("telefono", telefono);
            intent.putExtra("motivo", motivo);
            startActivity(intent);
        });
    }
}
