package prendas;

public class SastreSanJuan extends Sastre {

  public void setParteSuperior() {
    Borrador parteSuperior = new Borrador("Chomba");
    parteSuperior.setCategoria(Categoria.PARTE_SUPERIOR);
    parteSuperior.setColorPrincipal(new Color(0, 255, 0));
    parteSuperior.setMaterial("Pique");
    this.uniforme.setParteSuperior(parteSuperior.construirPrenda());
  }

  public void setParteInferior() {
    Borrador parteInferior = new Borrador("Pantalon largo");
    parteInferior.setCategoria(Categoria.PARTE_INFERIOR);
    parteInferior.setColorPrincipal(new Color(64, 64, 64));
    parteInferior.setMaterial("Acetato");
    this.uniforme.setParteSuperior(parteInferior.construirPrenda());
  }

  public void setCalzado() {
    Borrador parteInferior = new Borrador("Zapatillas");
    parteInferior.setCategoria(Categoria.CALZADO);
    parteInferior.setColorPrincipal(new Color(255, 255, 255));
    parteInferior.setMaterial("Cuero");
    this.uniforme.setParteSuperior(parteInferior.construirPrenda());
  }
}
