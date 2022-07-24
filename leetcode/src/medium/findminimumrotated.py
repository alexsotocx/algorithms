from typing import List


class Solution:
    def util(self, nums: List[int], lo: int, hi: int) -> int:
        if (lo == hi):
            return nums[hi]
        if (lo > hi):
            return 1 << 20
        mid = lo + (hi - lo) // 2
        best = 1 << 20
        if nums[lo] <= nums[mid]:
            best = min(self.util(nums, mid + 1, hi), nums[lo])

        if nums[mid] <= nums[hi]:
            best = min(self.util(nums, lo, mid - 1), nums[mid])
        
        return best

    def findMin(self, nums: List[int]) -> int:
        return self.util(nums, 0, len(nums) - 1)

assert Solution().findMin([3,4,5,1,2]) == 1
assert Solution().findMin([4,5,6,7,0,1,2]) == 0
assert Solution().findMin([11,13,15,17]) == 11
assert Solution().findMin([13,15,17, 11]) == 11
assert Solution().findMin([17,11, 13,15]) == 11
assert Solution().findMin([15, 17,11, 13]) == 11
assert Solution().findMin([13, 15, 17,11]) == 11
assert Solution().findMin([11]) == 11
        
