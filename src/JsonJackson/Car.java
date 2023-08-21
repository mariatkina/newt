package JsonJackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {
    private String color;
    @JsonIgnore
    private String year;
    @JsonProperty(value = "type")

    private String model;

    public Car(String color, String year, String model) {
        this.color = color;
        this.year = year;
        this.model = model;
    }

    public Car() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", year='" + year + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
class MnApp{
    public static void main(String[] args) throws IOException {
        String carsList = "[{\"color\":\"red\", \"type\":\"BMW\"}," +
                " {\"color\":\"black\", \"type\":\"lada priora\"}]";

        ObjectMapper om = new ObjectMapper();
        List<Car>list = om.readValue(carsList, new TypeReference<List<Car>>(){});
        //Car car = om.readValue(new File("src/resources/car.json"), Car.class);
        System.out.println(list);


    }

}
