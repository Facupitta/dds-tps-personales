package usuarios.alertaObservers;

import servicios.MailSender;
import usuarios.Usuario;

import java.util.List;

public class MailObserver implements AlertaObserver {

  public void recibirAlerta(List<String> alertas, Usuario usuario) {
    String textoAlertas = "El sistema ha notificado las siguientes alertas meteorológicas: \n";
    alertas.stream().forEach(alerta -> {textoAlertas.concat(alerta + ".\n");});
    usuario.getMailSender().send(usuario.getCorreoElectronico(), textoAlertas);
  }
}
