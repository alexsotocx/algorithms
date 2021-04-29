package medium;

import java.util.ArrayList;
import java.util.HashMap;

class SnapshotArray {
  ArrayList<ArrayList<Integer>> indexChanges;
  ArrayList<HashMap<Integer, Integer>> changesAtSnap;
  HashMap<Integer, Integer> currentSnap = new HashMap<>();

  public SnapshotArray(int length) {
    indexChanges = new ArrayList<>();
    for (int i = 0; i < length; i++) indexChanges.add(new ArrayList<>());
    changesAtSnap = new ArrayList<>();
  }

  public void set(int index, int val) {
    ArrayList<Integer> indexChange = indexChanges.get(index);
    currentSnap.put(index, val);
    int futureSnapId = currentSnapId();
    if (indexChange.isEmpty()) {
      indexChange.add(futureSnapId);
    } else {
      int lastChange = indexChange.get(indexChange.size() - 1);
      if (lastChange != futureSnapId) indexChange.add(futureSnapId);
    }
  }

  public int snap() {
    int snapId = currentSnapId();
    changesAtSnap.add(currentSnap);
    currentSnap = new HashMap<>();
    return snapId;
  }

  public int get(int index, int snap_id) {
    ArrayList<Integer> indexChange = indexChanges.get(index);
    if (indexChange.isEmpty()) return 0;
    int closesSnap = findClosesSnapShot(indexChange, snap_id);
    if (closesSnap > snap_id) return 0;
    return changesAtSnap.get(closesSnap).getOrDefault(index, 0);
  }

  private int findClosesSnapShot(ArrayList<Integer> change, int value) {
    int lo = 0;
    int hi = change.size() - 1;

    if (value <= change.get(lo)) {
      return change.get(lo);
    }
    while (lo <= hi) {
      int mid = (hi + lo) / 2;
      int midVal = change.get(mid);
      if (value < midVal) {
        hi = mid - 1;
      } else if (value > midVal) {
        lo = mid + 1;
      } else {
        return midVal;
      }
    }

    return change.get(hi);

  }

  private int currentSnapId() {
    return changesAtSnap.size();
  }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
