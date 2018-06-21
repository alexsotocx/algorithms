class ProfitCalculator:
  def percent(self, items):
    real_price = 0
    total_sale = 0
    for item in items:
      x, y = map(float, item.split(" "))
      total_sale += x
      real_price += y
    return int(((total_sale - real_price) * 100.0 / total_sale))