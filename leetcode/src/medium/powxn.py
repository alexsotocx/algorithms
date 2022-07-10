class Solution:
    def myPow(self, x: float, n: int) -> float:
        if (n < 0):
            return 1.0 / self.myFastPow(x, -n)
        return self.myFastPow(x, n)

    def myFastPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n == 1:
            return x

        y = self.myPow(x, n // 2)
        if n % 2 == 0:
            return y * y
        return y * y * x
