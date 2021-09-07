package google

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"
)

func Test_rotate(t *testing.T) {
	mat := [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
	rotate(mat)
	require.Equal(t, fmt.Sprint(mat), "[[7 4 1] [8 5 2] [9 6 3]]")
	mat = [][]int{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}
	rotate(mat)
	require.Equal(t, fmt.Sprint(mat), "[[15 13 2 5] [14 3 4 1] [12 6 8 9] [16 7 10 11]]")
}
