package controllers;

import models.CityWeatherVO;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.twirl.api.Html;
import services.SixDaysFoerecastHelper;
import views.html.temperature.*;
import static org.junit.Assert.*;
import play.test.Helpers;
import services.DoubleFormatter;
import services.StringFormatter;
import services.WeatherService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import static org.mockito.Mockito.*;

public class TemperatureControllerTest {

    @Test
    public void getWeatherTest_GivenValidCityName_ShouldRenderPageWithExpectedData() throws ExecutionException, InterruptedException {
        // prepare
        // prepare request
        Http.RequestImpl request = new Http.RequestBuilder().uri("?cityName=london").build();
        // prepare fake request context
        Http.Context fakeContext = new Http.Context(request);
        Http.Context.current.set(fakeContext);
        List<CityWeatherVO> forecastList = SixDaysFoerecastHelper.getSixDaysForecast();
        double temperature = 5.9350000000000005;
        double formattedTemp = 5.93;
        WeatherService weatherService = mock(WeatherService.class);
        when(weatherService.getSixDaysForecast("london")).thenReturn(forecastList);
        StringFormatter stringFormatter = mock(StringFormatter.class);
        when(stringFormatter.getCapitalizedName("london")).thenReturn("London");
        DoubleFormatter doubleFormatter = mock(DoubleFormatter.class);
        when(doubleFormatter.formatDoubleWithTwoDigitsAfterPoint(eq(temperature))).thenReturn(formattedTemp);
        Html expectedHtml = getWeather.render("london", forecastList, doubleFormatter, stringFormatter);

        TemperatureController controller = new TemperatureController(weatherService, doubleFormatter, stringFormatter);
        // act
        Result result = controller.getWeather();
        // assert
        assertEquals(200, result.status());
        assertEquals(expectedHtml.toString(), Helpers.contentAsString(result));
    }

    @Test
    public void getWeatherTest_givenNotValidCityName_shouldRender_cityNotFoundPage() throws ExecutionException, InterruptedException {
        // prepare request
        Http.RequestImpl request = new Http.RequestBuilder().uri("?cityName=blabla").build();
        // prepare fake request context
        Http.Context fakeContext = new Http.Context(request);
        Http.Context.current.set(fakeContext);
        WeatherService weatherService = mock(WeatherService.class);
        when(weatherService.getSixDaysForecast("blabla")).thenReturn(null);
        Html expectedHtml = cityNotFound.render("blabla");
        TemperatureController temperatureController = new TemperatureController(weatherService, null, null);
        // act
        Result result = temperatureController.getWeather();
        // assert
        assertEquals(200, result.status());
        assertEquals(expectedHtml.toString(), Helpers.contentAsString(result));
    }

    @Test
    public void searchTest_whenSearchIsExecute_shouldRenderSearchCityPage() {
        // prepare request
        Http.RequestImpl request = new Http.RequestBuilder().build();
        // prepare fake request context
        Http.Context fakeContext = new Http.Context(request);
        Http.Context.current.set(fakeContext);
        Html expectedHtml = searchCity.render();
        TemperatureController temperatureController = new TemperatureController(null, null, null);
        // act
        Result result = temperatureController.search();
        // assert
        assertEquals(200, result.status());
        assertEquals(expectedHtml.toString(), Helpers.contentAsString(result));

    }
}
