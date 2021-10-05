package google

import (
	"strconv"
	"strings"
)

var par = 0

func decodeString(s string) string {
	par = 0
	var sb strings.Builder
	i := 0
	for i < len(s) {
		ss, p := decodeStringHelper(s, i)
		i = p + 1
		sb.WriteString(ss)
	}

	return sb.String()
}

func decodeStringHelper(s string, pos int) (string, int) {
	if pos > len(s) {
		return "", pos
	}
	var sb strings.Builder
	i := pos
	for i < len(s) && (s[i] < '0' || s[i] > '9') {
		if s[i] == ']' {
			par--
			return sb.String(), i
		}

		sb.WriteByte(s[i])
		i++
	}
	ns := i
	for i < len(s) && s[i] != '[' {
		i++
	}
	if i != ns {
		startedPar := par
		par++
		rep, _ := strconv.Atoi(s[ns:i])
		var ssb strings.Builder
		for par != startedPar {
			str, lastPos := decodeStringHelper(s, i+1)
			ssb.WriteString(str)
			i = lastPos
		}
		str := ssb.String()
		for rep > 0 {
			sb.WriteString(str)
			rep--
		}

	}
	return sb.String(), i
}
