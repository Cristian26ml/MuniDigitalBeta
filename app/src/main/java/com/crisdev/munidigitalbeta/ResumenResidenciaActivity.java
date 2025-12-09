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

public class ResumenResidenciaActivity extends AppCompatActivity {

    TextView txtResumen;
    Button btnConfirmar, btnEditar;

    String nombre, rut, direccion, comuna, telefono, motivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_residencia);

        txtResumen = findViewById(R.id.txtResumen);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnEditar = findViewById(R.id.btnEditar);

        nombre = getIntent().getStringExtra("nombre");
        rut = getIntent().getStringExtra("rut");
        direccion = getIntent().getStringExtra("direccion");
        comuna = getIntent().getStringExtra("comuna");
        telefono = getIntent().getStringExtra("telefono");
        motivo = getIntent().getStringExtra("motivo");

        String resumen = "  Resumen de Solicitud\n\n"
                + "Nombre: " + nombre + "\n"
                + "RUT: " + rut + "\n"
                + "Dirección: " + direccion + "\n"
                + "Comuna: " + comuna + "\n"
                + "Teléfono: " + telefono + "\n"
                + "Motivo: " + motivo + "\n\n"
                + "  Este resumen puede ser guardado o impreso como comprobante.";

        txtResumen.setText(resumen);
        Toast.makeText(this, "Revisa tu resumen antes de enviar  ", Toast.LENGTH_LONG).show();

        btnConfirmar.setOnClickListener(v -> {

            FirebaseFirestore db = FirebaseFirestore.getInstance();

            Map<String, Object> datos = new HashMap<>();
            datos.put("nombre", nombre);
            datos.put("rut", rut);
            datos.put("direccion", direccion);
            datos.put("comuna", comuna);
            datos.put("telefono", telefono);
            datos.put("motivo", motivo);
            datos.put("tipo_tramite", "residencia");
            datos.put("estado", "pendiente");
            datos.put("timestamp", System.currentTimeMillis());

            db.collection("tramites_residencia")
                    .add(datos)
                    .addOnSuccessListener(docRef -> {
                        Toast.makeText(this, "Solicitud enviada y guardada ✅", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(this, TramitesActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Error al guardar. Intente nuevamente.", Toast.LENGTH_LONG).show();
                    });
        });


        btnEditar.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormularioResidenciaActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("rut", rut);
            intent.putExtra("direccion", direccion);
            intent.putExtra("comuna", comuna);
            intent.putExtra("telefono", telefono);
            intent.putExtra("motivo", motivo);
            startActivity(intent);
            finish();
        });
        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}
