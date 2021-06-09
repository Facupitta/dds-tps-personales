package usuarios.alertaObservers;

import usuarios.Usuario;

import java.util.List;

public interface AlertaObserver {
  public void recibirAlerta(List<String> alertas, Usuario usuario);
}
