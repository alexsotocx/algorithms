import re

class Quipu:
  def readKnots(self, knots):
    knots = re.findall("(-X*)", knots)
    knots = knots[:len(knots)-1]
    number = []
    for knot in knots:
      number.append(str(len(knot)-1))
    return int(''.join(number))
