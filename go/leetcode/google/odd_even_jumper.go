package google

import "fmt"

func searchNext(starting int, smallestJump map[int]int, arr []int) int {
	for i := starting; i < len(arr)-1; i++ {

	}
	return 0
}
func FindGoodNumbers(arr []int) []int {
	n := len(arr)
	evenJumpGoodNumbers := make(map[int]bool)
	evenJumpGoodNumbers[n-1] = true
	oddJumpGoodNumbers := make(map[int]bool)
	oddJumpGoodNumbers[n-1] = true
	biggestAfter := make(map[int]int)
	smallestAfter := make(map[int]int)
	biggestAfter[n-1] = n - 1
	smallestAfter[n-1] = n - 1
	goodNumbers := []int{n - 1}
	for i := n - 2; i >= 0; i-- {
		biggestIndex := biggestAfter[i+1]
		smallestIndex := smallestAfter[i+1]
		// odd jump
		if arr[i] <= arr[smallestIndex] {
			if _, ok := evenJumpGoodNumbers[smallestIndex]; ok {
				oddJumpGoodNumbers[i] = true
				goodNumbers = append(goodNumbers, i)
			}
			smallestAfter[i] = i
		} else {
			smallestAfter[i] = smallestIndex
		}

		// even jump
		if arr[i] >= arr[biggestIndex] {
			if _, ok := oddJumpGoodNumbers[biggestIndex]; ok {
				evenJumpGoodNumbers[i] = true
			}
			biggestAfter[i] = i
		} else {
			biggestAfter[i] = biggestIndex
		}
	}
	fmt.Println(smallestAfter)
	fmt.Println(biggestAfter)
	return goodNumbers
}
