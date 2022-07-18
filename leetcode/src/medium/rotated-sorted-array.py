from typing import List


class Solution:
    def searchI(self, nums: List[int], target: int, lo: int, hi: int) -> int:
        if (lo > hi):
            return -1
        mid = lo + (hi - lo) // 2
        if nums[mid] == target:
            return mid

        increasingLoMid = nums[lo] <= nums[mid]
        increasingMidHi = nums[mid] <= nums[hi]

        if (increasingLoMid and increasingMidHi):
            if target < nums[mid]:
                return self.searchI(nums, target, lo, mid - 1)
            return self.searchI(nums, target, mid + 1, hi)

        if (increasingLoMid):
            if nums[lo] <= target <= nums[mid]:
                return self.searchI(nums, target, lo, mid - 1)
            return self.searchI(nums, target, mid + 1, hi)
        if (increasingMidHi):
            if (nums[mid] <= target <= nums[hi]):
                return self.searchI(nums, target, mid + 1, hi)
            return self.searchI(nums, target, lo, mid - 1)
        return -1

    def search(self, nums: List[int], target: int) -> int:
        return self.searchI(nums, target, 0, len(nums) - 1)

assert Solution().search([4,5,6,7,0,1,2], 0) == 4
assert Solution().search([4,5,6,7,0,1,2], 1) == 5
assert Solution().search([4,5,6,7,0,1,2], 2) == 6
assert Solution().search([4,5,6,7,0,1,2], 4) == 0
assert Solution().search([4,5,6,7,0,1,2], 5) == 1
assert Solution().search([4,5,6,7,0,1,2], 6) == 2
assert Solution().search([4,5,6,7,0,1,2], 7) == 3
assert Solution().search([4,5,6,7,0,1,2], 10) == -1
assert Solution().search([4,5,6,7,0,1,2], -1) == -1