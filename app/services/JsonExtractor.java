package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.CityWeatherVO;
import play.libs.Json;
import java.util.ArrayList;
import java.util.List;

public class JsonExtractor {

    public String extractCityId(JsonNode jsonNode) {
            JsonNode node = jsonNode.findValue("woeid");

            if (node == null) {
                return null;
            }

            return node.toString();
    }

    public List<CityWeatherVO> extractForecast(JsonNode jsonNode) throws JsonExtractorException {
        List<CityWeatherVO> weatherList = new ArrayList<>();
        JsonNode jsonArray = jsonNode.withArray("consolidated_weather");

        if (jsonArray.get(0) == null) {
            throw new JsonExtractorException("key \"consolidated_weather\" is not exist!");
        }

        for (JsonNode currentDayForecast : jsonArray) {
            CityWeatherVO cityWeather = Json.fromJson(currentDayForecast, CityWeatherVO.class);
            weatherList.add(cityWeather);
        }

        return weatherList;

    }
}
