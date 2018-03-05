package services;

import com.google.inject.Inject;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class MetaWeatherApi implements WeatherApi {

    private static final String META_WEATHER_BY_CITY_NAME_URL = "https://www.metaweather.com/api/location/search/";
    private static final String META_WEATHER_BY_LOCATION_ID_URL_FORMAT = "https://www.metaweather.com/api/location/%s";
    private final WSClient wsClient;


    @Inject
    public MetaWeatherApi(WSClient wsClient) {
        this.wsClient = wsClient;
    }

    public WSResponse getCityMetadata(String cityName) throws InterruptedException, ExecutionException {
        // prepare the request
        WSRequest request = wsClient.url(META_WEATHER_BY_CITY_NAME_URL).setQueryParameter("query", cityName);
        // sends the request and promise for getting a response (in aSync)
        CompletionStage<WSResponse> completionStage = request.get();
        WSResponse response = completionStage.toCompletableFuture().get();

        return response;
    }

    public WSResponse getForecastForCity(String cityId) throws ExecutionException, InterruptedException {
        final String locationUrl = String.format(META_WEATHER_BY_LOCATION_ID_URL_FORMAT, cityId);
        WSRequest request = wsClient.url(locationUrl);// prepare the request
        // promise for getting a response (in aSync)
        CompletionStage <WSResponse> completionStage = request.get();
        WSResponse response = completionStage.toCompletableFuture().get();// get the response now.

        return response;
    }
}
