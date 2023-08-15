package Chpnship;

import java.util.Arrays;

public class Team {

    private String teamName;
    private Membr [] team;

    public Team(String teamName, Membr[] team) {
        this.teamName = teamName;
        this.team = team;
    }

    public String getTeamName() {
        return teamName;
    }

    public Membr[] getTeam() {
        return team;
    }

    public Membr[] setTeam(Membr m1, Membr m2, Membr m3, Membr m4) {
        this.team = new Membr[4];
        team[0] = m1;
        team[1] = m2;
        team[2] = m3;
        team[3] = m4;
        return team;
    }

    @Override
    public String toString() {
        return "Team name: " + teamName + '\n' +
                "members:\n" + Arrays.toString(team) +
                '\n';
    }
}
