
from typing import List


class Solution:
    def insersect(self, a: List[int], b: List[int]):
        ma = max(a[0], b[0])
        mb = min(a[1], b[1])
        if (mb >= ma):
            return (ma, mb)
        else:
            return None

    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        first = 0
        second = 0
        ans = []
        while first < len(firstList) and second < len(secondList):
            itemF = firstList[first]
            itemS = secondList[second]

            inter = self.insersect(itemF, itemS)
            if (inter is not None):
                ans.append(inter)
            if itemS[1] == itemF[1]:
                first += 1
                second += 1
            elif itemS[1] < itemF[1]:
                second += 1
            else:
                first += 1
        return ans


assert Solution().intervalIntersection([[0, 2], [5, 10], [13, 23], [24, 25]], [[1, 5], [
    8, 12], [15, 24], [25, 26]]) == [(1, 2), (5, 5), (8, 10), (15, 23), (24, 24), (25, 25)]
