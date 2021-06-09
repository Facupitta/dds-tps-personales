package usuarios.alertaObservers;

import usuarios.Usuario;

import java.util.List;

public class ReasignarSugerenciaObserver implements AlertaObserver {
  public void recibirAlerta(List<String> alertas, Usuario usuario) {
    usuario.recibirSugerenciaDiaria(alertas);
  }
}
