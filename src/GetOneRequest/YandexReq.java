package GetOneRequest;

import JsonJackson.YandexWeather;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*Yandex: узнать фактическое значение и прогноз погоды для указанного населенного пункта*/
public class YandexReq {
    public static void main(String[] args) throws IOException {
        File file = new File("src/resources/yaWeather.json");
        writeWethertoFile(file);

    }
    public static String writeWethertoFile(File file)throws IOException {
        //coordinates:
        String lat = "44.57";
        String lon = "38.086";
        String apikey = "e756a66e-5de7-4226-877b-3f817b395b6e";
        OkHttpClient ohc = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("informers")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Yandex-API-Key", apikey)
                .addHeader("lat", lat)
                .addHeader("lon", lon)
                .addHeader("lang", "ru_RU")
                .build();

        Response response = ohc.newCall(request).execute();
        String resBody = response.body().string();
        System.out.println(resBody);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(resBody);
        } catch (IOException e) {
            e.printStackTrace();
        }return resBody;
    }
}
