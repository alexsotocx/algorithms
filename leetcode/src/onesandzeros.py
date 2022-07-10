from typing import List

class Solution:
  def findMaxForm(self, strs: List[str], n: int, m: int) -> int:
    dp = [[[0 for k in range(m+1)] for j in range(n+1)] for i in range(len(strs))]
    count = []
    for s in range(len(strs)):
      one = 0
      zero = 0
      for c in strs[s]:
        if c == '0':
          zero += 1
        else:
          one += 1
      count.append((zero, one))
          

    for s in range(len(strs)):
      for ni in range(n + 1):
        for mi in range(m + 1):

          if s > 0:
            dp[s][ni][mi] = dp[s-1][ni][mi]
            
          if mi >= count[s][1] and ni >= count[s][0]:
            if s == 0:
              dp[s][ni][mi] += 1
            else:
              dp[s][ni][mi] = max(dp[s][ni][mi],dp[s-1][ni - count[s][0]] [mi - count[s][1]]+1)

    return dp[len(strs) -1][ n][ m]
    
    
assert Solution().findMaxForm(  ["10","0","1"], 1, 1) == 2
