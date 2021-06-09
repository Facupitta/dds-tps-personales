package servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioClimaAccuWeather implements ServicioClima {
  private AccuWeatherAPI apiClima = new AccuWeatherAPI();
  private List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");

  public Integer getTemperatura() {
    return (Integer) ((HashMap<String, Object>) condicionesClimaticas.get(0).get("Temperature")).get("Value");
  }

  public List<String> getAlertas() {
    return null; //TODO los profes no actualizaron el repositorio con la nueva funcionalidad de AccuWeatherAPI
  }
}