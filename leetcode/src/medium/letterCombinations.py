from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        comb: List[str] = []
        mapping = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        def backtrack(curr: List[str], pos: int):
            if pos == len(digits):
                comb.append(''.join(curr))
                return

            for c in mapping[ord(digits[pos]) - ord('0')]:
                curr.append(c)
                backtrack(curr, pos + 1)
                curr.pop()
        
        backtrack([], 0)
        return comb
        
