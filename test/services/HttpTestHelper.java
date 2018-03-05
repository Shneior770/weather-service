package services;

import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HttpTestHelper {

    private WSResponse wsResponse;

    public HttpTestHelper( WSResponse wsResponse) {
        this.wsResponse = wsResponse;
    }

    public WSResponse getWsResponse() {
        return this.wsResponse;
    }


    public WSClient getMockedWSClient(String url, WSRequest wsRequest) {
        WSClient wsClient = mock(WSClient.class);
        when(wsClient.url(url)).thenReturn(wsRequest);

        return wsClient;
    }

    private WSRequest getMockedRequest(CompletionStage completionStage) {
        WSRequest wsRequest = mock(WSRequest.class);
        when(wsRequest.get()).thenReturn(completionStage);
        return wsRequest;
    }

    private CompletionStage getMockedComplitionStage(CompletableFuture completableFuture) {
        CompletionStage<WSResponse> cs = (CompletionStage<WSResponse>) mock(CompletionStage.class);
        when(cs.toCompletableFuture()).thenReturn(completableFuture);

        return cs;
    }

    private CompletableFuture getMockedComplitionFuture(WSResponse response) throws ExecutionException, InterruptedException {
        CompletableFuture<WSResponse> cf = (CompletableFuture<WSResponse>) mock(CompletableFuture.class);
        when(cf.get()).thenReturn(response);

        return cf;
    }

    public WSRequest generateMockedRequest() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = getMockedComplitionFuture(wsResponse);
        CompletionStage completionStage = getMockedComplitionStage(completableFuture);

        return getMockedRequest(completionStage);
    }
}
