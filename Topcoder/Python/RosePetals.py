class RosePetals:
  points = {1: 0, 2: 0, 3: 2, 4: 0, 5: 4, 6: 0}
  def getScore(self, dice):
    return sum(self.points[x] for x in dice)