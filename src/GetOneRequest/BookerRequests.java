package GetOneRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
/*Работа с сервисом RestfulBooker. Проверка работы методов GET, POST, PUT, PATCH, DELETE с использованием библиотеки OkHttp*/
public class BookerRequests {
    public static void main(String[] args) throws IOException {
        OkHttpClient ohc = new OkHttpClient();
        //getToken(ohc);
        String token = "cbed057e5bf693d";
        //postBookng(ohc);
        //getBookingIds(ohc);
        getBookingById(ohc);
        //updateBookng(ohc);
        //partialUpdateBooking(ohc);
        //delBooking(ohc);

    }
    //получение всех id с указанной фамилией:
    public static String getBookingIds(OkHttpClient okHttpClient)throws IOException{
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("restful-booker.herokuapp.com")
                .addPathSegment("booking")
                .addQueryParameter("lastname", "Jackson")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String bookingIds = response.body().string();
        System.out.println(bookingIds);
        return bookingIds;
    }
    //создание новой записи:
    public static String postBookng(OkHttpClient okHttpClient)throws IOException{
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("restful-booker.herokuapp.com")
                .addPathSegment("booking")
                .build();
        String body = "{" +
                "\"firstname\": \"Andrey\", " +
                "\"lastname\": \"Rebrov\", " +
                "\"totalprice\": "+ 1310 +", "+
                "\"depositpaid\": "+ true +", "+
                "\"bookingdates\": "+ "{" +
                "\"checkin\": \"2023-07-23\", " +
                "\"checkout\": \"2023-08-01\"" +
                "}, " +
                "\"additionalneeds\": \"Breakfast\"" +
                "}";
        RequestBody rBody = RequestBody.create(body, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .post(rBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String booking = response.body().string();
        System.out.println(response.code());
        System.out.println(booking);
        return booking;
    }
    //получение запии с указанным Id с десериализацией и выводом имени, фамилии и датой выезда:
    public static BookingClass getBookingById(OkHttpClient okHttpClient)throws IOException{
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://restful-booker.herokuapp.com/booking/41").newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Accept", "application/json")
                .build();
        Response response = okHttpClient.newCall(request).execute();

        String booking = response.body().string();
        ObjectMapper om = new ObjectMapper();
        BookingClass bC = om.readValue(booking, BookingClass.class);
        System.out.println(bC.getFirstname()+"\n"+bC.getLastname()+"\n"+bC.getBookingdates());
        return bC;
    }
    //изменнение записи по Id с передачей всех данных:
    public static String updateBookng(OkHttpClient okHttpClient)throws IOException{
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://restful-booker.herokuapp.com/booking/41").newBuilder();
        String url = urlBuilder.build().toString();
        String body = "{" +
                "\"firstname\": \"John\", " +
                "\"lastname\": \"Smith\", " +
                "\"totalprice\": "+ 1000 +", "+
                "\"depositpaid\": "+ true +", "+
                "\"bookingdates\": "+ "{" +
                "\"checkin\": \"2018-01-01\", " +
                "\"checkout\": \"2019-01-01\"" +
                "}, " +
                "\"additionalneeds\": \"Breakfast\"" +
                "}";
        RequestBody rBody = RequestBody.create(body, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .put(rBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", "token=<cbed057e5bf693d>")
                .addHeader("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String booking = response.body().string();
        System.out.println(response.code());
        System.out.println(booking);
        return booking;
    }
    //изменнение записи по Id с передачей части данных:
    public static String partialUpdateBooking(OkHttpClient okHttpClient)throws IOException{
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://restful-booker.herokuapp.com/booking/1109").newBuilder();
        String url = urlBuilder.build().toString();
        String body = "{" +
                "\"firstname\": \"Judy\", " +
                "\"lastname\": \"Smith\"" +
                "}";
        RequestBody rBody = RequestBody.create(body, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .patch(rBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", "token=<cbed057e5bf693d>")
                .addHeader("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String booking = response.body().string();
        System.out.println(response.code());
        System.out.println(booking);
        return booking;
    }
    //удаление записи по Id:
    public static Integer delBooking(OkHttpClient okHttpClient)throws IOException{
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://restful-booker.herokuapp.com/booking/41").newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "token=<cbed057e5bf693d>")
                .addHeader("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.headers());
        return response.code();
    }
    //получение токена:
    public static String getToken(OkHttpClient okHttpClient) throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("restful-booker.herokuapp.com")
                .addPathSegment("auth")
                .build();
        String body = "{" +
                "\"username\": \"admin\", " +
                "\"password\": \"password123\"" +
                "}";
        RequestBody rBody = RequestBody.create(body, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .post(rBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String token = response.body().string().split(":")[1].replaceAll("[\"}]", "");
        System.out.println(token);
        return (token);
    }
}
