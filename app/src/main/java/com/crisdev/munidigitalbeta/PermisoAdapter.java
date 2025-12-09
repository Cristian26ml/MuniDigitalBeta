package com.crisdev.munidigitalbeta;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import android.content.Context;
import android.content.Intent;
public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.ViewHolder> {

    private List<PermisoCirculacion> lista;

    public PermisoAdapter(List<PermisoCirculacion> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_permiso, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PermisoCirculacion permiso = lista.get(position);

        holder.txtPatente.setText("Patente: " + permiso.getPatente());
        holder.txtMarcaModelo.setText("Vehículo: " + permiso.getMarca() + " " + permiso.getModelo());
        holder.txtEstado.setText("Estado: " + permiso.getEstado());

        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetallePermisoActivity.class);

            intent.putExtra("nombre", permiso.getNombre());
            intent.putExtra("rut", permiso.getRut());
            intent.putExtra("direccion", permiso.getDireccion());
            intent.putExtra("comuna", permiso.getComuna());
            intent.putExtra("telefono", permiso.getTelefono());
            intent.putExtra("patente", permiso.getPatente());
            intent.putExtra("marca", permiso.getMarca());
            intent.putExtra("modelo", permiso.getModelo());
            intent.putExtra("anio", permiso.getAnio());
            intent.putExtra("estado", permiso.getEstado());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPatente, txtMarcaModelo, txtEstado;

        public ViewHolder(View itemView) {
            super(itemView);
            txtPatente = itemView.findViewById(R.id.txtPatente);
            txtMarcaModelo = itemView.findViewById(R.id.txtMarcaModelo);
            txtEstado = itemView.findViewById(R.id.txtEstado);
        }
    }
}