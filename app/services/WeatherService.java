package services;


import models.CityWeatherVO;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface WeatherService {
    List<CityWeatherVO> getSixDaysForecast(String cityName) throws ExecutionException, InterruptedException;
}
