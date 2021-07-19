package google

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func TestTotalFruits(t *testing.T) {
	// require.Equal(t, 1, TotalFruits([]int{1}))
	require.Equal(t, 3, TotalFruits([]int{1, 0, 3, 4, 3}))
	// require.Equal(t, 3, TotalFruits([]int{1, 2, 1}))
	// require.Equal(t, 5, TotalFruits([]int{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}))
	// require.Equal(t, 4, TotalFruits([]int{1, 2, 3, 2, 2}))
	// require.Equal(t, 6, TotalFruits([]int{1, 2, 2, 2, 5, 5, 5}))
}
