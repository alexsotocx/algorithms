package google

func longestOddSub(s *string, mid int) int {
	x := 0
	n := len(*s)
	for mid-x >= 0 && mid+x < n && (*s)[mid-x] == (*s)[mid+x] {
		x++
	}
	return x - 1
}

func longestEvenSub(s *string, mid int) int {
	x := 0
	n := len(*s)
	for mid-x >= 0 && mid+x+1 < n {
		if (*s)[mid-x] != (*s)[mid+x+1] {
			break
		}
		x++
	}
	return x
}

func longestPalindrome(s string) string {
	start := 0
	end := 0
	for mid := range s {
		x := longestOddSub(&s, mid)
		l := 2*x + 1
		if l > end-start+1 {
			start = mid - x
			end = mid + x
		}
		x = longestEvenSub(&s, mid)
		l = 2 * x
		if l > end-start+1 {
			start = mid - x + 1
			end = mid + x
		}
	}
	return s[start : end+1]
}
