package google

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		if v2, f := m[target-v]; f {
			return []int{v2, i}
		}
		m[v] = i
	}
	return []int{}
}
