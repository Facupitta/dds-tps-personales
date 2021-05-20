package prendas;

public class SastreJohnson extends Sastre {

  public void setParteSuperior() {
    Borrador parteSuperior = new Borrador("Camisa");
    parteSuperior.setCategoria(Categoria.PARTE_SUPERIOR);
    parteSuperior.setColorPrincipal(new Color(255, 255, 255));
    parteSuperior.setMaterial("Seda");
    this.uniforme.setParteSuperior(parteSuperior.construirPrenda());
  }

  public void setParteInferior() {
    Borrador parteInferior = new Borrador("Pantalon de vestir");
    parteInferior.setCategoria(Categoria.PARTE_INFERIOR);
    parteInferior.setColorPrincipal(new Color(0, 0, 0));
    parteInferior.setMaterial("Acetato");
    this.uniforme.setParteSuperior(parteInferior.construirPrenda());
  }

  public void setCalzado() {
    Borrador parteInferior = new Borrador("Zapatos");
    parteInferior.setCategoria(Categoria.CALZADO);
    parteInferior.setColorPrincipal(new Color(0, 0, 0));
    parteInferior.setMaterial("Cuero");
    this.uniforme.setParteSuperior(parteInferior.construirPrenda());
  }
}
