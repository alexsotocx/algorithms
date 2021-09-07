package google

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func maxArea(height []int) int {
	i := 0
	j := len(height) - 1
	maxA := 0
	for i != j {
		area := min(height[i], height[j]) * (j - i)
		if area > maxA {
			maxA = area
		}
		if height[i] > height[j] {
			j--
		} else {
			i++
		}
	}
	return maxA
}
