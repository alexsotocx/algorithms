package google

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func TestLongestString(t *testing.T) {
	require.Equal(t, 3, LengthOfLongestSubstring("abcabcbb"))
	require.Equal(t, 1, LengthOfLongestSubstring("bbbbb"))
	require.Equal(t, 3, LengthOfLongestSubstring("pwwkew"))
	require.Equal(t, 0, LengthOfLongestSubstring(""))
	require.Equal(t, 7, LengthOfLongestSubstring("abcdfgdhi67"))

}
