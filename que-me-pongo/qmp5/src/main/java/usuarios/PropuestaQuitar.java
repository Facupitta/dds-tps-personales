package usuarios;

import prendas.Prenda;

public class PropuestaQuitar implements Propuesta {
  Prenda prenda;

  public PropuestaQuitar(Prenda prenda) {
    this.prenda = prenda;
  }

  public void efectuarEn(Armario armario) {
    armario.quitarPrenda(prenda);
  }

  public void deshacerEn(Armario armario) {
    armario.agregarPrenda(prenda);
  }
}
