package main

import (
	"fmt"
	"strings"
)

func main() {
	var strB strings.Builder
	var cases int
	fmt.Scan(&cases)
	for i := 1; i <= cases; i++ {
		var n int
		fmt.Scan(&n)
		changes := 0
		p := -1
		var task string
		fmt.Scan(&task)
		for i, c := range task {
			if c == 'F' {
				continue
			}
			if p != -1 && task[p] != byte(c) {
				changes++
			}
			p = i
		}
		strB.WriteString(fmt.Sprintf("Case #%d: %d\n", i, changes))

	}
	fmt.Print(strB.String())
}
