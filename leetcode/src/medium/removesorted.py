from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if (len(nums) == 0):
            return 0
        p = 0
        c = 1
        for i in range(1, len(nums)):
            if nums[p] == nums[i]:
                if c == 1:
                    nums[p+1] = nums[i]
                    c += 1
                    p += 1
            else:
                p += 1
                nums[p] = nums[i]
                c = 1
        return p + 1
