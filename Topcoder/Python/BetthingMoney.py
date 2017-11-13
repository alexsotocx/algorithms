from functools import reduce

class BettingMoney:
  def moneyMade(self, amounts, centsPerDollar, finalResult):
    company_amount = (reduce(lambda x, y: x + y, amounts) - amounts[finalResult]) * 100
    return company_amount - (amounts[finalResult] * centsPerDollar[finalResult])
