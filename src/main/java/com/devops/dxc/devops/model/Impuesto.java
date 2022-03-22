package com.devops.dxc.devops.model;

public class Impuesto {

    private Float impuesto;

	private int sueldo;

    public Impuesto(int sueldo) {
        this.sueldo = sueldo;
    }

    public Impuesto() {}
    
    public Float getImpuesto() {
		return Util.getImpuesto(sueldo);
	}
	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}
}
