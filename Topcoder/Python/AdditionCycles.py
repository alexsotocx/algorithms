class AdditionCycles:
  def cycleLength(self, n):
    total = 0
    actual = n
    condition = True
    while condition:
      x1, x2 = self.split(actual)
      actual = actual%10*10 + (x1 + x2) %10
      total += 1
      condition = n != actual
    return total

  def split(self, n):
    return (0, n) if n  < 10 else (n / 10, n % 10)