class WordFind:
  di = [0, 1, 1]
  dj = [1, 0, 1]
  limitx = 0
  limity = 0
  visited = None
  def findWords(self, grid, wordList):
    self.limitx = len(grid)
    self.limity = len(grid[0])
    sol = {}
    for i in range(self.limitx):
      for j in range(self.limity):
        for word in wordList:
          if word not in sol:
            if self.word_here(grid, i, j, word):
              sol[word] = str(i) + " " + str(j)
    solution = []
    for word in wordList:
      if word in sol:
        solution.append(sol[word])
      else:
        solution.append("")
    return(solution)

  def word_here(self, grid, x, y, word):
    if x + len(word) <= self.limitx:
      works = True
      i = 0
      while works and i < len(word):
        works = (works and (grid[x + i][y] == word[i]))
        i += 1
      if works:
        return True
    if y + len(word) <= self.limity:
      works = True
      i = 0
      while works and i < len(word):
        works = (works and (grid[x][y + i] == word[i]))
        i += 1
      if works:
        return True
    if (y + len(word) <= self.limity) and (x + len(word) <= self.limitx):
      works = True
      i = 0
      while works and i < len(word):
        works = (works and (grid[x + i][y + i] == word[i]))
        i += 1
      if works:
        return True

    return False
