from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans: List[List[int]] = []
        for i in range((1 << len(nums))):
            s = []
            p = i
            ix = 0
            while p != 0:
                if p % 2 == 1:
                    s.append(nums[ix])
                ix += 1
                p >>= 1
            ans.append(s)
        return ans


print(Solution().subsets([1,2,3]))
