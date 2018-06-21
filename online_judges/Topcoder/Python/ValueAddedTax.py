class ValueAddedTax:
  def calculateFinalPrice(self, product, price, food):
    food = set(food)
    price = price * 1.10 if product in food else price * 1.18
    return price