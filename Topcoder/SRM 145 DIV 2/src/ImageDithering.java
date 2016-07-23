
public class ImageDithering {


	public int count(String dithered, String[] screen) {
	  boolean[] set = new boolean[27];

    for(char x : dithered.toCharArray()){
      set[(x - 'A')] = true;
    }
	  int ans = 0;
	  for(int i = 0; i < screen.length; i++) {
      for (int j = 0; j < screen[0].length(); j++) {
        if(set[screen[i].charAt(j)- 'A']) {
          ans++;
        }
      }
    }
    return ans;
	}
}
