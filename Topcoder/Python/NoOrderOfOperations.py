class NoOrderOfOperations:
  def plus(self, num1, num2):
    return(num1 + num2)

  def minus(self, num1, num2):
    return(num1 - num2)

  def mul(self, num1, num2):
    return(num1 * num2)

  def div(self, num1, num2):
    return(num1 / num2)

  def evaluate(self, expr):
    i = 1
    result = int(expr[0])
    options = { "+" : self.plus,"-" : self.minus,"*" : self.mul,"/" : self.div  }
    while i < len(expr):
      op = expr[i]
      num2 = expr[i+1]
      result = options[op](result, int(num2))
      i += 2
    return(result)
