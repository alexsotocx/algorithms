package HackerRank.Arrays;

import java.util.HashMap;

public class NewYearChaos {
  void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Complete the minimumBribes function below.
  void minimumBribes(int[] arr) {
    HashMap<Integer, Integer> pos = new HashMap<>();
    int n = arr.length;
    int[] usedMov = new int[n + 1];
    for (int i = 0; i < n; i++) pos.put(arr[i], i);
    int count = 0;
    boolean caotic = false;
    for (int i = 0; i < n && !caotic; i++) {
      int target = pos.get(i + 1);
      while (target != i) {
        count++;
        int temp = arr[target - 1];
        if (usedMov[temp] == 2) caotic = true;
        usedMov[temp]++;
        pos.put(temp, target);
        pos.put(i + 1, target - 1);
        swap(arr, target, target - 1);
        target--;
      }
    }

    if (caotic) System.out.println("Too chaotic");
    else System.out.println(count);
  }
}


