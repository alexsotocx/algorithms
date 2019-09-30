class AccountBalance:
  def processTransactions(self, startingBalance, transactions):
    for t in transactions:
      op = t[0]
      amount = int(t[2:])
      if op == 'C':
        startingBalance += amount
      else:
        startingBalance -= amount
      
    return startingBalance
