package google

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func maxProfit(prices []int) int {
	profit := 0
	minV := prices[0]
	for _, v := range prices {
		if minV > v {
			minV = v
		}
		profit = max(v-minV, profit)
	}
	return profit
}
