def zeroSumSubarray(nums):
  commulativeSum = 0
  sumMap = set([0])
  for num in nums:
    commulativeSum += num
    if commulativeSum in sumMap:
      return True
    sumMap.add(commulativeSum)
  return False
