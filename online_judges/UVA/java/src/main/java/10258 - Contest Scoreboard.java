import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class ContestScoreboard10258 {
  public static class Team {
    int id, solProblems, penality;
    int[] triedProblems = new int[10];

    public Team(int id) {
      this.id = id;
    }

    void addSubmission(int problemId, int t, char resolution) {
      if (resolution == 'R' || resolution == 'U' || resolution == 'E') return;
      if (resolution == 'C' && triedProblems[problemId] == -1) return;
      if (resolution == 'C' && triedProblems[problemId] != -1) {
        penality += t + triedProblems[problemId] * 20;
        triedProblems[problemId] = -1;
        solProblems++;
        return;
      }
      if (triedProblems[problemId] != -1)
        triedProblems[problemId]++;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean first = true;
    StringBuilder out = new StringBuilder();
    br.readLine();
    while (n-- > 0) {
      if (!first) out.append('\n');
      first = false;
      String line;
      Team[] teams = new Team[101];
      while ((line = br.readLine()) != null && !line.equals("")) {
        StringTokenizer st = new StringTokenizer(line);
        int tId = Integer.parseInt(st.nextToken());
        int pId = Integer.parseInt(st.nextToken());
        int ti = Integer.parseInt(st.nextToken());
        char r = st.nextToken().charAt(0);
        if (teams[tId] == null) teams[tId] = new Team(tId);
        teams[tId].addSubmission(pId, ti, r);
      }

      Arrays.sort(teams, (o1, o2) -> {
        if (o1 == null && o2 == null) return 0;
        if (o1 == null) return 1;
        if (o2 == null) return -1;
        if (o1.solProblems > o2.solProblems) return -1;
        if (o1.solProblems == o2.solProblems) {
          if (o1.penality == o2.penality) return o1.id - o2.id;
          return o1.penality - o2.penality;
        }
        return 1;
      });
      for (Team team : teams) {
        if (team == null) break;
        out.append(team.id).append(' ').append(team.solProblems).append(' ').append(team.penality).append('\n');
      }
    }
    System.out.print(out);
  }
}