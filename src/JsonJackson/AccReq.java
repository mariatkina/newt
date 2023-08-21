package JsonJackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//погода в городе
public class AccReq {
    public static void main(String[] args) throws IOException {
        String gelendzhik = "1-288685_1_AL";
        String apikey = "VwFgzAlGAhvixrTNPWkSvwRDNltZVnQU";

        OkHttpClient ohc = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://dataservice.accuweather.com/currentconditions/v1/"+gelendzhik).newBuilder();
        urlBuilder.addQueryParameter("apikey", apikey);
        urlBuilder.addQueryParameter("language", "en");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = ohc.newCall(request).execute();

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String s = response.body().string();
            List<Weather> weather = objectMapper.readValue(s, new TypeReference<List<Weather>>() {});
            System.out.print("In the city of "+"Gelendzhik");
            for(int i=0;i<weather.size();i++){
                System.out.println(weather.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
