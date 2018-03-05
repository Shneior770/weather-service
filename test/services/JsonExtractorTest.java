package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.CityWeatherVO;
import org.junit.Test;
import play.libs.Json;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class JsonExtractorTest {

    @Test
    public void whenPassingValidJsonNode_extractCityId_shouldExtractTheCityId() {
        // prepare
        JsonExtractor extractor = new JsonExtractor();
        String id = "\"11111\"";
        String mockedJsonStr = "{\"woeid\":\"11111\"}";
        JsonNode jsonNode = Json.parse(mockedJsonStr);
        // act
        String extractedId =  extractor.extractCityId(jsonNode);
        // assert
        assertEquals(id,extractedId);
    }


    @Test (expected = NullPointerException.class)
    public void whenPassingNullJsonNode_extractCityId_shouldThrowNullPointerException() {
        JsonExtractor extractor = new JsonExtractor();
        // act
        extractor.extractCityId(null);
    }

    @Test
    public void whenPassingNotValidCityName_extractCityId_shouldReturnNull() {
        // prepare
        JsonExtractor extractor = new JsonExtractor();
        String mockedJsonStr = "{\"shneior\":\"11111\"}";
        JsonNode jsonNode = Json.parse(mockedJsonStr);
        // act
        String exepted = extractor.extractCityId(jsonNode);
        // assert
        assertNull(exepted);
    }

    @Test
    public void whenPassingValidJsonNode_extractForecast_shouldReturnTheVOListWithForecastFor6Days() throws IOException {
        // prepare
        List<CityWeatherVO> expectedForecast = SixDaysFoerecastHelper.getSixDaysForecast();
        JsonExtractor jsonExtractor = new JsonExtractor();
        JsonNode jsonWeather = FilesLoader.loadFileAsJson("test/jsonWeather.txt");
        // act
        List<CityWeatherVO> cityWeatherActual = jsonExtractor.extractForecast(jsonWeather);
        // assert
        assertThat(expectedForecast, is(cityWeatherActual));
    }

    @Test (expected = JsonExtractorException.class)
    public void whenPassingNotValidJsonNode_extractForecast_shouldThrowJsonExtractorException() {
        // prepare
        JsonNode jsonNode = Json.parse("{\"shneior\":\"11111\"}");
        JsonExtractor jsonExtractor = new JsonExtractor();
        // act
        jsonExtractor.extractForecast(jsonNode);
    }

    @Test (expected = NullPointerException.class)
    public void passingNullJsonNode_extractForecast_shouldThrowNullPointerException() {
        // prepare
        JsonExtractor jsonExtractor = new JsonExtractor();
        // act
        jsonExtractor.extractForecast(null);
    }




}
