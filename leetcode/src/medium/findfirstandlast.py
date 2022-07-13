from typing import List


class Solution:
    def lowerBound(self, nums: List[int], target: int) -> int:
        hi, lo = len(nums) - 1, 0
        best = -1
        while hi >= lo:
            mid = lo + (hi - lo) // 2
            if nums[mid] == target:
                best = mid
                hi = mid - 1
            elif nums[mid] > target:
                hi = mid - 1
            else:
                lo = mid + 1
        return best

    def upperBound(self, nums: List[int], target: int) -> int:
        hi, lo = len(nums) - 1, 0
        best = -1
        while hi >= lo:
            mid = lo + (hi - lo) // 2
            if nums[mid] == target:
                best = mid
                lo = mid + 1
            elif nums[mid] > target:
                hi = mid - 1
            else:
                lo = mid + 1
        return best

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.lowerBound(nums, target), self.upperBound(nums, target)]
