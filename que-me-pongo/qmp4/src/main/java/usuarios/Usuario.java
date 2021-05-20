package usuarios;

import prendas.*;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  List<Prenda> misPrendas = new ArrayList<>();
  Borrador ultimaPrenda;

  public Uniforme uniformeArmado(Sastre sastre) {
    return sastre.armarUniforme();
  }

  public AtuendoCompleto recibirSugerenciaAtuendo() {

  }
}
