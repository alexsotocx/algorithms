from functools import reduce

class Straights:
  def howMany(self, hand, k):
    total = 0
    for i in xrange(0, len(hand) - k + 1):
      total += reduce((lambda x, y: x * y), hand[i:i+k])
    return total