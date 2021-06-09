package usuarios;

import exceptions.noEsDuenioDelArmarioException;
import exceptions.noLeCompartieronElArmarioException;
import prendas.*;
import servicios.MailSender;
import servicios.NotificationService;
import usuarios.alertaObservers.AlertaObserver;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  List<Armario> misArmarios = new ArrayList<Armario>();
  List<Armario> armariosCompartidos = new ArrayList<Armario>();
  Borrador ultimaPrenda;
  AtuendoCompleto sugerenciaDiaria;
  NotificationService notificationService;
  MailSender mailSender;
  List<AlertaObserver> alertaObservers = new ArrayList<AlertaObserver>();
  String correoElectronico;

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public List<Armario> getMisArmarios() {
    return this.misArmarios;
  }

  public NotificationService getNotificationService() {
    return notificationService;
  }

  public MailSender getMailSender() {
    return mailSender;
  }

  public void agregarObserver(AlertaObserver alertaObserver) {
    alertaObservers.add(alertaObserver);
  }

  public void quitarObserver(AlertaObserver alertaObserver) {
    alertaObservers.remove(alertaObserver);
  }

  public void crearArmario(String criterio) {
    this.misArmarios.add(new Armario(criterio));
  }

  public void compartirCon(Usuario usuario, Armario armario) {
    if (!misArmarios.contains(armario)) {
      throw new noEsDuenioDelArmarioException();
    }
    else {
      usuario.obtenerArmarioCompartido(armario);
    }
  }

  public void notificarAlerta(List<String> alertas) {
    alertaObservers.forEach(observer -> observer.recibirAlerta(alertas, this));
  }

  public void obtenerArmarioCompartido(Armario armario) {
    armariosCompartidos.add(armario);
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

  public void recibirSugerenciaDiaria(List<String> ultimasAlertas) {
    //TODO: atuendoDiario = sugerenciaDiaria = 'algun atuendo';
  }

  public Uniforme uniformeArmado(Sastre sastre) {
    return sastre.armarUniforme();
  }

  public void proponerAgregarPrenda(Armario armario, Prenda prenda) {
    if (!armariosCompartidos.contains(armario)) {
      throw new noLeCompartieronElArmarioException();
    }
    else {
      armario.agregarPropuesta(new PropuestaAgregar(prenda));
    }
  }

  public void proponerQuitarPrenda(Armario armario, Prenda prenda) {
    if (!armariosCompartidos.contains(armario)) {
      throw new noLeCompartieronElArmarioException();
    }
    else {
      armario.agregarPropuesta(new PropuestaQuitar(prenda));
    }
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
