package JsonJackson;

import com.fasterxml.jackson.annotation.*;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "now",
        "now_dt",
        "info",
        "fact",
        "forecast"})
public class YandexWeather {
    private int now;
    private String now_dt;
    private Info info;
    private Fact fact;
    private Forecast forecast;

    public YandexWeather() {
    }

    public YandexWeather(int now, String now_dt, Info info, Fact fact, Forecast forecast) {
        this.now = now;
        this.now_dt = now_dt;
        this.info = info;
        this.fact = fact;
        this.forecast = forecast;
    }
    @JsonProperty("now")
    public int getNow() {
        return now;
    }
    @JsonProperty("now")
    public void setNow(int now) {
        this.now = now;
    }
    @JsonProperty("now_dt")
    public String getNow_dt() {
        return now_dt;
    }
    @JsonProperty("now_dt")
    public void setNow_dt(String now_dt) {
        this.now_dt = now_dt;
    }
    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }
    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }
    @JsonProperty("fact")
    public Fact getFact() {
        return fact;
    }
    @JsonProperty("fact")
    public void setFact(Fact fact) {
        this.fact = fact;
    }
    @JsonProperty("forecast")
    public Forecast getForecast() {
        return forecast;
    }
    @JsonProperty("forecast")
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "" + forecast;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "lat",
        "lon"})
class Info{

    private String url;
    private float lat;
    private float lon;

    public Info() {
    }
    public Info(String url, float lat, float lon) {
        this.url = url;
        this.lat = lat;
        this.lon = lon;
    }
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }
    @JsonProperty("lat")
    public float getLat() {
        return lat;
    }
    @JsonProperty("lat")
    public void setLat(float lat) {
        this.lat = lat;
    }
    @JsonProperty("lon")
    public float getLon() {
        return lon;
    }
    @JsonProperty("lon")
    public void setLon(float lon) {
        this.lon = lon;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "obs_time",
        "temp",
        "feels_like",
        "icon",
        "condition",
        "wind_speed",
        "wind_dir",
        "pressure_mm",
        "pressure_pa",
        "humidity",
        "daytime",
        "polar",
        "season",
        "wind_gust"})
class Fact{
    private int obs_time;
    private double temp;
    private double feels_like;
    private String icon;
    private String condition;
    private double wind_speed;
    private String wind_dir;
    private double pressure_mm;
    private double pressure_pa;
    private int humidity;
    private String daytime;
    private boolean polar;
    private String season;
    private double wind_gust;

    public Fact() {
    }
    public Fact(int obs_time, double temp, double feels_like, String icon, String condition, double wind_speed, String wind_dir, double pressure_mm, double pressure_pa, int humidity, String daytime, boolean polar, String season, double wind_gust) {
        this.obs_time = obs_time;
        this.temp = temp;
        this.feels_like = feels_like;
        this.icon = icon;
        this.condition = condition;
        this.wind_speed = wind_speed;
        this.wind_dir = wind_dir;
        this.pressure_mm = pressure_mm;
        this.pressure_pa = pressure_pa;
        this.humidity = humidity;
        this.daytime = daytime;
        this.polar = polar;
        this.season = season;
        this.wind_gust = wind_gust;
    }
    @JsonProperty("obs_time")
    public int getObs_time() {
        return obs_time;
    }
    @JsonProperty("obs_time")
    public void setObs_time(int obs_time) {
        this.obs_time = obs_time;
    }
    @JsonProperty("temp")
    public double getTemp() {
        return temp;
    }
    @JsonProperty("temp")
    public void setTemp(double temp) {
        this.temp = temp;
    }
    @JsonProperty("feels_like")
    public double getFeels_like() {
        return feels_like;
    }
    @JsonProperty("feels_like")
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }
    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }
    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }
    @JsonProperty("condition")
    public void setCondition(String condition) {
        this.condition = condition;
    }
    @JsonProperty("wind_speed")
    public double getWind_speed() {
        return wind_speed;
    }
    @JsonProperty("wind_speed")
    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }
    @JsonProperty("wind_dir")
    public String getWind_dir() {
        return wind_dir;
    }
    @JsonProperty("wind_dir")
    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }
    @JsonProperty("pressure_mm")
    public double getPressure_mm() {
        return pressure_mm;
    }
    @JsonProperty("pressure_mm")
    public void setPressure_mm(double pressure_mm) {
        this.pressure_mm = pressure_mm;
    }
    @JsonProperty("pressure_pa")
    public double getPressure_pa() {
        return pressure_pa;
    }
    @JsonProperty("pressure_pa")
    public void setPressure_pa(double pressure_pa) {
        this.pressure_pa = pressure_pa;
    }
    @JsonProperty("humidity")
    public int getHumidity() {
        return humidity;
    }
    @JsonProperty("humidity")
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    @JsonProperty("daytime")
    public String getDaytime() {
        return daytime;
    }
    @JsonProperty("daytime")
    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }
    @JsonProperty("polar")
    public boolean isPolar() {
        return polar;
    }
    @JsonProperty("polar")
    public void setPolar(boolean polar) {
        this.polar = polar;
    }
    @JsonProperty("season")
    public String getSeason() {
        return season;
    }
    @JsonProperty("season")
    public void setSeason(String season) {
        this.season = season;
    }
    @JsonProperty("wind_gust")
    public double getWind_gust() {
        return wind_gust;
    }
    @JsonProperty("wind_gust")
    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "date_ts",
        "week",
        "sunrise",
        "sunset",
        "moon_code",
        "moon_text",
        "parts"})
