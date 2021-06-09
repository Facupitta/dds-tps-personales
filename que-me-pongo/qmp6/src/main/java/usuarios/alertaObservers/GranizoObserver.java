package usuarios.alertaObservers;

import usuarios.Usuario;

import java.util.List;

public class GranizoObserver implements AlertaObserver {
  public void recibirAlerta(List<String> alertas, Usuario usuario) {
    if (alertas.contains("HAIL")) {
      usuario.getNotificationService().notify("¡Está granizando! Mejor no sacar el auto.");
    }
  }
}
