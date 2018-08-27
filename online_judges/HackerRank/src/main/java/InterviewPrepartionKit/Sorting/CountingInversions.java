package InterviewPrepartionKit.Sorting;

public class CountingInversions {
  int[] temp, actualA;

  // Complete the countInversions function below.
  long merge(int lo, int mid, int hi) {
    int i = lo, j = mid + 1, k = 0;
    long inv = 0;
    while (i <= mid || j <= hi) {
      if (i <= mid && j <= hi) {
        if (actualA[i] <= actualA[j])
          temp[k++] = actualA[i++];
        else {
          inv += mid - i + 1;
          temp[k++] = actualA[j++];
        }
      } else if (i <= mid)
        temp[k++] = actualA[i++];
      else
        temp[k++] = actualA[j++];
    }

    for (k = 0; k + lo <= hi; k++) {
      actualA[lo + k] = temp[k];
    }
    return inv;
  }

  long mergeSort(int lo, int hi) {
    if (lo >= hi) return 0;
    int mid = (lo + hi) / 2;
    return mergeSort(lo, mid) + mergeSort(mid + 1, hi) + merge(lo, mid, hi);
  }

  long countInversions(int[] arr) {
    int n = arr.length;
    temp = new int[n];
    actualA = arr;
    return mergeSort(0, n - 1);
  }
}
