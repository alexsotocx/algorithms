class WhiteCells:
  def countOccupied(self, board):
    total = 0
    for i, row in enumerate(board):
      if (i % 2) == 0: total +=  sum(1 for x in row[0::2] if x == 'F')
      else: total +=  sum(1 for x in row[1::2] if x == 'F')
    return total