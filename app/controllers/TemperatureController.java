package controllers;

import models.CityWeatherVO;
import play.mvc.*;
import services.DoubleFormatter;
import services.StringFormatter;
import services.WeatherService;
import views.html.temperature.*;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TemperatureController extends Controller {

  private WeatherService weatherService;
  private DoubleFormatter doubleFormatter;
  private StringFormatter stringFormatter;

  @Inject
  public TemperatureController(WeatherService weatherService, DoubleFormatter doubleFormatter, StringFormatter stringFormatter) {
      this.weatherService = weatherService;
      this.doubleFormatter = doubleFormatter;
      this.stringFormatter = stringFormatter;
  }

    public Result getWeather() throws ExecutionException, InterruptedException  {
        String cityName = request().getQueryString("cityName");
        List<CityWeatherVO> sixDaysTemperature = weatherService.getSixDaysForecast(cityName);

        if (sixDaysTemperature == null) {
            return ok(cityNotFound.render(cityName));
        }

        return ok(getWeather.render(cityName, sixDaysTemperature, doubleFormatter, stringFormatter));
    }

    public Result search() {
        return ok(searchCity.render());
    }

}
