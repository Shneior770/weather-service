package services;

import com.google.inject.Inject;
import models.CityWeatherVO;
import play.libs.ws.WSResponse;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class MetaWeatherService implements WeatherService {

    private final WeatherApi weatherApi;
    private final JsonExtractor jsonExtractor;

    @Inject
    public MetaWeatherService(WeatherApi weatherApi, JsonExtractor jsonExtractor) {
        this.weatherApi = weatherApi;
        this.jsonExtractor = jsonExtractor;
    }

    @Override
    public List<CityWeatherVO> getSixDaysForecast(String cityName) throws ExecutionException , InterruptedException {
        WSResponse  metadata = weatherApi.getCityMetadata(cityName);

        if (!isResponseValid(metadata)) {
            return null;
        }

        String cityId = jsonExtractor.extractCityId(metadata.asJson());
        WSResponse forecastResponse = weatherApi.getForecastForCity(cityId);

        return jsonExtractor.extractForecast(forecastResponse.asJson());
    }

    private boolean isResponseValid(WSResponse response) {

        if (response.getBody().isEmpty() || response.getBody().equals("[]")) {
            return false;
        }

        return true;
    }

}
