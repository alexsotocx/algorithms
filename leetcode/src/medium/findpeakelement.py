from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        lo = 0
        hi = len(nums) - 1
        while (lo < hi):
            mid = lo + (hi - lo) // 2
            before = nums[mid - 1] if mid - 1 >= 0 else -(1 << 60)
            after = nums[mid + 1] if mid + 1 < len(nums) else -(1 << 60)
            if before < nums[mid] > after:
                return mid
            if before > nums[mid] > after:
                hi = mid - 1
            else:
                lo = mid + 1
        return hi


assert Solution().findPeakElement([1, 2, 3, 1]) in [2]
assert Solution().findPeakElement([1, 2, 3, 4]) in [3]
assert Solution().findPeakElement([1, 2, 3, -1, -2]) in [2]
assert Solution().findPeakElement([1, 2, 3, -1, -2, 3, 0]) in [2, 5]
assert Solution().findPeakElement([0]) in [0]
assert Solution().findPeakElement([-2147483647, -2147483648]) in [0]
