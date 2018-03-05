package services;

import play.libs.ws.WSResponse;
import java.util.concurrent.ExecutionException;

public interface WeatherApi {
   WSResponse getCityMetadata(String cityName) throws ExecutionException, InterruptedException;
   WSResponse getForecastForCity(String cityId) throws ExecutionException, InterruptedException;


}
