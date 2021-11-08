package google

func maxProduct(nums []int) int {
	max := nums[0]
	n := len(nums)
	dp := make([][]int, 0, n)
	for range nums {
		r := make([]int, n)
		dp = append(dp, r)
	}
	for s := range nums {
		for l := 0; l+s < n; l++ {
			before := 1
			v := nums[l+s]
			if l != 0 {
				before = dp[s][l-1]
			}
			dp[s][l] = before * v
			if max < dp[s][l] {
				max = dp[s][l]
			}
		}
	}
	return max
}
