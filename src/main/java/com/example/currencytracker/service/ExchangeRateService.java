package com.example.currencytracker.service;

import com.example.currencytracker.dto.ExchangeRateResponse;
import com.example.currencytracker.model.ExchangeRate;
import com.example.currencytracker.repository.ExchangeRateRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;

    @Value("${exchange.api.key}")
    private String apiKey;

    public ExchangeRateResponse  currentExchangeRate(String base, String target){
        String urlString = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", apiKey, base, target);
        //https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/BRL
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if(responseCode==HttpURLConnection.HTTP_OK){
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                    String input;
                    StringBuilder content = new StringBuilder();
                    while ((input=in.readLine()) != null){
                        content.append(input);
                    }
                    ExchangeRateResponse responseObj = mapper.readValue(content.toString(), ExchangeRateResponse.class);
                    return responseObj;
                }
            }
            else{
                ExchangeRateResponse errorResponse = new ExchangeRateResponse();
                errorResponse.setError_message("Error on API:" +responseCode);
                return errorResponse;
            }

        }
        catch (IOException e){
            e.printStackTrace();
            ExchangeRateResponse errorResponse = new ExchangeRateResponse();
            errorResponse.setError_message(e.getMessage());
            return errorResponse;
        }


    }
}
