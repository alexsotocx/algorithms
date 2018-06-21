import java.util.ArrayList;
import java.util.Collections;

public class MatchMaking {

  private int matchScore(String a, String b) {
    int ans = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == b.charAt(i)) ans++;
    }
    return ans;
  }

  public String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen, String queryWoman) {
    ArrayList<Person> women = new ArrayList<Person>();
    ArrayList<Person> men = new ArrayList<Person>();

    for (int i = 0; i < answersMen.length; i++) {
      women.add(new Person(namesWomen[i], answersWomen[i]));
      men.add(new Person(namesMen[i], answersMen[i]));
    }
    Collections.sort(women);
    Collections.sort(men);
    boolean[] usedMan = new boolean[men.size()];
    for (Person woman : women) {
      int max = -1;
      int bestMatch = -1;
      for (int j = 0; j < men.size(); j++) {
        Person man = men.get(j);
        if (usedMan[j]) continue;
        int score = matchScore(woman.answers, man.answers);
        if (score > max) {
          bestMatch = j;
          max = score;
        }

      }
      usedMan[bestMatch] = true;
      if (woman.name.equals(queryWoman)) {
        return men.get(bestMatch).name;
      }
    }
    return null;
  }

  class Person implements Comparable<Person> {
    String name;
    String answers;

    public Person(String name, String answers) {
      this.name = name;
      this.answers = answers;
    }

    public int compareTo(Person o) {
      return name.compareTo(o.name);
    }
  }
}
