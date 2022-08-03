from typing import List


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k == 0:
            return 0
        val = 1
        ws = 0
        i = 0
        ans = 0
        while ws < len(nums):
            while i < len(nums):
                if nums[i] * val >= k:
                    break
                val *= nums[i]
                i += 1
            ans += i - ws
            if i != ws:
                val /= nums[ws]
            ws += 1
            i = max(i, ws)

        return ans
            

assert Solution().numSubarrayProductLessThanK([10,5,2,6], 100) == 8
