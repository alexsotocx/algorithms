class Substitute:
  def getValue(self, key, code):
    i = 1
    subtituions = {}
    for x in key:
      subtituions[x] = i
      i += 1
    subtituions[key[len(key) - 1]] = 0
    value = ""
    for x in code:
      if x in subtituions:
        value += str(subtituions[x])
    return int(value)
