package google

func getMinFromMap(m map[byte]int) byte {
	var minc byte
	min := 1 << 20
	for k, v := range m {
		if v < min {
			minc = k
			min = v
		}
	}
	return minc
}

func lengthOfLongestSubstringTwoDistinct(s string) int {
	mc := make(map[byte]int)
	i := 0
	max := 0
	cur := 0
	for i < len(s) {
		c := s[i]
		mc[c] = i
		if len(mc) == 3 {
			delete(mc, getMinFromMap(mc))
			cur = i - mc[getMinFromMap(mc)]
		}
		for i < len(s) && c == s[i] {
			i++
			cur++
		}
		if max < cur {
			max = cur
		}
	}
	return max
}
