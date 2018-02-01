import math
from functools import reduce

class StairClimb:
  def stridesTaken(self, flights, stairsPerStride):
    stairsPerStride *= 1.0
    moves = reduce((lambda acum, flight: acum + int(math.ceil(flight/stairsPerStride))), flights, 0)
    moves += (len(flights) -1) * 2
    return moves
