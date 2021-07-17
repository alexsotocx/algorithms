package google

import (
	"strings"
)

func LicenseKeyFormatting(s string, k int) string {
	st := make([]byte, 0)
	var sb strings.Builder
	count := 0
	for i := len(s) - 1; i >= 0; i-- {
		c := s[i]
		if c == '-' {
			continue
		}
		if count == k {
			count = 0
			st = append(st, '-')
		}
		count++
		st = append(st, c&(^byte(32)))
	}
	for i := len(st) - 1; i >= 0; i-- {
		sb.WriteByte(st[i])
	}
	return sb.String()
}
