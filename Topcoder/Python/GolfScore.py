class GolfScore:

  translation = {
    "triple bogey": -3,
    "double bogey": -2,
    "bogey": -1,
    "par": 0,
    "birdie": 1,
    "eagle": 2,
    "albatross": 3,
    "hole in one": 0
  }

  def tally(self, parValues, scoreSheet):
    score = 0
    for i in xrange(len(parValues)):
      score += 1 if scoreSheet[i] == "hole in one" else abs(parValues[i] - self.translation[scoreSheet[i]])
    return score