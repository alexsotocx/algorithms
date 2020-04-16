package Month30Challenge.ThirdWeek;

public class ProductOfEverythingExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int wholeMultiplication = 1;
    int zero = -1;
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int x = nums[i];
      if (x != 0) wholeMultiplication *= x;
      else {
        if (zero != -1) { // zero already found the whole product will be 0
          return result;
        }
        zero = i;
      }
      ;
    }
    if (zero != -1) { // One zero found
      result[zero] = wholeMultiplication;
      return result;
    }
    for (int i = 0; i < nums.length; i++) {
      result[i] = wholeMultiplication / nums[i];
    }
    return result;
  }
}
