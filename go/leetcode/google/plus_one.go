package google

func plusOne(digits []int) []int {
	n := len(digits)
	offset := 1
	for i := n - 1; i >= 0; {
		if offset == 1 {
			if digits[i] == 9 {
				offset = 1
				digits[i] = 0
			} else {
				offset = 0
				digits[i]++
				break
			}
		}
	}
	if offset == 1 {
		digits = append([]int{1}, digits...)
	}
	return digits
}
