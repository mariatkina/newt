package JsonJackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
//deserialization from file
public class YaWeatherApp {
    public static void main(String[] args) throws IOException {
        File file = new File("src/resources/yaWeather.json");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.readValue(new File("src/resources/yaWeather.json"), YandexWeather.class));
}
}
