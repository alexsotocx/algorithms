public class LowerOrEqual {
  static int findLowerOrEqual(int[] array, int target) {
    int l = 0;
    int r = array.length - 1;
    int ans = -1;
    while(l <= r) {
      int mid = l + (r - l) / 2;
      if(array[mid] > target) {
        r = mid - 1;
      } else {
        if(ans == -1 || array[mid] > array[ans]) ans = mid;
        l = mid + 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 3, 3, 3, 6, 9, 12, 13, 15, 19};
    System.out.println(findLowerOrEqual(array, 16));
    System.out.println(findLowerOrEqual(array, 4));
    System.out.println(findLowerOrEqual(array, 6));
    System.out.println(findLowerOrEqual(array, 0));
    System.out.println(findLowerOrEqual(array, 1));
    System.out.println(findLowerOrEqual(array, 19));
  }
}
