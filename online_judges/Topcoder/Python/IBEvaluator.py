class IBEvaluator:
  def getSummary(self, predictedGrades, actualGrades):
    result = [0, 0, 0, 0, 0, 0, 0]
    n = len(predictedGrades)
    for i in range(n):
      p = predictedGrades[i]
      a = actualGrades[i]
      result[abs(a-p)] += 1

    for i in range(7):
      result[i] = result[i] * 100 / n
    return result