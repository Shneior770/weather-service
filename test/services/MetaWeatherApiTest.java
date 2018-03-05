package services;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MetaWeatherApiTest {


    private HttpTestHelper testHelper;
    private WSRequest wsRequest;

    @Before
    public void setUp() throws ExecutionException, InterruptedException {
     this.testHelper = new HttpTestHelper(getMockedResponse());
     this.wsRequest = testHelper.generateMockedRequest();
    }


    @Test
    public void WhenPassingValidCityName_getCityMetadata_shouldReturnValidResponse() throws ExecutionException, InterruptedException, IOException {
        // prepare
        String cityName = "london";
        String url = "https://www.metaweather.com/api/location/search/";
        when(wsRequest.setQueryParameter("query", cityName)).thenReturn(wsRequest);
        WSClient wsClient = testHelper.getMockedWSClient(url, wsRequest);
        MetaWeatherApi metaWeatherApiUnit = new MetaWeatherApi(wsClient);
        WSResponse expectedResponse = testHelper.getWsResponse();
        // act
        WSResponse actualResponse = metaWeatherApiUnit.getCityMetadata(cityName);
        // assert
        assertEquals(expectedResponse, actualResponse);
    }


    @Test
    public void WhenPassingValidCityName_getForecastForCity_shouldReturnValidResponse() throws ExecutionException, InterruptedException, IOException {
        // prepare
        String cityId = "44418";
        String formattedUrl = String.format("https://www.metaweather.com/api/location/%s", cityId);
        WSClient wsClient = testHelper.getMockedWSClient(formattedUrl, wsRequest);
        MetaWeatherApi metaWeatherApiUnit = new MetaWeatherApi(wsClient);
        WSResponse expectedResponse = testHelper.getWsResponse();
        // act
        WSResponse actualResponse = metaWeatherApiUnit.getForecastForCity(cityId);
        // assert
        assertEquals(actualResponse, expectedResponse);
    }

    private WSResponse getMockedResponse() {
        WSResponse response = mock(WSResponse.class);
        return response;
    }
}
