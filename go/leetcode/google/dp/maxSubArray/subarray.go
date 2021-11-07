package google

func maxSubArray(nums []int) int {
	currentSum := 0
	maxSum := -(1 << 30)
	for _, v := range nums {
		if currentSum < 0 {
			currentSum = 0
		}
		currentSum += v
		if currentSum > maxSum {
			maxSum = currentSum
		}
	}
	return maxSum
}
