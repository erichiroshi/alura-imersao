package com.erichiroshi.clienteHttp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.erichiroshi.clienteHttp.exceptions.ClienteHttpException;

public class ClienteHttp {
    public static String pegarJsonDaUrl(String url) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
            
        } catch (IOException | InterruptedException | IllegalArgumentException e) {
           throw new ClienteHttpException("Erro ao consultar a URL.");
        }
    }
}
