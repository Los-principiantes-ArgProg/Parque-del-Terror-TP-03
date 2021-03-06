package model;

public class PromocionAxB extends Promocion {

	public PromocionAxB(int id, String nombre, String tipo, Integer tipoAtraccion, Attraction[] atracciones) {
		super(id, nombre, tipo, tipoAtraccion, atracciones);
	}

	public int calculoPromocion() {
		int devolucionCalculo = 0;
		int largoAtracciones = atracciones.length;
		for (int c = 0; c < largoAtracciones - 1; c++) {
			devolucionCalculo += atracciones[c].getCost();
		}
		return devolucionCalculo;
	}

}