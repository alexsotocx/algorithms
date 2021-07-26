package google

// import "sort"

// type pair struct {
// 	i, j int
// }
// type answer struct {
// 	x, y, z int
// }

// func (p pair) isAfter(k int) bool {
// 	return p.i > k && p.j > k
// }

// func threeSum(nums []int) [][]int {
// 	sum := make(map[int][]pair)
// 	sort.Ints(nums)
// 	response := make(map[answer]struct{})
// 	for i := 0; i < len(nums); i++ {
// 		for j := i + 1; j < len(nums); j++ {
// 			t := nums[i] + nums[j]
// 			sum[t] = append(sum[t], pair{i, j})
// 		}
// 	}

// 	for i, v := range nums {
// 		toFind := -v
// 		if pairs, ok := sum[toFind]; ok {
// 			for _, p := range pairs {
// 				if p.isAfter(i) {
// 					newS := []int{nums[p.i], nums[p.j], nums[i]}
// 					response = append(response, newS)
// 				}
// 			}
// 		}
// 	}
// 	return response
// }
