package com.crisdev.munidigitalbeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

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
            Toast.makeText(this, "Trámite confirmado y enviado con éxito  ", Toast.LENGTH_LONG).show();
            // Aquí podrías guardar en Firebase o mostrar comprobante
            finish(); // Cierra esta pantalla
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
            finish(); // Cierra esta pantalla para evitar duplicados
        });
    }
}
