package prendas;

public class Prenda {
  private String tipoPrenda;
  private Categoria categoria;
  private String material;
  private Color colorPrincipal;
  private Color colorSecundario; //puede ser null
  private Trama trama;
  private Integer temperaturaLimite;

  public Prenda(String tipoPrenda, Categoria categoria, String material, Color colorPrincipal, Color colorSecundario, Trama trama, Integer temperaturaLimite) {
    this.tipoPrenda = tipoPrenda;
    this.categoria = categoria;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.trama = trama;
    this.temperaturaLimite = temperaturaLimite;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public boolean esParteSuperior() {
    return this.getCategoria() == Categoria.PARTE_SUPERIOR;
  }

  public boolean esParteInferior() {
    return this.getCategoria() == Categoria.PARTE_INFERIOR;
  }

  public boolean esCalzado() {
    return this.getCategoria() == Categoria.CALZADO;
  }

  public boolean esAccesorio() {
    return this.getCategoria() == Categoria.ACCESORIO;
  }

  public boolean esAptaParaTemperatura(Integer temperatura) {
    return temperatura < this.temperaturaLimite;
  }
}

