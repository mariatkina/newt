package Generikks;

public class Box<T extends Fruit> {
    private T t;
    private int quant;
    static int boxLimit = 60;

    public Box(T t, int quant) {
        this.t = t;
        this.quant = quant;
    }
    public T getT() {
        return t;
    }

    public int getQant() {
        return quant;
    }

    public void setQuant(int quant) {
        if (quant>0 & quant <= boxLimit) {
            this.quant = quant;
        }else {
            System.out.println("Fruits do not fit in the box!");
        }
    }

    public Float getBoxWeight(){
        //System.out.print("The weight of box: ");
        return quant * t.getWeight();
    }

    @Override
    public String toString() {
        return "Box of " + this.t.getName().toLowerCase()+"s" + ", quantity = " + quant;
    }
    public boolean compareBoxes(Box <? extends Fruit> another){
            return this.getBoxWeight() == another.getBoxWeight();
    }
    public void addToBox(Box <T> another, int number){
        System.out.println("Now try to add "+number+" "+this.t.getName().toLowerCase()+"s"+" to the first box, where "+
                +this.getQant() + " of them from the second box, where "+ another.getQant()+"\nThe box limit is 60 items");
        if (this.getQant()+number <= boxLimit && another.getQant()-number>=0){
            this.setQuant(this.getQant()+number);
            another.setQuant(another.getQant()-number);
            System.out.println("Now in the first box "+this.getQant()+" and in the second box "+another.getQant()+" "+this.t.getName().toLowerCase()+"s");
        }else if (this.getQant()+number > boxLimit && another.getQant()-number>=0){
            another.setQuant(another.getQant()-(boxLimit-this.getQant()));
            this.setQuant(boxLimit);
            System.out.println("Now in the first box "+this.getQant()+" and in the second box "+another.getQant()+" "+this.t.getName().toLowerCase()+"s");
        }else if (this.getQant()+number <= boxLimit && another.getQant()-number<0){
            this.setQuant(this.getQant()+another.getQant());
            another.setQuant(0);
            System.out.println("There's lack of fruits in the second box!\nNow in the first box "+this.getQant()+" and in the second box "+another.getQant()+" "+this.t.getName().toLowerCase()+"s");
        }else {
            System.out.println("Try to enter another quantity!");
        }
        System.out.println();
    }
}
