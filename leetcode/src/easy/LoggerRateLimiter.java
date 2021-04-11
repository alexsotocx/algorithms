package easy;

import java.util.HashMap;

class Logger {

  private HashMap<String, Integer> wordBlockedUntil;

  /**
   * Initialize your data structure here.
   */
  public Logger() {
    wordBlockedUntil = new HashMap<String, Integer>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   * If this method returns false, the message will not be printed.
   * The timestamp is in seconds granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    int lastTime = wordBlockedUntil.getOrDefault(message, 0);
    if (lastTime <= timestamp) {
      wordBlockedUntil.put(message, timestamp + 10);
      return true;
    }
    return false;
  }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
