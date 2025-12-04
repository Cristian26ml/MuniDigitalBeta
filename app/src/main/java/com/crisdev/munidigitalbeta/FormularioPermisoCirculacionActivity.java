package com.crisdev.munidigitalbeta;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class FormularioPermisoCirculacionActivity extends AppCompatActivity {

    EditText editPatente, editMarca, editModelo, editAnio, editTipo, editFechaVencimiento;
    Button btnContinuar;
    String rut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_permiso_circulacion);

        // Enlazar vistas
        editPatente = findViewById(R.id.editPatente);
        editMarca = findViewById(R.id.editMarca);
        editModelo = findViewById(R.id.editModelo);
        editAnio = findViewById(R.id.editAnio);
        editTipo = findViewById(R.id.editTipo);
        editFechaVencimiento = findViewById(R.id.editFechaVencimiento);
        btnContinuar = findViewById(R.id.btnContinuar);

        // Obtener RUT desde el intent
        rut = getIntent().getStringExtra("rut");

        // Mostrar selector de fecha
        editFechaVencimiento.setOnClickListener(v -> mostrarDatePicker());

        // Acción del botón
        btnContinuar.setOnClickListener(v -> {
            String patente = editPatente.getText().toString().trim();
            String marca = editMarca.getText().toString().trim();
            String modelo = editModelo.getText().toString().trim();
            String anio = editAnio.getText().toString().trim();
            String tipo = editTipo.getText().toString().trim();
            String fecha = editFechaVencimiento.getText().toString().trim();

            // Validaciones básicas
            if (patente.isEmpty() || marca.isEmpty() || modelo.isEmpty() ||
                    anio.isEmpty() || tipo.isEmpty() || fecha.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!patente.matches("^[A-Z]{2,4}-?\\d{2,4}$")) {
                Toast.makeText(this, "Formato de patente inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            int anioInt;
            try {
                anioInt = Integer.parseInt(anio);
                int anioActual = Calendar.getInstance().get(Calendar.YEAR);
                if (anioInt < 1950 || anioInt > anioActual) {
                    Toast.makeText(this, "Año fuera de rango válido", Toast.LENGTH_SHORT).show();
                    return;
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Año inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            // Enviar a resumen (puedes crear esta actividad después)
            Intent intent = new Intent(this, ResumenPermisoCirculacionActivity.class);
            intent.putExtra("rut", rut);
            intent.putExtra("patente", patente);
            intent.putExtra("marca", marca);
            intent.putExtra("modelo", modelo);
            intent.putExtra("anio", anio);
            intent.putExtra("tipo", tipo);
            intent.putExtra("fecha", fecha);
            startActivity(intent);
        });
    }

    private void mostrarDatePicker() {
        final Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialogoFecha = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            String fechaSeleccionada = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year);
            editFechaVencimiento.setText(fechaSeleccionada);
        }, anio, mes, dia);

        dialogoFecha.show();
    }
}