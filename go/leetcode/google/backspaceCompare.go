package google

import "bytes"

func resolve(s []byte) []byte {
	writer := 0
	for reader := range s {
		if s[reader] == '#' {
			writer--
			if writer < 0 {
				writer = 0
			}
		} else {
			s[writer] = s[reader]
			writer++
		}
	}
	return s[:writer]
}

func backspaceCompare(s string, t string) bool {
	return bytes.Equal(resolve([]byte(s)), resolve([]byte(t)))
}
