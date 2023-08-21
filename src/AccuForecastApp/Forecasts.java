package AccuForecastApp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Forecasts {
    static String apiKey = "VwFgzAlGAhvixrTNPWkSvwRDNltZVnQU";
    static ObjectMapper objectMapper = new ObjectMapper();

    //1-day forecast:
    public WeatherClasses oneDayForecast(OkHttpClient ohc)throws IOException, SQLException {
        String[] city = getCityKey(ohc);
        String cityName = city[0];
        String cityKey = city[1];
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("language", "en-us")
                .addQueryParameter("details", "false")
                .build();
        Request cityReq = new Request.Builder()
                .url(url)
                .build();
        Response cityResp = ohc.newCall(cityReq).execute();
        String oneDayWeather = cityResp.body().string();
        WeatherClasses weather = objectMapper.readValue(oneDayWeather, WeatherClasses.class);
        writeToDB(weather, cityName);
        System.out.println("In the city "+cityName +":");
        return weather;
    }

    //5-day forecast:
    public WeatherClasses fiveDayForecast(OkHttpClient ohc)throws IOException, SQLException {
        String[] city = getCityKey(ohc);
        String cityName = city[0];
        String cityKey = city[1];
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("language", "en-us")
                .addQueryParameter("details", "false")
                .build();
        Request cityReq = new Request.Builder()
                .url(url)
                .build();
        Response cityResp = ohc.newCall(cityReq).execute();
        String fiveDayWeather = cityResp.body().string();
        WeatherClasses weather = objectMapper.readValue(fiveDayWeather, WeatherClasses.class);
        writeToDB(weather, cityName);
        System.out.println("In the city "+cityName +":");
        return weather;
    }

    //write data to DB:
    public static void writeToDB(WeatherClasses weather, String city)throws SQLException{
        try {Class.forName("org.sqlite.JDBC");
        }catch (ClassNotFoundException e){
            e.printStackTrace();}
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/history.db");
             Statement statement = connection.createStatement()){
            //create new table:
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS history (id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "city TEXT NOT NULL, date TEXT NOT NULL, weather TEXT NOT NULL, temperature TEXT NOT NULL);");

            try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO history (city, date, weather, temperature) VALUES (?,?,?,?)")) {
                for (int i = 0; i < weather.getDailyForecasts().size(); i++) {
                    int x = (weather.getDailyForecasts().get(i).getTemperature().getMaximum().getValue());
                    preparedStatement.setString(4, String.valueOf(x));
                    preparedStatement.setString(1, city);
                    preparedStatement.setString(2, weather.getDailyForecasts().get(i).getDate());
                    preparedStatement.setString(3, weather.getDailyForecasts().get(i).getDay().getText());
                    preparedStatement.addBatch();}
                preparedStatement.executeBatch();}
        }
    }

    //reading from DB method:
    public void readFromDB()throws SQLException{
        try {Class.forName("org.sqlite.JDBC");
        }catch (ClassNotFoundException e){
            e.printStackTrace();}
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/history.db");
             Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery("SELECT * FROM history");

                ArrayList<ReadWeath> arrayList = new ArrayList<>();
                System.out.println("-----------------------------------------------");
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getString(1) + " || " +
                                    resultSet.getString(2) + " || " +
                                    resultSet.getString(3) + " || " +
                                    resultSet.getString(4) + " || " +
                                    resultSet.getInt(5) + " C;"
                    );
                    arrayList.add(new ReadWeath(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3), resultSet.getString(4)));
                }
                System.out.println("-----------------------------------------------");
        }
    }

    // clear table
    public void deleteFromDB()throws SQLException{
        try {Class.forName("org.sqlite.JDBC");
        }catch (ClassNotFoundException e){
            e.printStackTrace();}
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/history.db");
             Statement statement = connection.createStatement()){
                statement.executeUpdate("DELETE FROM history;");
                statement.executeUpdate("UPDATE SQLITE_SEQUENCE SET seq = 0 WHERE name = 'history';");
                statement.executeUpdate("VACUUM;");

            }
        }

    //inner method to get cityKey for using in forecast:
    public static String [] getCityKey(OkHttpClient okHttpClient) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city name in english:");
        String enterCity = scanner.nextLine();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("q", enterCity)
                .addQueryParameter("language", "en-us")
                .addQueryParameter("details", "false")
                .build();
        Request cityReq = new Request.Builder()
                .url(url)
                .build();
        Response cityResp = okHttpClient.newCall(cityReq).execute();
        String cityKey = cityResp.body().string();
        ObjectMapper om = new ObjectMapper();
        List<City> cityList = om.readValue(cityKey, new TypeReference<List<City>>() {
        });
        String []cityAndKey = String.valueOf(cityList.get(0)).split(",");
        return cityAndKey;
    }
}
//class for reading DB:
class ReadWeath{
    private String city;
    private String date;
    private String weather;
    private String temperature;

    public ReadWeath(String city, String date, String weather, String temperature) {
        this.city = city;
        this.date = date;
        this.weather = weather;
        this.temperature = temperature;
    }
}
