package usuarios;

import prendas.*;
import servicios.ServicioClimaAccuWeather;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  Armario miArmario = new Armario();
  Borrador ultimaPrenda;

  public Armario getMiArmario() {
    return this.miArmario;
  }

  public void iniciarBorrador(String tipoPrenda) {
    ultimaPrenda = new Borrador(tipoPrenda);
  }

  public Borrador getBorrador() {
    return ultimaPrenda;
  }

  public void cargarBorrador() {
    this.miArmario.agregarPrenda(ultimaPrenda.construirPrenda());
  }

  public AtuendoCompleto recibirSugerenciaAtuendo() {
    return this.miArmario.sugerirAtuendo(new ServicioClimaAccuWeather());
  }

  public Uniforme uniformeArmado(Sastre sastre) {
    return sastre.armarUniforme();
  }
}
