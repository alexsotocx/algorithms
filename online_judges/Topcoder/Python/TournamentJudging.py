from math import floor

class TournamentJudging:

  def getPoints(self, rawScores, conversionFactor):
    data = 0
    for i in xrange(len(rawScores)):
      data += floor((rawScores[i] * 1.0)/ (conversionFactor[i] * 1.0) + 0.5)
    return data