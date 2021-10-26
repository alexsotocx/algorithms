package google

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	m := make(map[byte]int)
	for i := range s {
		m[s[i]]++
	}

	for i := range t {
		m[t[i]]--
		if m[t[i]] < 0 {
			return false
		}
	}
	return true
}