class Forecast{
    private String date;
    private int date_ts;
    private int week;
    private String sunrise;
    private String sunset;
    private int moon_code;
    private String moon_text;
    private List<Parts> parts;

    public Forecast() {
    }
    public Forecast(String date, int date_ts, int week, String sunrise, String sunset, int moon_code, String moon_text, List<Parts> parts) {
        this.date = date;
        this.date_ts = date_ts;
        this.week = week;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moon_code = moon_code;
        this.moon_text = moon_text;
        this.parts = parts;
    }
    @JsonProperty("date")
    public String getDate() {
        return date;
    }
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }
    @JsonProperty("date_ts")
    public int getDate_ts() {
        return date_ts;
    }
    @JsonProperty("date_ts")
    public void setDate_ts(int date_ts) {
        this.date_ts = date_ts;
    }
    @JsonProperty("week")
    public int getWeek() {
        return week;
    }
    @JsonProperty("week")
    public void setWeek(int week) {
        this.week = week;
    }
    @JsonProperty("sunrise")
    public String getSunrise() {
        return sunrise;
    }
    @JsonProperty("sunrise")
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    @JsonProperty("sunset")
    public String getSunset() {
        return sunset;
    }
    @JsonProperty("sunset")
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    @JsonProperty("moon_code")
    public int getMoon_code() {
        return moon_code;
    }
    @JsonProperty("moon_code")
    public void setMoon_code(int moon_code) {
        this.moon_code = moon_code;
    }
    @JsonProperty("moon_text")
    public String getMoon_text() {
        return moon_text;
    }
    @JsonProperty("moon_text")
    public void setMoon_text(String moon_text) {
        this.moon_text = moon_text;
    }
    @JsonProperty("parts")
    public List<Parts> getParts() {
        return parts;
    }
    @JsonProperty("parts")
    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "part_name",
        "temp_min",
        "temp_avg",
        "temp_max",
        "wind_speed",
        "wind_gust",
        "wind_dir",
        "pressure_mm",
        "pressure_pa",
        "humidity",
        "prec_mm",
        "prec_prob",
        "prec_period",
        "icon",
        "condition",
        "feels_like",
        "daytime",
        "polar"
})
class Parts{
    private String part_name;
    private double temp_min;
    private double temp_avg;
    private double temp_max;
    private double wind_speed;
    private double wind_gust;
    private String wind_dir;
    private double pressure_mm;
    private double pressure_pa;
    private double humidity;
    private int prec_mm;
    private int prec_prob;
    private int prec_period;
    private String icon;
    private String condition;
    private double feels_like;
    private String daytime;
    private boolean polar;

