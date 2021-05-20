package prendas;

import exceptions.sinColorPrincipalException;
import exceptions.sinMaterialException;
import exceptions.sinTipoPrendaException;
import exceptions.tipoYCategoriaSeCondicenException;

public class Borrador {
  private String tipoPrenda;
  private Categoria categoria;
  private String material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama;
  private Integer temperaturaLimite;

  public Borrador(String tipoPrenda) {
    this.tipoPrenda = tipoPrenda;
    this.trama = Trama.LISA;
    this.temperaturaLimite = 25;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public void setColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = colorPrincipal;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTrama(Trama trama) {
    this.trama = trama;
  }

  public void setTemperaturaLimite(Integer temperaturaLimite) {
    this.temperaturaLimite = temperaturaLimite;
  }

  public Prenda construirPrenda() {
    this.validarTipo();
    this.validarCategoria();
    this.validarMaterial();
    this.validarColor();
    return new Prenda(tipoPrenda, categoria, material, colorPrincipal, colorSecundario, trama, temperaturaLimite);
  }

  public void validarTipo() {
    if (this.tipoPrenda == null) {
      throw new sinTipoPrendaException();
    }
  }

  public void validarCategoria() {
    if (!Sistema.getInstance().sonTipoYCategoriaValidos(this.tipoPrenda, this.categoria)) {
      throw new tipoYCategoriaSeCondicenException();
    }
  }

  public void validarMaterial() {
    if (this.material == null) {
      throw new sinMaterialException();
    }
  }

  public void validarColor() {
    if (this.colorPrincipal == null) {
      throw new sinColorPrincipalException();
    }
  }
}
