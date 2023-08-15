package Chpnship;

public class Membr{
    private String mbrName;
    private int mbrAge;
    private int longRunTime;
    private int shortRunTime;
    private int jumpLenth;
    private int swimTime;

    public Membr(String mbrName, int mbrAge, int longRunTime, int shortRunTime, int jumpLenth, int swimTime) {
        this.mbrName = mbrName;
        this.mbrAge = mbrAge;
        this.longRunTime = longRunTime;
        this.shortRunTime = shortRunTime;
        this.jumpLenth = jumpLenth;
        this.swimTime = swimTime;
    }

    public String getMbrName() {
        return mbrName;
    }

    public int getMbrAge() {
        return mbrAge;
    }

    public int getLongRunTime() {
        return longRunTime;
    }

    public int getShortRunTime() {
        return shortRunTime;
    }

    public int getJumpLenth() {
        return jumpLenth;
    }

    public int getSwimTime() {
        return swimTime;
    }

    @Override
    public String toString() {
        return "Name: '" + mbrName + '\'' +
                ", Age: " + mbrAge +
                ", long distance time = " + longRunTime +
                "s, short distance time = " + shortRunTime +
                "s, lenth of jump = " + jumpLenth +
                "sm, swim time = " + swimTime +
                "s\n";
    }
}