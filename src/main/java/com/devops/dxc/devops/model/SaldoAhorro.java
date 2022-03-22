package com.devops.dxc.devops.model;

public class SaldoAhorro {

    private int saldoahorro;

	private int ahorro;

    public SaldoAhorro(int ahorro) {
        this.ahorro = ahorro;
    }

    public SaldoAhorro() {}
    public int getSaldoAhorro() {
		return Util.getSaldoAhorro(ahorro);
	}
	public void setSaldoAhorro(int saldoahorro) {
		this.saldoahorro = saldoahorro;
	}
}
