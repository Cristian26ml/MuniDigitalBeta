package com.crisdev.munidigitalbeta;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class AyudaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}
