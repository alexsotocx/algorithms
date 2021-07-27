package google

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func Test_minWindow(t *testing.T) {
	require.Equal(t, "BANC", minWindow("ADOBECODEBANC", "ABC"))
	require.Equal(t, "", minWindow("abc", "ABC"))
	require.Equal(t, "fde", minWindow("adbecfde", "fde"))
	require.Equal(t, "a", minWindow("ab", "a"))
}
