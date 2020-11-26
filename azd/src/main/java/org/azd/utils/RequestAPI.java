package org.azd.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

/**
 *  Implements HttpRequest request methods to send GET, POST, PATCH and DELETE request
 *  to Azure DevOps REST API.
 *  @author Harish Karthic
 */
public class RequestAPI {

    private static final String AUTHORIZATION = "Authorization";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     *  Encodes the personal access token to base 64
     * @param token pass the personal access token
     * @return Encoded string of personal access token for basic authentication
     */
    private static String encodePersonalAccessToken(String token) {
        return "Basic " +
                Base64.getEncoder().encodeToString(("" + ":" + token).getBytes());
    }

    /**
     *  Sends a GET request to REST API
     * @param requestUrl pass the request url
     * @return response string from the API
     */
    public static String get(String requestUrl) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl))
                .GET()
                .header("Accept", "application/json")
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }

    /**
     *  Sends a GET request to REST API with basic authentication
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @return response string from the API
     */
    public static String get(String requestUrl, String token) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl))
                .GET()
                .header("Accept", "application/json")
                .setHeader(AUTHORIZATION, encodePersonalAccessToken(token))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }

    /**
     *  Sends a POST request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to post the request
     * @throws IOException throws IO exception
     * @return response string from the API if any
     */
    public static String post(String requestUrl, String token, HashMap<String, Object> body) throws IOException {

        String requestBody = objectMapper.writeValueAsString(body);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-Type", "application/json")
                .setHeader(AUTHORIZATION, encodePersonalAccessToken(token))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }

    /**
     *  Sends a PATCH request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to update the request
     * @throws IOException throws IO exception
     * @return response string from the API if any
     */
    public static String patch(String requestUrl, String token, HashMap<String, Object> body) throws IOException {

        String requestBody = objectMapper.writeValueAsString(body);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl))
                .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-Type", "application/json")
                .setHeader(AUTHORIZATION, encodePersonalAccessToken(token))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }

    /**
     *  Sends a PATCH request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to update the request
     * @throws IOException throws IO exception
     * @return response string from the API if any
     */
    public static String patch(String requestUrl, String token, List<Object> body) throws IOException {

        String requestBody = objectMapper.writeValueAsString(body);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl))
                .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-Type", "application/json")
                .setHeader(AUTHORIZATION, encodePersonalAccessToken(token))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }

    /**
     *  Sends a DELETE request to REST API with basic authentication
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @return response string from the API if any
     */
    public static String delete(String requestUrl, String token) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl))
                .DELETE()
                .setHeader(AUTHORIZATION, encodePersonalAccessToken(token))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }
}
