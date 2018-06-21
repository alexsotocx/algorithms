from functools import reduce
class FallingFactorialPower:
  def compute(self, n, k):
    if k > 0:
      return reduce((lambda acum, ni: acum * ni), range(n, n-k, -1), 1)
    else:
      return reduce((lambda acum, ni: acum / (n + ni)), range(1,-k +1), 1.0)
