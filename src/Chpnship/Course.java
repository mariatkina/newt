package Chpnship;

public class Course implements Trials{
    private int longRunDist = 500;
    private int shortRunDist = 100;
    private int swimDist = 100;
    private int longRunPass = 90;
    private int shortRunPass = 30;
    private int jumpLengthPass = 30;
    private int swimTimePass = 102;

    public int getLongRunDist() {
        return longRunDist;
    }
    public int getShortRunDist() {
        return shortRunDist;
    }
    public int getSwimDist() {
        return swimDist;
    }
    public int getLongRunPass() {
        return longRunPass;
    }
    public int getShortRunPass() {
        return shortRunPass;
    }
    public int getJumpLengthPass() {
        return jumpLengthPass;
    }
    public int getSwimTimePass() {
        return swimTimePass;
    }

    @Override
    public void longRun(Membr m) {
        System.out.println(m.getMbrName()+" runs for "+getLongRunDist()+"m");
        if (m.getLongRunTime()<=getLongRunPass()){
            System.out.println(m.getMbrName()+" ran the distance in "+m.getLongRunTime()+" s and passed the trial!");
        }else {
            System.out.println(m.getMbrName()+" lost!");
        }
    }
    @Override
    public void shortRun(Membr m) {
        System.out.println(m.getMbrName()+" runs for "+getShortRunDist()+"m");
        if (m.getShortRunTime()<=getShortRunPass()){
            System.out.println(m.getMbrName()+" ran the distance in "+m.getShortRunTime()+" s and passed the trial!");
        }else {
            System.out.println(m.getMbrName()+" lost!");
        }
    }
    @Override
    public void jump(Membr m) {
        System.out.println(m.getMbrName()+" jumps");
        if (m.getJumpLenth()>=getJumpLengthPass()){
            System.out.println(m.getMbrName()+" jump for "+m.getJumpLenth()+" m and passed the trial!");
        }else {
            System.out.println(m.getMbrName()+" lost!");
        }
    }
    @Override
    public void swim(Membr m) {
        System.out.println(m.getMbrName()+" swims for "+getSwimDist()+"m");
        if (m.getSwimTime()<=getSwimTimePass()){
            System.out.println(m.getMbrName()+" swam the distance in "+m.getSwimTime()+" s and passed the trial!");
        }else {
            System.out.println(m.getMbrName()+" lost!");
        }
    }
    public void trialsPass(Team t){
        System.out.println("The team "+t.getTeamName()+" started the competition:");
        for (Membr m : t.getTeam()){
            shortRun(m);
            longRun(m);
            jump(m);
            swim(m);
        }
    }
    public void winners(Team t) {
        String runWinner = new String();
        for (int i=1; i<t.getTeam().length;i++){
            if (t.getTeam()[i-1].getLongRunTime()>t.getTeam()[i].getLongRunTime()){
                runWinner = t.getTeam()[i].getMbrName();
            }
        }System.out.println("Long distance running:\nplace I - "+runWinner);
        System.out.println();
        String shRunWinner = new String();
        for (int i=1; i<t.getTeam().length;i++){
            if (t.getTeam()[i-1].getShortRunTime()>t.getTeam()[i].getShortRunTime()){
                shRunWinner = t.getTeam()[i].getMbrName();
            }
        }System.out.println("Short distance running:\nplace I - "+shRunWinner);
        System.out.println();
        String jumpsWinner = new String();
        for (int i=1; i<t.getTeam().length;i++){
            if (t.getTeam()[i-1].getJumpLenth()<t.getTeam()[i].getJumpLenth()){
                jumpsWinner = t.getTeam()[i].getMbrName();
            }
        }System.out.println("Jumps:\nplace I - "+jumpsWinner);
        System.out.println();
        String swimWinner = new String();
        for (int i=1; i<t.getTeam().length;i++){
            if (t.getTeam()[i-1].getSwimTime()>t.getTeam()[i].getSwimTime()){
                swimWinner = t.getTeam()[i].getMbrName();
            }
        }System.out.println("Swimming:\nplace I - "+swimWinner);
    }
}
