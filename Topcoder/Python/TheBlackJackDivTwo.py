class TheBlackJackDivTwo:
  ten = set(('T', 'J', 'Q', 'K'))
  def score(self, cards):
    total = 0
    for card in cards:
      card = card[0]
      if card in self.ten:
        total += 10
      elif card == 'A':
        total += 11
      else:
        total += int(card)
    return total