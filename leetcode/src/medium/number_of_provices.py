from typing import List


class Solution:
    def dfs(self, isConnected: List[List[int]], x: int):
        self.visited[x] = True
        for i, c in enumerate(isConnected[x]):
            if c == 1 and not self.visited[i]:
                self.dfs(isConnected, i)



    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        self.visited = [False for _ in range(len(isConnected))]
        ans = 0
        for i in range(len(isConnected)):
            if not self.visited[i]:
                ans += 1
                self.dfs(isConnected, i)

        return ans
                
