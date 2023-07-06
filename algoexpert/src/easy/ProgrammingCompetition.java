package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ProgrammingCompetition {
  HashMap<String, Team> mapNamePosition = new HashMap<>();
  static final int HOME_WINS = 1;

  class Team {
    int points;
    String name;

    Team(int points, String name) {
      this.name = name;
      this.points = points;
    }
  }

  private Team createAndGetTeam(String teamName) {
    return this.mapNamePosition.compute(teamName, (k, v) -> {
      if (v == null) {
        return new Team(0, k);
      }
      return v;
    });
  }

  public String tournamentWinner(
    ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    this.mapNamePosition = new HashMap<>();
    Team bestTeam = new Team(0, "");
    for(int i = 0; i < results.size(); i++) {
      ArrayList<String> competitors = competitions.get(i);
      Team competitor1 = createAndGetTeam(competitors.get(0));
      Team competitor2 = createAndGetTeam(competitors.get(1));

      Team winningTeam = results.get(i) == HOME_WINS ? competitor1 : competitor2;

      winningTeam.points += 3;
      if (winningTeam.points > bestTeam.points) bestTeam = winningTeam;
    }

    return bestTeam.name;
  }
}
