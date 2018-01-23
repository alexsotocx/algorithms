import math
class ATaleOfThreeCities:
  def distance(self, p1, p2):
    dx = p1[0] - p2[0]
    dy = p1[1] - p2[1]
    return math.sqrt(dx*dx + dy*dy)

  def make_point(self, x, y):
    return (x, y)

  def closes_point(self, p, psetx, psety):
    min_d = (1 << 20)
    for i in range(len(psetx)):
      point = self.make_point(psetx[i], psety[i])
      min_d = min(min_d, self.distance(p, point))
    return min_d

  def min_d_sets(self, s1x, s1y, s2x, s2y):
    min_d = (1 << 20)
    for i in range(len(s1x)):
      p = self.make_point(s1x[i], s1y[i])
      min_d = min(min_d, self.closes_point(p, s2x, s2y))
    return min_d

  def connect(self, ax, ay, bx, by, cx, cy):
    min_ab = self.min_d_sets(ax, ay, bx, by)
    min_ac = self.min_d_sets(ax, ay, cx, cy)
    min_bc = self.min_d_sets(cx, cy, bx, by)
    return min(min_ab + min_ac, min_ab + min_bc, min_ac + min_bc)
