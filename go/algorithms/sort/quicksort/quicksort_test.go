package quicksort_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/algorithms/sort/quicksort"
)

func TestSort(t *testing.T) {
	out := []int{3, 5, 7, 11, 26, 47}
	input := []int{3, 47, 11, 26, 7, 5}
	quicksort.Sort(input, func(i, j int) bool {
		return input[i] < input[j]
	})
	for i, v := range input {
		if v != out[i] {
			t.Fatalf("Expected %d, got %d", out[i], v)
		}
	}
}
