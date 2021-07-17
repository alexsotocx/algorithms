package google_test

import (
	"testing"

	ex "github.com/alexsotocx/algorithms/go/leetcode/google"
	"github.com/stretchr/testify/require"
)

func TestFindGoodNumbers(t *testing.T) {
	// require.ElementsMatch(t, []int{3, 4}, ex.FindGoodNumbers([]int{10, 13, 12, 14, 15}))
	require.ElementsMatch(t, []int{1, 3, 4}, ex.FindGoodNumbers([]int{2, 3, 1, 1, 4}))
}
