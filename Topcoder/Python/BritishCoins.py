class BritishCoins:
  def coins(self, pence):
    conv = (12 * 20, 12, 1)
    result = [0, 0, 0]
    for i in xrange(len(conv)):
      result[i] = (pence / conv[i])
      pence -= conv[i] * result[i]
    return tuple(result)

print BritishCoins().coins(533)