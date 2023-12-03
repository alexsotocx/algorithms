def dfs(array, visited, start, total, initial):
  if visited[start]:
    return total == len(array) and start == initial
  visited[start] = True
  total += 1
  return dfs(array, visited, (start + array[start]) % len(array), total, initial)
  

def hasSingleCycle(array):
  return dfs(array, [False] * len(array), 0, 0, 0)
