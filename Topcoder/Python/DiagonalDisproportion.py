class DiagonalDisproportion:
  def getDisproportion(self, matrix):
    n = len(matrix)
    main_d = 0
    second_d = 0
    for i in xrange(n):
      main_d += int(matrix[i][i])
      second_d += int(matrix[i][n-i-1])
    return main_d - second_d