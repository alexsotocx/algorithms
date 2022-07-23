from bisect import bisect_left
from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        lo = 0
        hi = len(matrix) - 1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            n = len(matrix[mid]) - 1
            if (matrix[mid][0] <= target <= matrix[mid][n]):
                p = bisect_left(matrix[mid], target)
                if p <= n and matrix[mid][p] == target:
                    return True
                else:
                    return False
            if target > matrix[mid][n]:
                lo = mid + 1
            else:
                hi = mid - 1
        return False

assert Solution().searchMatrix([[1], [2], [3], [4]], 1)
assert Solution().searchMatrix([[1], [2], [3], [4]], 2)
assert Solution().searchMatrix([[1], [2], [3], [4]], 3)
assert Solution().searchMatrix([[1], [2], [3], [4]], 4)
assert Solution().searchMatrix([[1], [2], [3], [4]], 5) == False

assert Solution().searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],3)
assert Solution().searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],13) == False