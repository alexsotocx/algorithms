from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans = set()
        nums.sort()
        for i in range((1 << len(nums))):
            s = []
            p = i
            ix = 0
            while p != 0:
                if p % 2 == 1:
                    s.append(nums[ix])
                ix += 1
                p >>= 1
            ans.add(tuple(s))
        return list(ans)
