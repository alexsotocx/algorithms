package google

func rotate(nums []int, k int) {
	if k == 0 {
		return
	}
	k = k % len(nums)

	visited := 0
	start := 0
	for visited < len(nums) {
		oldVal := nums[start]
		p := start
		for visited < len(nums) {
			visited++
			newPos := (p + k) % len(nums)
			t := nums[newPos]
			nums[newPos] = oldVal
			oldVal = t
			p = newPos
			if p == start {
				break
			}
		}
		start++
	}
}
