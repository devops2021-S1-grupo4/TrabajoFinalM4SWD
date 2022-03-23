package com.devops.dxc.devops.model;

public class Indicadores {
    private String version;
    private String fecha;
    private String autor;
    private Datos uf;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Datos getUf() {
        return this.uf;
    }

    public void setUf(Datos uf) {
        this.uf = uf;
    }
}
