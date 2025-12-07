package com.crisdev.munidigitalbeta;

public class PermisoCirculacion {
    private String nombre, rut, direccion, comuna, telefono;
    private String patente, marca, modelo, anio, estado;

    public PermisoCirculacion() {} // Constructor vacío requerido por Firestore

    public String getNombre() { return nombre; }
    public String getRut() { return rut; }
    public String getDireccion() { return direccion; }
    public String getComuna() { return comuna; }
    public String getTelefono() { return telefono; }
    public String getPatente() { return patente; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getAnio() { return anio; }
    public String getEstado() { return estado; }
}