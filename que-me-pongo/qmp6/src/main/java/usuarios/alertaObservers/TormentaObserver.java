package usuarios.alertaObservers;

import usuarios.Usuario;

import java.util.List;

public class TormentaObserver implements AlertaObserver {
  public void recibirAlerta(List<String> alerta, Usuario usuario) {
    if (alerta.contains("STORM")) {
      usuario.getNotificationService().notify("¡Hay tormenta! No te olvides de salir con un paraguas.");
    }
  }
}
