package countsort_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/algorithms/countsort"
)

func TestSort(t *testing.T) {
	out := []int{2, 2, 2, 3, 3, 5}
	output := countsort.Sort([]int{5, 2, 3, 2, 3, 2}, 2, 5)
	for i, v := range output {
		if v != out[i] {
			t.Fatalf("Expected %d, got %d", out[i], v)
		}
	}
}
