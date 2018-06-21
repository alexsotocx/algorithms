class MedianOfNumbers:
  def findMedian(self, numbers):
    numbers = list(numbers)
    if (len(numbers) % 2) == 0:
      return -1
    numbers.sort()
    return numbers[len(numbers) // 2]
