package google

import "sort"

func minAB(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func maxAB(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func mergeInterval(a, b []int) []int {
	return []int{minAB(a[0], b[0]), maxAB(a[1], b[1])}
}

func canBeMerged(a, b []int) bool {
	// [2, 4] - [3, 5]
	// [2, 4]  - [5, 8]
	return maxAB(a[0], b[0]) <= minAB(a[1], b[1])
}

func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i][0] != intervals[j][0] {
			return intervals[i][0] < intervals[j][0]
		}
		return intervals[i][1] < intervals[j][1]
	})

	res := make([][]int, 0)
	res = append(res, intervals[0])
	for _, in := range intervals {
		last := res[len(res)-1]
		if canBeMerged(last, in) {
			res[len(res)-1] = mergeInterval(last, in)
		} else {
			res = append(res, in)
		}
	}
	return res
}
