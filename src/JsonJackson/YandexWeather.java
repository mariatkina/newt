package JsonJackson;

import com.fasterxml.jackson.annotation.*;
import java.util.Arrays;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class YandexWeather {

    private Forecast forecast;

    public YandexWeather() {
    }

    public YandexWeather( Forecast forecast) {

        this.forecast = forecast;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "date",
        "parts"})
class Forecast{
    private String date;
    private List<Parts> parts;

    public Forecast() {
    }
    public Forecast(String date, List<Parts> parts) {
        this.date = date;

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
    @JsonProperty("parts")
    public List<Parts> getParts() {
        return parts;
    }
    @JsonProperty("parts")
    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Прогноз на дату: " + date +",\n");
        for (int i = 0; i < parts.size(); i++) {
            sb.append(parts.get(i));
            if (i != parts.size() - 1) {
                sb.append(",\n");
            }
        }
        sb.append("");
        return sb.toString();

    }
}
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "part_name",
        "temp_avg",
        "condition"
})
class Parts{
    private String part_name;
    private double temp_avg;
    private String condition;

    public Parts() {
    }
    public Parts(String part_name, double temp_avg, String condition) {
        this.part_name = part_name;
        this.temp_avg = temp_avg;
        this.condition = condition;
    }
    @JsonProperty("part_name")
    public String getPart_name() {
        return part_name;
    }
    @JsonProperty("part_name")
    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }
    @JsonProperty("temp_avg")
    public double getTemp_avg() {
        return temp_avg;
    }
    @JsonProperty("temp_avg")
    public void setTemp_avg(double temp_avg) {
        this.temp_avg = temp_avg;
    }
    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }
    @JsonProperty("condition")
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "время суток: " + part_name + '\'' +
                ", средняя температура - " + temp_avg +
                ", погода: " + condition;
    }
}
