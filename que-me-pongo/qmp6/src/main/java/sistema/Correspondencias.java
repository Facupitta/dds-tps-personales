package sistema;

import prendas.Categoria;

import java.util.HashMap;
import java.util.Map;

public class Correspondencias {
  private Map<String, Categoria> correspondenciasTipoCategoria = new HashMap<String, Categoria>();
  private static final Correspondencias INSTANCE = new Correspondencias();

  public static Correspondencias getInstance() {
    return INSTANCE;
  }

  public void agregarCorrespondencia(String tipo, Categoria categoria) {
    correspondenciasTipoCategoria.put(tipo, categoria);
  }

  public Map<String, Categoria> getCorrespondenciasTipoCategoria() {
    return correspondenciasTipoCategoria;
  }

  public boolean sonTipoYCategoriaValidos(String tipo, Categoria categoria) {
    return correspondenciasTipoCategoria.get(tipo) == categoria;
  }


}
