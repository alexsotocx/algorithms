package google

import (
	"fmt"
	"testing"
)

func Test_countSmaller(t *testing.T) {
	fmt.Println(countSmaller([]int{5, 2, 6, 1}))
	fmt.Println(countSmaller([]int{-1}))
	fmt.Println(countSmaller([]int{-1, -1}))
}
