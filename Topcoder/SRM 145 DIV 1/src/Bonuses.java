import java.util.*;

public class Bonuses {
	
	public int[] getDivision(int[] points) {
		int total = 0;
    Set<Float> queue = new TreeSet<Float>();
		for(int i : points) {
		  total += i;
    }
    int percentage = 100;
    float[] res = new float[points.length];
    int maxCount = 0;
    int max = -1;
    for(int i = 0; i < points.length; i++) {
      int point = points[i];
      float actualPercentage = (float) (point * 100.0 / total);
      percentage -= (int) actualPercentage;
      res[i] = actualPercentage;

      if(queue.isEmpty() || max < actualPercentage) {
        maxCount = 1;
        max = (int) actualPercentage;
      } else if (max == (int) actualPercentage){
        maxCount++;
      }
      queue.add(-actualPercentage);
    }
    if(maxCount <= percentage) {
        for(float x2: queue) {
          x2 *= -1;
          for(int i = 0; i < points.length && percentage > 0; i++) {
            if(res[i] == x2) {
              res[i] += 1;
              percentage--;
            }

          }
        }

    } else {
      for(int i = 0;i<percentage; i++) {
        res[i] += 1;
      }
    }
    int[] res2 = new int[res.length];
    for(int i= 0;i<res2.length; i++){
      res2[i] = (int)res[i];
    }
    return res2;
	}


}
