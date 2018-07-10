package countsort

func Sort(array []int, min int, max int) []int {
	f := countFrequency(array, min, max)
	accomulateFrequency(f)
	return sortArray(array, f, min)
}

func countFrequency(array []int, min int, max int) []int {
	frequency := make([]int, max-min+1)
	for _, k := range array {
		frequency[k-min]++
	}
	return frequency
}

func accomulateFrequency(frequency []int) {
	for i := 1; i < len(frequency); i++ {
		frequency[i] += frequency[i-1]
	}
}

func sortArray(array []int, f []int, min int) []int {
	sortedArray := make([]int, len(array))
	for i := len(array) - 1; i >= 0; i-- {
		ff := f[array[i]-min] - 1
		sortedArray[ff] = array[i]
		f[array[i]-min]--
	}

	return sortedArray
}
