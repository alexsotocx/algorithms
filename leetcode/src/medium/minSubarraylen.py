from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        cs = 0
        ws = 0
        i = 0
        ans = len(nums) + 1
        while ws < len(nums):
            while i < len(nums) and cs < target:
                cs += nums[i]
                i += 1
            if cs >= target:
                ans = min(ans, i - ws)
            cs -= nums[ws]
            ws += 1
        return ans if ans < len(nums) + 1 else 0


print(Solution().minSubArrayLen(11, [1, 1, 1, 1, 1, 1, 1, 1]))
assert Solution().minSubArrayLen(7, [2, 3, 1, 2, 4, 3]) == 2
