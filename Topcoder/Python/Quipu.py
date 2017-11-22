class Quipu:
  def readKnots(self, knots):
    knots = knots.split("(-X*)")

    knots = knots[:len(knots)]
    number = []
    for knot in knots:
      number.append(len(knot)-1)
    return int(''.join(number))
