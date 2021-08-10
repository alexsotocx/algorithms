class Solution:
  def findMissingRanges(self, nums: List[int], low: int, high: int) -> List[str]:
    nextV = low
    i = 0
    missing = []
    highCover = False
    while i < len(nums) and nextV < high:
      c = nums[i]
      if c == nextV:
        nextV += 1
      elif c > nextV:
        missing.append(rangeStr(nextV, min(c-1, high)))
        nextV = c + 1
      if nums[i] >= high:
        highCover = True
        break
      i += 1

    if nextV < high or (not highCover):
      missing.append(rangeStr(nextV, high))
    return missing

def rangeStr(low, high):
	if low == high:
		return f"{low}"
	elif low < high:
		return f"{low}->{high}"
	return ""
