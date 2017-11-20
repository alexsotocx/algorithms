class YahtzeeScore:
  def maxPoints(self, toss):
      points = [0, 0, 0, 0, 0, 0]
      maxx = -1
      for tos in toss:
          points[tos - 1] += tos
          maxx = max(points[tos - 1], maxx)
      return maxx
