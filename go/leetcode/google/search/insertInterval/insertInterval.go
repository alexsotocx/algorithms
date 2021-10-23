package google

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

func appendMerged(merge [][]int, b []int) [][]int {
	a := merge[len(merge)-1]
	if canBeMerged(a, b) {
		merge[len(merge)-1] = mergeInterval(a, b)
	} else {
		merge = append(merge, b)
	}
	return merge
}

func mergeInsertIntervals(intervals [][]int, newInterval []int, insertPoint int) [][]int {
	ans := make([][]int, 0)

	if len(intervals) == 0 {
		ans = append(ans, newInterval)
		return ans
	}

	if newInterval[0] < intervals[0][0] {
		ans = append(ans, newInterval)
	} else {
		ans = append(ans, intervals[0])
	}
	i := 0
	for i < len(intervals) {

		if i == insertPoint {
			if newInterval[0] < intervals[i][0] {
				ans = appendMerged(ans, newInterval)
				ans = appendMerged(ans, intervals[i])
			} else {
				ans = appendMerged(ans, intervals[i])
				ans = appendMerged(ans, newInterval)
			}
		} else {
			ans = appendMerged(ans, intervals[i])
		}

		i++
	}
	return ans
}

func insert(intervals [][]int, newInterval []int) [][]int {
	lo := 0
	hi := len(intervals) - 1
	for lo < hi {
		mid := lo + (hi-lo)/2
		intMid := intervals[mid]
		if intMid[0] == newInterval[0] {
			return mergeInsertIntervals(intervals, newInterval, mid)
		} else if intMid[0] > newInterval[0] {
			hi = mid - 1
		} else {
			lo = mid + 1
		}
	}
	return mergeInsertIntervals(intervals, newInterval, hi)
}
