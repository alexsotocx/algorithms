package google

func removeDuplicates(nums []int) int {
	i := 0
	j := 0
	for j < len(nums) {
		nums[i] = nums[j]
		for j < len(nums) && nums[i] == nums[j] {
			j++
		}
		i++
	}
	return i
}
