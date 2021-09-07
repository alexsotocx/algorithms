package google

func Max(x, y int) int {
	if x < y {
		return y
	}
	return x
}

func canJump(nums []int) bool {
	maxReach := 0
	for pos, jump := range nums {
		if maxReach < pos {
			return false
		}
		maxReach = Max(pos+jump, maxReach)
		if maxReach >= (len(nums) - 1) {
			return true
		}
	}
	return false
}