    public Parts() {
    }
    public Parts(String part_name, double temp_min, double temp_avg, double temp_max, double wind_speed, double wind_gust, String wind_dir, double pressure_mm, double pressure_pa, double humidity, int prec_mm, int prec_prob, int prec_period, String icon, String condition, double feels_like, String daytime, boolean polar) {
        this.part_name = part_name;
        this.temp_min = temp_min;
        this.temp_avg = temp_avg;
        this.temp_max = temp_max;
        this.wind_speed = wind_speed;
        this.wind_gust = wind_gust;
        this.wind_dir = wind_dir;
        this.pressure_mm = pressure_mm;
        this.pressure_pa = pressure_pa;
        this.humidity = humidity;
        this.prec_mm = prec_mm;
        this.prec_prob = prec_prob;
        this.prec_period = prec_period;
        this.icon = icon;
        this.condition = condition;
        this.feels_like = feels_like;
        this.daytime = daytime;
        this.polar = polar;
    }
    @JsonProperty("part_name")
    public String getPart_name() {
        return part_name;
    }
    @JsonProperty("part_name")
    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }
    @JsonProperty("temp_min")
    public double getTemp_min() {
        return temp_min;
    }
    @JsonProperty("temp_min")
    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }
    @JsonProperty("temp_avg")
    public double getTemp_avg() {
        return temp_avg;
    }
    @JsonProperty("temp_avg")
    public void setTemp_avg(double temp_avg) {
        this.temp_avg = temp_avg;
    }
    @JsonProperty("temp_max")
    public double getTemp_max() {
        return temp_max;
    }
    @JsonProperty("temp_max")
    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
    @JsonProperty("wind_speed")
    public double getWind_speed() {
        return wind_speed;
    }
    @JsonProperty("wind_speed")
    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }
    @JsonProperty("wind_gust")
    public double getWind_gust() {
        return wind_gust;
    }
    @JsonProperty("wind_gust")
    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }
    @JsonProperty("wind_dir")
    public String getWind_dir() {
        return wind_dir;
    }
    @JsonProperty("wind_dir")
    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }
    @JsonProperty("pressure_mm")
    public double getPressure_mm() {
        return pressure_mm;
    }
    @JsonProperty("pressure_mm")
    public void setPressure_mm(double pressure_mm) {
        this.pressure_mm = pressure_mm;
    }
    @JsonProperty("pressure_pa")
    public double getPressure_pa() {
        return pressure_pa;
    }
    @JsonProperty("pressure_pa")
    public void setPressure_pa(double pressure_pa) {
        this.pressure_pa = pressure_pa;
    }
    @JsonProperty("humidity")
    public double getHumidity() {
        return humidity;
    }
    @JsonProperty("humidity")
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    @JsonProperty("prec_mm")
    public int getPrec_mm() {
        return prec_mm;
    }
    @JsonProperty("prec_mm")
    public void setPrec_mm(int prec_mm) {
        this.prec_mm = prec_mm;
    }
    @JsonProperty("prec_prob")
    public int getPrec_prob() {
        return prec_prob;
    }
    @JsonProperty("prec_prob")
    public void setPrec_prob(int prec_prob) {
        this.prec_prob = prec_prob;
    }
    @JsonProperty("prec_period")
    public int getPrec_period() {
        return prec_period;
    }
    @JsonProperty("prec_period")
    public void setPrec_period(int prec_period) {
        this.prec_period = prec_period;
    }
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }
    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }
    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }
    @JsonProperty("condition")
    public void setCondition(String condition) {
        this.condition = condition;
    }
    @JsonProperty("feels_like")
    public double getFeels_like() {
        return feels_like;
    }
    @JsonProperty("feels_like")
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }
    @JsonProperty("daytime")
    public String getDaytime() {
        return daytime;
    }
    @JsonProperty("daytime")
    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }
    @JsonProperty("polar")
    public boolean isPolar() {
        return polar;
    }
    @JsonProperty("polar")
    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    @Override
    public String toString() {
        return "" + part_name + '\'' +
                ", средн€€ температура - " + temp_avg +
                ", condition='" + condition + '\'' +
                '}';
    }
}
