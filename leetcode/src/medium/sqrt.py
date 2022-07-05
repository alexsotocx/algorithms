class Solution:
    def mySqrt(self, x: int) -> int:
        lo = 0
        hi = 1 << 16
        best = 1
        while lo <= hi:
            mid = (lo + hi) // 2
            midv = mid * mid
            if midv == x:
                return mid
            if midv > x:
                hi = mid - 1
            else:
                best = mid
                lo = mid + 1
        return best
