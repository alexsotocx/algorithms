package google

func isValid(c, cw []int) bool {
	for k, v := range c {
		if v > cw[k] {
			return false
		}
	}
	return true
}

func minWindow(s string, t string) string {

	count := make([]int, 128)
	countInWindow := make([]int, 128)

	for i := range t {
		count[t[i]]++
	}

	l := 0
	r := 0
	countInWindow[s[l]]++
	smallerWindow := len(s)
	smallL := l
	smallR := r
	validFound := false
	for l <= r && r < len(s) {
		if isValid(count, countInWindow) {
			validFound = true
			if r-l < smallerWindow {
				smallerWindow = r - l
				smallL = l
				smallR = r
			}
			countInWindow[s[l]]--
			l++
		} else {
			r++
			if r < len(s) {
				countInWindow[s[r]]++
			}
		}
	}
	if validFound {
		return s[smallL : smallR+1]
	}
	return ""
}
