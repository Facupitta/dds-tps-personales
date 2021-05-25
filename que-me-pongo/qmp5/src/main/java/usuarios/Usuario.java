package usuarios;

import prendas.*;
import servicios.ServicioClimaAccuWeather;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  List<Armario> misArmarios = new ArrayList<Armario>();
  Borrador ultimaPrenda;

  public List<Armario> getMisArmarios() {
    return this.misArmarios;
  }

  public void crearArmarioCompartido(String criterio, List<Usuario> usuariosCompartidos) {
    this.misArmarios.add(new Armario(criterio, usuariosCompartidos));
  }

  public Armario getArmario(String criterio) {
    return getMisArmarios().stream().filter(armario -> armario.getCriterio() == criterio).findFirst().get();
  }

  public void iniciarBorrador(String tipoPrenda) {
    ultimaPrenda = new Borrador(tipoPrenda);
  }

  public Borrador getBorrador() {
    return ultimaPrenda;
  }

  public void cargarBorrador(String criterio) {
    Armario armarioDeCriterio = this.getArmario(criterio);
    armarioDeCriterio.agregarPrenda(ultimaPrenda.construirPrenda());
  }

  public AtuendoCompleto recibirSugerenciaAtuendo(String criterio) {
    Armario armarioDeCriterio = this.getArmario(criterio);
    return armarioDeCriterio.sugerirAtuendo(new ServicioClimaAccuWeather());
  }

  public Uniforme uniformeArmado(Sastre sastre) {
    return sastre.armarUniforme();
  }

  public void proponerAgregarPrenda(Armario armario, Prenda prenda) {
    armario.agregarPropuesta(new PropuestaAgregar(prenda));
  }

  public void proponerQuitarPrenda(Armario armario, Prenda prenda) {
    armario.agregarPropuesta(new PropuestaQuitar(prenda));
  }

  public List<Propuesta> propuestasDelArmario(Armario armario) {
    return armario.getPropuestas();
  }

  public void aceptarPropuestas(Armario armario) {
    this.propuestasDelArmario(armario).forEach(propuesta -> propuesta.efectuarEn(armario));
  }

  public void rechazarPropuestas(Armario armario) {
    this.propuestasDelArmario(armario).clear();
  }

  public void deshacerPropuestaEn(Armario armario, Propuesta propuesta) {
    propuesta.deshacerEn(armario);
  }
}
