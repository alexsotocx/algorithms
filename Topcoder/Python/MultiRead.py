class MultiRead:
  def minCycles(self, trace, procs):
    coun = 0
    i = 0
    while i < len(trace):
      if trace[i] == 'W':
        coun += 1
        i+=1
      else:
        j = procs - 1
        i += 1
        while j > 0 and i< len(trace) and trace[i] == 'R':
          j -= 1
          i += 1
        coun += 1
    return coun
