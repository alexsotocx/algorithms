
class MovingAverages:
  def calculate(self, times, n):
    sum = [0 for _ in range(len(times))]
    sum[0] = MovingAverages.parse_time(times[0])
    for i in range(1, len(times)):
      sum[i] = sum[i - 1] + MovingAverages.parse_time(times[i])
    result = []

    for i in xrange(0, len(times) - n + 1):
      top = sum[n - 1 + i]
      bottom = 0 if i == 0 else sum[i - 1]
      result.append((top - bottom) / n)

    return tuple(result)

  @classmethod
  def parse_time(cls, time):
    hh, mm, ss = map(int, time.split(":"))
    return hh * 3600 + mm * 60 + ss

