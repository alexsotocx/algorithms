package mergesort_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/algorithms/sort/mergesort"
)

func TestSort(t *testing.T) {
	out := []int{2, 2, 2, 3, 3, 5}
	input := []int{5, 3, 3, 2, 2, 2}
	mergesort.Sort(input, func(i, j int) bool {
		return input[i] < input[j]
	})
	for i, v := range input {
		if v != out[i] {
			t.Fatalf("Expected %d, got %d", out[i], v)
		}
	}
}
