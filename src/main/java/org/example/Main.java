package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //var url = "https://api.chucknorris.io/jokes/random";

        URL getUrl = new URL("https://api.chucknorris.io/jokes/random");
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();

        //set request method
        connection.setRequestMethod("GET");

        //getting responseCode
        int responseCode = connection.getResponseCode();

        // if responseCode is 200 means we get data successfully
        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonResponseData = new StringBuffer();
            String readLine = null;

            //append response line by line
            while((readLine = in.readLine()) != null){
                jsonResponseData.append(readLine);
            }

            in.close();

            //print result in string format
            System.out.println("JSON string data " + jsonResponseData.toString());
        } else {
            System.out.println(responseCode);
        }


//        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
//        var client = HttpClient.newBuilder().build();
//        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.statusCode());
//        System.out.println(JSON.parse(response.body()));

    }
}