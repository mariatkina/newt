package AccuForecastApp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherClasses {
    @JsonProperty("Headline")
    private Headline headline;
    @JsonProperty("DailyForecasts")
    private List<DailyForecasts> dailyForecasts;
    public WeatherClasses() {}
    public WeatherClasses(Headline headline, List<DailyForecasts> dailyForecasts) {
        this.headline = headline;
        this.dailyForecasts = dailyForecasts;
    }
    @JsonProperty("Headline")
    public Headline getHeadline() {
        return headline;
    }
    @JsonProperty("Headline")
    public void setHeadline(Headline headline) {
        this.headline = headline;
    }
    @JsonProperty("DailyForecasts")
    public List<DailyForecasts> getDailyForecasts() {
        return dailyForecasts;
    }
    @JsonProperty("DailyForecasts")
    public void setDailyForecasts(List<DailyForecasts> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dailyForecasts.size(); i++) {
            sb.append(dailyForecasts.get(i));
            if (i != dailyForecasts.size() - 1) {
                sb.append(",\n");
            }
        }
        sb.append("\n"+headline+".");
        return sb.toString();
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Headline{
    @JsonProperty("Text")
    private String Text;
    @JsonProperty("EndDate")
    private String EndDate;
    public Headline() {}
    public Headline(String text, String endDate) {
        Text = text;
        EndDate = endDate;
    }
    @JsonProperty("Text")
    public String getText() {
        return Text;
    }
    @JsonProperty("Text")
    public void setText(String text) {
        Text = text;
    }
    @JsonProperty("EndDate")
    public String getEndDate() {
        return EndDate;
    }
    @JsonProperty("EndDate")
    public void setEndDate(String endDate) {
        EndDate = endDate.substring(0, 10);
    }
    @Override
    public String toString() {
        return "" + Text;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class DailyForecasts{
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("Day")
    private Day day;
    public DailyForecasts() {}
    public DailyForecasts(String date, Temperature temperature, Day day) {
        this.date = date;
        this.temperature = temperature;
        this.day = day;
    }
    @JsonProperty("Date")
    public String getDate() {
        return date;
    }
    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date.substring(0, 10);
    }
    @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }
    @JsonProperty("Temperature")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
    @JsonProperty("Day")
    public Day getDay() {
        return day;
    }
    @JsonProperty("Day")
    public void setDay(Day day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "" + date  +  ", " + day + ", " + temperature;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Temperature{
    @JsonProperty("Minimum")
    private Minimum minimum;
    @JsonProperty("Maximum")
    private Maximum maximum;
    public Temperature() {}
    public Temperature(Minimum minimum, Maximum maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
    @JsonProperty("Minimum")
    public Minimum getMinimum() {
        return minimum;
    }
    @JsonProperty("Minimum")
    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }
    @JsonProperty("Maximum")
    public Maximum getMaximum() {
        return maximum;
    }
    @JsonProperty("Maximum")
    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "" + maximum+" C";
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Minimum{
    @JsonProperty("Value")
    private Integer value;
    public Minimum() {}
    public Minimum(Integer value) {this.value = value;}
    @JsonProperty("Value")
    public Integer getValue() {return value;}
    @JsonProperty("Value")
    public void setValue(Integer value) {this.value = Math.round(((value-32) * 5 / 9));}
    @Override
    public String toString() {
        return "" + value;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Maximum{
    @JsonProperty("Value")
    private Integer value;
    public Maximum() {}
    public Maximum(Integer value) {this.value = value;}
    @JsonProperty("Value")
    public Integer getValue() {return value;}
    @JsonProperty("Value")
    public void setValue(Integer value) {this.value = Math.round(((value-32) * 5 / 9));}
    @Override
    public String toString() {
        return "" + value;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Day{
    @JsonProperty("IconPhrase")
    private String text;
    public Day() {}
    public Day(String text) {
        this.text = text;
    }
    @JsonProperty("IconPhrase")
    public String getText() {
        return text;
    }
    @JsonProperty("IconPhrase")
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "" + text;
    }
}

//City
@JsonIgnoreProperties(ignoreUnknown = true)
class City{
    @JsonProperty("LocalizedName")
    private String name;
    @JsonProperty("Key")
    private String key;
    public City() {    }
    public City(String key, String name) {this.key = key; this.name = name;}
    @JsonProperty("LocalizedName")
    public String getName() {return name;}
    @JsonProperty("LocalizedName")
    public void setName(String name) {this.name = name;}
    @JsonProperty("Key")
    public String getKey() {return key;}
    @JsonProperty("Key")
    public void setKey(String key) {this.key = key;}

    @Override
    public String toString() {
        return "" + name +","+ key;
    }
}
