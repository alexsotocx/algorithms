import java.util.HashMap;

public class WordFind {

  public String[] findWords(String[] grid, String[] wordList) {
    String[] ans = new String[wordList.length];

    HashMap<String, String> testedWords = new HashMap<String, String>();
    for (int i = 0; i < grid.length; i++) {

      for (int j = 0; j < grid[0].length(); j++) {
        StringBuilder sbH = new StringBuilder();
        StringBuilder sbV = new StringBuilder();
        StringBuilder sbD = new StringBuilder();
        for (int k = j; k < grid[0].length(); k++) {
          sbH.append(grid[i].charAt(k));
          String test = sbH.toString();
          if (!testedWords.containsKey(test)) {
            testedWords.put(test, "" + i + " " + j);
          }
        }
        for (int k = i; k < grid.length; k++) {
          sbV.append(grid[k].charAt(j));
          String test = sbV.toString();
          if (!testedWords.containsKey(test)) {
            testedWords.put(test, "" + i + " " + j);
          }
        }
        for (int k = 0; k + i < grid.length && k + j < grid[0].length(); k++) {
          sbD.append(grid[i + k].charAt(j + k));
          String test = sbD.toString();
          if (!testedWords.containsKey(test)) {
            testedWords.put(test, "" + i + " " + j);
          }
        }
      }
    }
    for (int i = 0; i < wordList.length; i++) {
      String word = wordList[i];
      if (testedWords.containsKey(word)) {
        ans[i] = testedWords.get(word);
      } else {
        ans[i] = "";
      }
    }
    return ans;
  }
}
