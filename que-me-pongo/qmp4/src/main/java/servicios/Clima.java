package servicios;

import java.util.List;
import java.util.Map;

public class Clima {
  private AccuWeatherAPI apiClima = new AccuWeatherAPI();
  private List<Map<String, Object>> condicionesClimaticas;

  public Integer getTemperatura() {
    return condicionesClimaticas.get(0).get("Temperature");
  }

  public void actualizarClima() {
    this.condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
  }
}
