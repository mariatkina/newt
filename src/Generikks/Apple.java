package Generikks;

public class Apple extends Fruit{
    private final String name = "APPLE";
    private final float weight = 1.0f;

    public Apple() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "1 " + name.toLowerCase() + ", weight: " + weight;
    }
}
