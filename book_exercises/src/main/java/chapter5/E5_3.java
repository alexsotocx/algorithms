package chapter5;

public class E5_3 {
  int longestOneSequence(int x){
    int countSinceLastZero = 0, max = 0, posLastZero = 0;
    for(int i = 0; i<= 31; i++){
      if(!checkForBit(i, x)) {
        countSinceLastZero = i - posLastZero;
        posLastZero = i;
      }
      max = Math.max(max, ++countSinceLastZero);
    }
    return max;
  }

  private boolean checkForBit(int i, int x) {
    return ((1 << i) & x) != 0;
  }
}
