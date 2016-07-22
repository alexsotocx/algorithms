public class Time {
	
	public String whatTime(int seconds) {
    StringBuilder time = new StringBuilder();
    int h = seconds / 3600;
    time.append(h).append(':');
    seconds -= h * 3600;
    int m = seconds / 60;
    seconds -= m * 60;
    return time.append(m).append(':').append(seconds).toString();
  }
}
