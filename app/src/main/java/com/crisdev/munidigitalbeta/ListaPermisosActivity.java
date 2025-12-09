package com.crisdev.munidigitalbeta;

import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.widget.Toast;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;

public class ListaPermisosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PermisoAdapter adapter;
    private List<PermisoCirculacion> lista = new ArrayList<>();
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_permisos);

        recyclerView = findViewById(R.id.recyclerPermisos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PermisoAdapter(lista);
        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        db.collection("tramites_permiso_circulacion")
                .whereEqualTo("estado", "pendiente")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    lista.clear();
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        PermisoCirculacion permiso = doc.toObject(PermisoCirculacion.class);
                        lista.add(permiso);
                    }
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error al cargar trámites", Toast.LENGTH_SHORT).show();
                });
        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}
