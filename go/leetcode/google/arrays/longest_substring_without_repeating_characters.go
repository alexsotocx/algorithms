package google

func LengthOfLongestSubstring(s string) int {
	startOfSubString := 0
	maxSubstring := 0
	charsInSubstring := make(map[rune]int)
	// [startOfSubString, i)
	for i, c := range s {
		if posRepeated, ok := charsInSubstring[c]; ok {
			if startOfSubString <= posRepeated {
				startOfSubString = posRepeated + 1
			}
		}
		currentSubLength := i - startOfSubString + 1
		if maxSubstring < currentSubLength {
			maxSubstring = currentSubLength
		}
		charsInSubstring[c] = i
	}

	return maxSubstring
}
