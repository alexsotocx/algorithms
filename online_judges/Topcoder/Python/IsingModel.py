class IsingModel:
  def energy(self, spins):
    r = len(spins)
    c = len(spins[0])
    energy = 0
    for i in range(r):
      for j in range(c):
        if j < c - 1:
          energy += self.calculate(spins[i][j], spins[i][j + 1])
        if j < r - 1:
          energy += self.calculate(spins[i][j], spins[i + 1][j])
    return energy

  def calculate(self, x, y):
    return 1 if x != y else -1