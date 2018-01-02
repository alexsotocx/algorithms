class MedalTable:
  results = {}
  def initiliaze_results(self, result):
    if result not in self.results:
      self.results[result] = [0, 0, 0]
  def inte(self, ints):
    return(str(ints * -1))
  def generate(self, results):
    results_split = [ result.split() for result in results ]
    for result in results_split:
      i = 0
      for cat in result:
        self.initiliaze_results(cat)
        self.results[cat][i] -= 1
        i += 1
    self.results = [(tuple(val), key) for key, val in self.results.iteritems()  ]
    self.results.sort()
    ans = []
    for result in self.results:
      ans.append(' '.join([result[1]] + map(self.inte, result[0])))
    return(ans)

MedalTable().generate(x)
