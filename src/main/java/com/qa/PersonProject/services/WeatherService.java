package com.qa.PersonProject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.PersonProject.entities.WeatherData;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    private static final String API_KEY = "33adea94c161ab497a76d0fdfdbf80d0";
    private static final String API_BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public WeatherService() {
        this.httpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public WeatherData getWeatherData(String city) throws IOException {
        String apiUrl = API_BASE_URL + "?q=" + city + "&appid=" + API_KEY;
        Request request = new Request.Builder().url(apiUrl).build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }

            String responseBody = response.body().string();
            return objectMapper.readValue(responseBody, WeatherData.class);
        }
    }
}
