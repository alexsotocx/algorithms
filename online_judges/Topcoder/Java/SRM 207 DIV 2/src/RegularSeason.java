import java.util.Arrays;

public class RegularSeason {
  public Team[] teamsS;
  public String[] finalStandings(String[] teams, int rounds) {

     teamsS = new Team[teams.length];
    for(int i = 0; i < teams.length; i++) {
      teamsS[i] = new Team(teams[i], i);
    }
    for(Team team: teamsS)
      team.calculateProbability(rounds);
    Arrays.sort(teamsS);

    String ans[] = new String[teams.length];
    for(int i = teamsS.length - 1, j = 0; i >= 0; i--, j++) {
      ans[j] = teamsS[i].name + " " + teamsS[i].wonMatches;
    }
    //System.out.println(Arrays.toString(ans));
    return ans;
  }

  public class Team implements Comparable<Team> {
    String name;
    int[] probability;
    int wonMatches = 0;
    double noRoundProbability = 0.0;
    int index;

    Team(String teamDefinition, int index) {
      this.index = index;
      String team[] = teamDefinition.split("\\s");
      this.name = team[0];
      this.probability = new int[team.length - 1];
      for(int i = 1; i< team.length; i++)
        this.probability[i - 1] = Integer.parseInt(team[i]);
    }

    void calculateProbability(int rounds) {
      double probability = 0.0;
      for(int i = 0; i < this.probability.length; i++) {
        probability += rounds * this.probability[i];
        if(index != i)
          probability += rounds * (100-teamsS[i].probability[index]);
      }
      probability = probability / 100.0;
      this.wonMatches = (int) (probability + 0.5);
      this.noRoundProbability = probability;
    }

    public int compareTo(Team o) {
      if(o.wonMatches != this.wonMatches) {
        return Integer.compare(this.wonMatches, o.wonMatches);
      } else if(this.noRoundProbability != o.noRoundProbability) {
        return Double.compare(this.noRoundProbability, o.noRoundProbability);
      } else {
        return -1*this.name.compareTo(o.name);
      }
    }
  }
}
