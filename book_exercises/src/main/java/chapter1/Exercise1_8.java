package chapter1;

public class Exercise1_8 {
  private int[][] nmMatrix;

  public Exercise1_8(int[][] nmMatrix) {
    this.nmMatrix = nmMatrix;
  }

  public int[][] replace() {
    boolean row0 = false;
    boolean column0 = false;
    for(int i = 0; i < n(); i++) if(nmMatrix[i][0] == 0)  column0 = true;
    for(int i = 0; i < m(); i++) if(nmMatrix[0][i] == 0)  row0 = true;
    for (int i = 0; i < n(); i++) {
      for (int j = 0; j < m(); j++) {
        if (nmMatrix[i][j] == 0) {
          nmMatrix[i][0] = 0;
          nmMatrix[0][j] = 0;
        }
      }
    }

    replaceHorizontal(1);
    replaceVertical(1);
    if (row0) {
      for (int j = 0; j < m(); j++) nmMatrix[0][j] = 0;
    }
    if (column0) {
      for (int i = 0; i < n(); i++) nmMatrix[i][0] = 0;
    }

    return nmMatrix;
  }

  private int n() {
    return nmMatrix.length;
  }

  private int m() {
    return nmMatrix[0].length;
  }

  private void replaceHorizontal(int start) {
    for (int i = start; i < n(); i++) { // From 1 because we don't want to wipe the full matrix
      if (nmMatrix[i][0] == 0) {
        for (int j = 0; j < m(); j++) {
          nmMatrix[i][j] = 0;
        }
      }
    }
  }

  private void replaceVertical(int start) {
    for (int j = start; j < m(); j++) {
      if (nmMatrix[0][j] == 0) {
        for (int i = 0; i < n(); i++) {
          nmMatrix[i][j] = 0;
        }
      }
    }
  }
}
