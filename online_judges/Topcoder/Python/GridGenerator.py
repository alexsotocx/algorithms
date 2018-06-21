class GridGenerator:
  def generate(self, row, col):
    mat = [[0  for i in range(len(row))] for j in range(len(col))]
    for i in range(len(col)):
      mat[i][0] = col[i]
    mat[0] = row
    for i in xrange(1, len(row)):
      for j in xrange(1, len(col)):
        mat[i][j] = mat[i - 1][j] + mat[i - 1][j - 1] + mat[i][j - 1]

    return(mat[len(row) - 1][len(col) - 1])