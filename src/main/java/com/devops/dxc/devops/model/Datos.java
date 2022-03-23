package com.devops.dxc.devops.model;

public class Datos {
    private String codigo;
    private String nombre;
    private String unidad_medida;
    private String fecha;
    private Float valor;

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad_medida() {
        return this.unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
