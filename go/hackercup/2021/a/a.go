package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

var vocals = [5]byte{'A', 'E', 'I', 'O', 'U'}

func isVocal(c byte) bool {
	for _, v := range vocals {
		if v == c {
			return true
		}
	}
	return false
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func solve(str string) int {
	vocalsCount := 0
	consonantsCount := 0
	count := ['Z' - 'A' + 1]int{}
	maxVocal := byte(0)
	maxConsonant := byte(1)
	for i := range str {
		c := str[i] - 'A'
		count[c]++
		if isVocal(str[i]) {
			vocalsCount++
			if count[c] > count[maxVocal] {
				maxVocal = c
			}
		} else {
			consonantsCount++
			if count[c] > count[maxConsonant] {
				maxConsonant = c
			}
		}
	}
	convertToVocals := (vocalsCount-count[maxVocal])*2 + consonantsCount
	convertToConsonants := (consonantsCount-count[maxConsonant])*2 + vocalsCount

	return min(convertToConsonants, convertToVocals)
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	var strB strings.Builder
	var cases int
	fmt.Fscanf(reader, "%d\n", &cases)

	for i := 1; i <= cases; i++ {
		var str string
		fmt.Fscanf(reader, "%s\n", &str)
		fmt.Fprintf(&strB, "Case #%d: %d\n", i, solve(str))
	}
	fmt.Print(strB.String())
}
