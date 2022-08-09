from typing import List, Set


class Solution:
    def backtrack(self, nums: List[int], current: List[int], permutations: Set, used: List[bool]):
        if len(current) == len(nums):
            permutations.add(tuple(current))
        for i in range(len(nums)):
            if used[i]:
                continue
            used[i] = True
            current.append(nums[i])
            self.backtrack(nums, current, permutations, used)
            current.pop()
            used[i] = False



    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        unique = set()
        self.backtrack(nums, [], unique, [False for _ in range(len(nums))])
        return list(unique)
