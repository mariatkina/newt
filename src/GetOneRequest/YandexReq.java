package GetOneRequest;

import okhttp3.*;
import java.io.IOException;

/*Yandex: узнать фактическое значение и прогноз погоды для указанного населенного пункта*/
public class YandexReq {
    public static void main(String[] args) throws IOException {
        String apikey = "e756a66e-5de7-4226-877b-3f817b395b6e";
        //coordinates:
        String lat = "44.568042";
        String lon = "38.085984";

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
        String body = response.body().string();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(body);
    }
}
