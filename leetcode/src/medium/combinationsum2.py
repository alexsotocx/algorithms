from collections import Counter
from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        combinations = []
        count = [(k, v) for k, v in Counter(candidates).items()]
        def backtrack(currComb: List[int], currSum: int, index: int):
            if currSum == target:
                combinations.append(currComb.copy())
                return
            if currSum > target:
                return

            for j in range(index, len(count)):
                k, v = count[j]
                if v == 0:
                    continue

                currComb.append(k)
                count[j] = (k, v - 1)
                backtrack(currComb, currSum + k, j)
                count[j] = (k, v)
                currComb.pop()

        backtrack([], 0, 0)
        return combinations


print(Solution().combinationSum2([2,5,2,1,2], 5))
