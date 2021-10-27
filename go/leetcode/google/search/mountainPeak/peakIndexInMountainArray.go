package google

func peakIndexInMountainArray(arr []int) int {
	lo := 0
	hi := len(arr) - 1
	for hi > lo {
		mid := lo + (hi-lo)/2
		if mid-1 < 0 {
			lo = mid + 1
			continue
		}
		if mid+1 > len(arr) {
			hi = mid - 1
			continue
		}
		if arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1] {
			return mid
		} else if arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1] {
			lo = mid + 1
		} else {
			hi = mid - 1
		}
	}
	return hi
}
