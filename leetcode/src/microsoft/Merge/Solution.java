package microsoft.Merge;

class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] tmp = new int[n + m];
    int i = 0;
    int j = 0;
    int tmpI = 0;
    for (i = 0; i < m; i++) {
      while (j < n && nums1[i] > nums2[j]) {
        tmp[tmpI++] = nums2[j++];
      }
      tmp[tmpI++] = nums1[i];
    }
    while (j < n) {
      tmp[tmpI++] = nums2[j++];
    }
    for (i = 0; i < n + m; i++) nums1[i] = tmp[i];
  }
}
