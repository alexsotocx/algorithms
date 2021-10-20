package google

func searchRange(nums []int, target int) []int {
	if len(nums) == 0 {
		return []int{-1, -1}
	}
	return []int{searchBottom(nums, target), searchTop(nums, target)}
}

func searchBottom(nums []int, target int) int {
	lo := 0
	hi := len(nums) - 1
	min := hi
	for lo <= hi {
		mid := lo + (hi-lo)/2
		if nums[mid] > target {
			hi = mid - 1
		} else if nums[mid] < target {
			lo = mid + 1
		} else {
			hi = mid - 1
			if min > mid {
				min = mid
			}
		}
	}
	if nums[min] == target {
		return min
	}
	return -1
}

func searchTop(nums []int, target int) int {
	lo := 0
	hi := len(nums) - 1
	max := 0
	for lo <= hi {
		mid := lo + (hi-lo)/2
		if nums[mid] > target {
			hi = mid - 1
		} else if nums[mid] < target {
			lo = mid + 1
		} else {
			lo = mid + 1
			if max < mid {
				max = mid
			}
		}
	}
	if nums[max] == target {
		return max
	}
	return -1
}
