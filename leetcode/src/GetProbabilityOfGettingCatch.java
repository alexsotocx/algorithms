public class GetProbabilityOfGettingCatch {
  int rows, columns;
  final double horizontalProbability = 0.9;
  final double verticalProbability = 0.45;

  GetProbabilityOfGettingCatch(int m, int n) {
    rows = m;
    columns = n;
  }

  double findProbabilityOfNotGettingCatch(int[] path) {
    double probability = 1.0;
    for (int i = 1; i < path.length; i++) {
      int last = path[i - 1];
      int current = path[i];
      int lastRow = findRow(last);
      int rowCurrent = findRow(current);
      double pGettingCatch = horizontalProbability / Math.pow(2, lastRow);
      if (lastRow != rowCurrent) {
        pGettingCatch = verticalProbability / Math.pow(2, Math.min(lastRow, rowCurrent));
      }
      probability *= (1 - pGettingCatch);
    }
    return probability;
  }


  int findRow(int id) {
    return id / columns;
  }
}
