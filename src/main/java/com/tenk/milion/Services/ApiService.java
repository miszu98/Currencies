package com.tenk.milion.Services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tenk.milion.Models.Currency;
import com.tenk.milion.Repository.ApiRepo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class ApiService {

    private ApiRepo apiRepo;

    public ApiService(ApiRepo apiRepo) {
        this.apiRepo = apiRepo;
    }

    @PostConstruct
    public void fetchData() throws IOException {
        URL url = new URL("http://openexchangerates.org/api/currencies.json");
        URLConnection connection = url.openConnection();
        connection.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) connection.getContent()));
        JsonObject api = root.getAsJsonObject();

        for (String x : api.keySet()) {
            apiRepo.add(new Currency(x, String.valueOf(api.get(x))));
        }
    }

    public List<Currency> getData() {
        return apiRepo.getAll();
    }
}
