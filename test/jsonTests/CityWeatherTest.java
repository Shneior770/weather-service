package jsonTests;

import com.fasterxml.jackson.databind.JsonNode;
import models.CityWeatherVO;
import org.junit.Test;
import play.libs.Json;

public class CityWeatherTest {

    @Test
    public void convertObjectToJson(){
        CityWeatherVO weather = new CityWeatherVO();
        JsonNode jsonNode = Json.toJson(weather);
        System.out.println(jsonNode);
    }

    @Test
    public void convertJsonToObject(){
        String str = "{\"name\":\"london\", \"the_temp\":\"sunny\", \"woid\":\"64676\",\"lastName\":\"aizen\"}";

        JsonNode json = Json.parse("{\"name\":\"london\", \"the_temp\":\"sunny\", \"woid\":\"64676\",\"lastName\":\"aizen\"}");

        CityWeatherVO cityWeatherVO = Json.fromJson(json, CityWeatherVO.class);

        System.out.println(cityWeatherVO.getTemperature());
    }

}
