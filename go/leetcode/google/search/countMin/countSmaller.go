package google

var helpArray []*pair
var countArr []int

type pair struct {
	v, i int
}

func count(arr []*pair, lo, mid, hi int) {
	st := 0
	i := lo
	j := mid + 1
	prev := 0
	for i <= mid {
		c := prev
		for j <= hi && arr[i].v > arr[j].v {
			helpArray[st] = arr[j]
			j++
			st++
			c++
		}
		helpArray[st] = arr[i]
		countArr[arr[i].i] += c
		prev = c
		i++
		st++
	}

	for j <= hi {
		helpArray[st] = arr[j]
		st++
		j++
	}
	st = 0
	for i = lo; i <= hi; i++ {
		arr[i] = helpArray[st]
		st++
	}
}

func mergeSort(arr []*pair, lo, hi int) {
	if hi == lo {
		return
	}
	mid := lo + (hi-lo)/2
	mergeSort(arr, lo, mid)
	mergeSort(arr, mid+1, hi)
	count(arr, lo, mid, hi)
}

func countSmaller(nums []int) []int {
	n := len(nums)
	helpArray = make([]*pair, n)
	indexArray := make([]*pair, n)
	countArr = make([]int, n)
	for i := range helpArray {
		indexArray[i] = &pair{v: nums[i], i: i}
	}
	mergeSort(indexArray, 0, n-1)
	return countArr
}
