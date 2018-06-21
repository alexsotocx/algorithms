class TurretDefense:
  def _getTime(self, _from, _to):
    return abs(_from[0]- _to[0]) + abs(_from[1]- _to[1])

  def firstMiss(self, xs, ys, times):
    start = (0, 0)
    time = 0
    for i in (0..len(times)):
      _to = (xs[i], ys[i])
      _time = times[i]
      difference = self._getTime(start, _to)
      if (difference + time) <= _time:
        time = _time
        start = _to
      else:
        return i - 1
    return -1

    
