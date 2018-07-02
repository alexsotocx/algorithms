package mergesort_test

import (
	"testing"

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
	input := []interfaces.Comparable{Integer{5}, Integer{2}, Integer{3}, Integer{2}, Integer{3}, Integer{2}}
	mergesort.Sort(input)
	for i, v := range input {
		if v.Value().(int) != out[i] {
			t.Fatalf("Expected %d, got %d", out[i], v)
		}
	}
}
