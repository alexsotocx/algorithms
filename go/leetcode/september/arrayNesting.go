package september

func arrayNesting(nums []int) int {
	cycleLength := make([]int, len(nums))
	cycleStarter := make([]int, len(nums))
	for i := range cycleStarter {
		cycleStarter[i] = -1
	}
	max := -1
	for i := range nums {
		if cycleStarter[i] != -1 {
			continue
		}
		l := 0
		j := nums[i]
		for cycleStarter[j] == -1 {
			cycleStarter[j] = i
			j = nums[j]
			l++
		}
		cycleLength[i] = l
		if l > max {
			max = l
		}
	}
	return max
}
