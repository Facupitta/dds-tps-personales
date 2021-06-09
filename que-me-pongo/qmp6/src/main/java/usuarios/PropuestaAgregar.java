package usuarios;

import prendas.Prenda;

public class PropuestaAgregar implements Propuesta {
  Prenda prenda;

  public PropuestaAgregar(Prenda prenda) {
    this.prenda = prenda;
  }

  public void efectuarEn(Armario armario) {
    armario.agregarPrenda(prenda);
  }

  public void deshacerEn(Armario armario) {
    armario.quitarPrenda(prenda);
  }
}
