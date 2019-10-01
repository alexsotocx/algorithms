class LotteryTicket:
  def buy(self, price, b1, b2, b3, b4):
    p = [b1, b2, b3, b4]
    for i in range((1<<4)):
      total = 0
      for j in range(4):
        total += p[j] if (i & (1<<j)) != 0  else 0
      if total == price:
        return 'POSSIBLE'
    return 'IMPOSSIBLE'
