class AverageCandyLifetime:
  def getAverage(self, eatenCandies):
    month_days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    candies = eatenCandies[0]
    sums = eatenCandies[0] * 31.0
    for i in xrange(1, len(eatenCandies)):
      month_days[i] = month_days[i] + month_days[i - 1]
      sums += month_days[i] * eatenCandies[i] * 1.0
      candies += eatenCandies[i] * 1.0
    return sums/candies