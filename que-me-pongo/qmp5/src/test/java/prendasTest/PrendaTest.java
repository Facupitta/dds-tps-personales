package prendasTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import prendas.*;
import usuarios.Usuario;

public class PrendaTest {
  Sistema sistema = Sistema.getInstance();
  Usuario usuarioPrueba = new Usuario();
  @Before
  public void cargarCorrespondencias() {
    sistema.agregarCorrespondencia("Remera mangas largas", Categoria.PARTE_SUPERIOR);
    sistema.agregarCorrespondencia("Remera mangas cortas", Categoria.PARTE_SUPERIOR);
    sistema.agregarCorrespondencia("Camisa", Categoria.PARTE_SUPERIOR);
    sistema.agregarCorrespondencia("Chomba", Categoria.PARTE_SUPERIOR);
    sistema.agregarCorrespondencia("Campera", Categoria.PARTE_SUPERIOR);
    sistema.agregarCorrespondencia("Buzo", Categoria.PARTE_SUPERIOR);

    sistema.agregarCorrespondencia("Pantalon de vestir", Categoria.PARTE_INFERIOR);
    sistema.agregarCorrespondencia("Pantalon largo", Categoria.PARTE_INFERIOR);
    sistema.agregarCorrespondencia("Pantalon corto", Categoria.PARTE_INFERIOR);
    sistema.agregarCorrespondencia("Shorts", Categoria.PARTE_INFERIOR);

    sistema.agregarCorrespondencia("Zapatos", Categoria.CALZADO);
    sistema.agregarCorrespondencia("Zapatillas", Categoria.CALZADO);
    sistema.agregarCorrespondencia("Ojotas", Categoria.CALZADO);
    sistema.agregarCorrespondencia("Pantuflas", Categoria.CALZADO);
  }

  @After
  public void resetearTests() {
    usuarioPrueba.getMiArmario().getMisPrendas().clear();
    sistema.getCorrespondenciasTipoCategoria().clear();
  }

  @Test
  public void sePuedeCargarUnaRemera() {
    usuarioPrueba.iniciarBorrador("Remera manga larga");
    usuarioPrueba.getBorrador().setMaterial("Latex");
    usuarioPrueba.getBorrador().setCategoria(Categoria.PARTE_SUPERIOR);
    usuarioPrueba.getBorrador().setColorPrincipal(new Color(255, 255, 255));
    usuarioPrueba.getBorrador().setTemperaturaLimite(32);

    usuarioPrueba.cargarBorrador();

    assert(usuarioPrueba.getMiArmario().getMisPrendas().size() == 1);
  }

  @Test
  public void teDaUnUniformeValido() {
    Uniforme uniformeSanJuan = usuarioPrueba.uniformeArmado(new SastreSanJuan());
  }
}

