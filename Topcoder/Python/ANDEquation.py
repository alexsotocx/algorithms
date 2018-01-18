class ANDEquation:
  def restoreY(self, A):
    for i in range(len(A)):
      m =  (1 << 20) - 1
      for j in range(len(A)):
        if i != j:
          m &= A[j]
      if m == A[i]:
        return A[i]
    return -1
