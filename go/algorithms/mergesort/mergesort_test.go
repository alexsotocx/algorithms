package mergesort_test

import (
	"testing"

	"fmt"

	"github.com/alexsotocx/algorithms/go/algorithms/mergesort"
	"github.com/alexsotocx/algorithms/go/interfaces"
)

type Integer struct {
	value int
}

func (i Integer) Value() interface{} {
	return i.value
}

func (i Integer) Compare(a interfaces.Comparable) int8 {
	val := a.(Integer).value
	if i.value == val {
		return 0
	} else if i.value < val {
		return -1
	}
	return 1
}

func TestSort(t *testing.T) {
	out := []int{2, 2, 2, 3, 3, 5}
	input := []int{5, 3, 3, 2, 2, 2}
	mergesort.Sort(input, func(i, j int) bool {
		return input[i] < input[j]
	})
	fmt.Println(input)
	for i, v := range input {
		if v != out[i] {
			t.Fatalf("Expected %d, got %d", out[i], v)
		}
	}
}
