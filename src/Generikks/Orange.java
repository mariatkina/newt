package Generikks;

public class Orange extends Fruit{
    private final String name = "ORANGE";
    private final float weight = 1.5f;

    public Orange() {
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
