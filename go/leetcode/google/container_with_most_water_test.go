package google

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func Test_maxArea(t *testing.T) {
	require.Equal(t, 49, maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7}))
	require.Equal(t, 16, maxArea([]int{4, 3, 2, 1, 4}))
	require.Equal(t, 0, maxArea([]int{0, 0}))
	require.Equal(t, 2, maxArea([]int{1, 2, 1}))
	require.Equal(t, 24, maxArea([]int{1, 3, 2, 5, 25, 24, 5}))
}
