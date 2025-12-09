package com.crisdev.munidigitalbeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ResumenPermisoCirculacionActivity extends AppCompatActivity {

    // Variables para los datos recibidos
    private String nombre, rut, direccion, comuna, telefono, patente, marca, modelo, anio, tipo, fecha;

    private TextView txtRut, txtPatente, txtMarca, txtModelo, txtAnio, txtTipo, txtFecha;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_permiso_circulacion);

        txtRut = findViewById(R.id.txtRut);
        txtPatente = findViewById(R.id.txtPatente);
        txtMarca = findViewById(R.id.txtMarca);
        txtModelo = findViewById(R.id.txtModelo);
        txtAnio = findViewById(R.id.txtAnio);
        txtTipo = findViewById(R.id.txtTipo);
        txtFecha = findViewById(R.id.txtFecha);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        rut = intent.getStringExtra("rut");
        direccion = intent.getStringExtra("direccion");
        comuna = intent.getStringExtra("comuna");
        telefono = intent.getStringExtra("telefono");
        patente = intent.getStringExtra("patente");
        marca = intent.getStringExtra("marca");
        modelo = intent.getStringExtra("modelo");
        anio = intent.getStringExtra("anio");
        tipo = intent.getStringExtra("tipo");
        fecha = intent.getStringExtra("fecha");

        txtRut.setText("RUT: " + rut);
        txtPatente.setText("Patente: " + patente);
        txtMarca.setText("Marca: " + marca);
        txtModelo.setText("Modelo: " + modelo);
        txtAnio.setText("Año: " + anio);
        txtTipo.setText("Tipo de vehículo: " + tipo);
        txtFecha.setText("Fecha de vencimiento anterior: " + fecha);

        btnFinalizar.setOnClickListener(v -> guardarTramite());

        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }

    private void guardarTramite() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> datos = new HashMap<>();
        datos.put("nombre", nombre);
        datos.put("rut", rut);
        datos.put("direccion", direccion);
        datos.put("comuna", comuna);
        datos.put("telefono", telefono);
        datos.put("patente", patente);
        datos.put("marca", marca);
        datos.put("modelo", modelo);
        datos.put("anio", anio);
        datos.put("tipo_tramite", "permiso_circulacion");
        datos.put("estado", "pendiente");
        datos.put("timestamp", System.currentTimeMillis());

        // Guardar en Firestore
        db.collection("tramites_permiso_circulacion")
                .add(datos)
                .addOnSuccessListener(docRef -> {
                    Toast.makeText(this, "Permiso de circulación enviado ✅", Toast.LENGTH_LONG).show();
                    Intent intentMenu = new Intent(this, TramitesActivity.class);
                    intentMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentMenu);
                    finish();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error al guardar. Intente nuevamente.", Toast.LENGTH_LONG).show();
                });
    }
}