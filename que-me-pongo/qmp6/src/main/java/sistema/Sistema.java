package sistema;

import servicios.MailSender;
import servicios.ServicioClima;
import usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
  private List<Usuario> usuariosRegistrados = new ArrayList<Usuario>();
  private List<String> ultimasAlertas = new ArrayList<String>();
  private ServicioClima servicioClima;

  public void registrarUsuario(Usuario usuario) {
    usuariosRegistrados.add(usuario);
  }

  public void actualizarAlertas() {
    ultimasAlertas = servicioClima.getAlertas();
    usuariosRegistrados.forEach(usuario -> {usuario.notificarAlerta(ultimasAlertas);});
  }

  public void sugerenciaDiaria() {
    usuariosRegistrados.forEach(usuario -> {usuario.recibirSugerenciaDiaria(ultimasAlertas);});
  }
}
