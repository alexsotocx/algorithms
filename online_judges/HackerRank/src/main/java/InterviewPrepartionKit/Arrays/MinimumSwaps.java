package InterviewPrepartionKit.Arrays;

public class MinimumSwaps {
   void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    // Complete the minimumSwaps function below.
    int minimumSwaps(int[] arr) {
      int n = arr.length;
      int pos[] = new int[n + 1];
      for(int i = 0; i < n; i++) pos[arr[i]] = i;
      int count = 0;
      for(int i = 0; i < n; i++) {
        int target = pos[i + 1];
        if(target != i){
          count++;
          pos[i + 1] = i;
          pos[arr[i]] = target;
          swap(arr, i, target);
        }
      }
      return count;

    }
}
