from typing import List


class Solution:
    def utilCombi(self, candidates: List[int], target: int, currentIndex: int, currentSum: int):
        if (currentIndex >= len(self.nums)):
            return
        if (currentSum == target):
            self.list.append(candidates.copy())
            return
        if (currentSum > target):
            return

        candidates.append(self.nums[currentIndex])
        self.utilCombi(candidates, target, currentIndex,
                       currentSum + self.nums[currentIndex])
        candidates.pop()
        self.utilCombi(candidates, target, currentIndex + 1, currentSum)

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.list = []
        self.nums = candidates
        self.utilCombi([], target, 0, 0)
        return self.list

