from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pL = len(p)
        sL = len(s)
        if pL > sL:
            return []
        ans = []
        pChars = [0 for _ in range(26)]
        a = ord('a') 
        for c in p:
            pChars[ord(c)-a] += 1
        
        sChars = [0 for _ in range(26)]
        i = 0
        ws = 0
        while i < pL:
            sChars[ord(s[i])-a] += 1
            i += 1
        if sChars == pChars:
            ans.append(0)
        while i < sL:
            sChars[ord(s[ws])-a] -= 1
            sChars[ord(s[i])-a] += 1
            if sChars == pChars:
                ans.append(ws + 1)
            i += 1
            ws += 1
        return ans


assert Solution().findAnagrams("cbaebabacd", "abc") == [0, 6]
assert Solution().findAnagrams("abab", "ab") == [0,1,2]
