class Soccer:
  def maxPoints(self, wins, ties):
    maxi = -1
    for i in xrange(len(wins)):
      maxi = max(maxi, wins[i] * 3 + ties[i])
    return maxi
        