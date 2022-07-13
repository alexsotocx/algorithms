class Solution:
    def myAtoi(self, s: str) -> int:
        symbol = 1
        numbers = []
        for c in range(s):
            