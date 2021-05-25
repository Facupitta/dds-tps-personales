package usuarios;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import prendas.AtuendoCompleto;
import prendas.Prenda;
import servicios.ServicioClima;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Armario {
  private List<Prenda> misPrendas = new ArrayList<Prenda>();

  public List<Prenda> getMisPrendas() {
    return this.misPrendas;
  }

  public void agregarPrenda(Prenda nuevaPrenda) {
    misPrendas.add(nuevaPrenda);
  }

  public AtuendoCompleto sugerirAtuendo(ServicioClima servicioClima) {
    Integer temperaturaActual = servicioClima.getTemperatura();
    List<Prenda> prendasAcordes = prendasAcordes(temperaturaActual);

    Prenda superiorSugerida = prendasAcordes.stream().filter(prenda -> prenda.esParteSuperior()).findFirst().get();
    Prenda inferiorSugerida = prendasAcordes.stream().filter(prenda -> prenda.esParteInferior()).findFirst().get();
    Prenda calzadoSugerido = prendasAcordes.stream().filter(prenda -> prenda.esCalzado()).findFirst().get();
    Prenda accesorioSugerido = prendasAcordes.stream().filter(prenda -> prenda.esAccesorio()).findFirst().get();
    return new AtuendoCompleto(superiorSugerida, inferiorSugerida, calzadoSugerido, accesorioSugerido);
  }

  public List<Prenda> prendasAcordes(Integer temperatura) {
    return this.misPrendas.stream().filter(prenda -> prenda.esAptaParaTemperatura(temperatura)).collect(Collectors.toList());
  }
}
