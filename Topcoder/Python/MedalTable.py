class MedalTable:
  results = {}
  def initiliaze_results(self, result):
    if result not in results:
      results[result] = [0, 0, 0]
  def inte(self, ints):
    return(ints * -1)
  def generate(self, results):
    results_split = [ result.split() for result in results ]
    print(results_split)
    for result in results_split:
      i = 0
      for cat in results:
        self.initiliaze_results(cat)
        results[cat][i] -= 1
        i += 1
    self.results = [(tuple(val), key) for key, val in self.results.iteritems()  ]
    print(results)
    results.sort()
    ans = []
    for result in results:
      ans.append(' '.join([result[1]] + map(inte, results[0])))
    return(ans)
