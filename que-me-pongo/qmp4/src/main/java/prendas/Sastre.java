package prendas;

public abstract class Sastre {
  protected Uniforme uniforme;

  public Uniforme armarUniforme() {
    this.setParteSuperior();
    this.setParteInferior();
    this.setCalzado();
    return uniforme;
  }

  public abstract void setParteSuperior();
  public abstract void setParteInferior();
  public abstract void setCalzado();
}
