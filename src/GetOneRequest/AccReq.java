package GetOneRequest;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
//С помощью http запроса получить в виде json строки погоду в своем городе oт accuweather.com
public class AccReq {
    public static void main(String[] args) throws IOException {
        String gelendzhik = "1-288685_1_AL";
        String apikey = "VwFgzAlGAhvixrTNPWkSvwRDNltZVnQU";

        OkHttpClient ohc = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://dataservice.accuweather.com/forecasts/v1/daily/1day/"+gelendzhik).newBuilder();
        urlBuilder.addQueryParameter("apikey", apikey);
        urlBuilder.addQueryParameter("language", "en");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = ohc.newCall(request).execute();
        String body = response.body().string();

        System.out.println(body);
    }
}
