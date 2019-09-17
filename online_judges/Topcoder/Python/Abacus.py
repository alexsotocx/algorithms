class Abacus:
  def parse_abacus_string(self, string):
    size = len(string)
    value = 9
    for i in range(size):
      char = string[i]
      if char == '-':
        break
      value -= 1
    return value
  def build_abacus(self, value):
    left = 9 - value
    separator = "---"
    return ('o' * left) + separator + ('o' * value)

  def add(self, original, val):
    start_mutiplier = 100000
    total = 0
    for string in original:
      total += self.parse_abacus_string(string) * start_mutiplier
      start_mutiplier /= 10
    
    end_value = total + val
    end_abacus = []
    start_mutiplier = 100000
    while start_mutiplier != 0:
      val = end_value // start_mutiplier
      end_value -= val * start_mutiplier
      end_abacus.append(self.build_abacus(val))
      start_mutiplier /= 10
    return end_abacus

data = ("ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo",
        "oo---ooooooo", "---ooooooooo")
x = Abacus().add(data, 5)
print(x)

