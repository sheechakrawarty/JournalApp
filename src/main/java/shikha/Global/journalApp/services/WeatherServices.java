package shikha.Global.journalApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import shikha.Global.journalApp.ApiResp.Weather;

@Component
public class WeatherServices {
    @Value("${weather.api.key}")
    private String apiKey ;

    private static final String api = "http://api.weatherstack.com/current?access_key=API_KEY&query=city";
    @Autowired
    RestTemplate restTemplate;
    public Weather getWeather(String city){
        String lastApi = api.replace("API_KEY",apiKey).replace("city",city);
        ResponseEntity<Weather> weather = restTemplate.exchange(lastApi, HttpMethod.GET, null, Weather.class);
        Weather body = weather.getBody();
        return body;
    }

}
