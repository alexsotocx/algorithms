package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

type pair struct {
	x, y int
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	var strB strings.Builder
	var cases int
	fmt.Fscanf(reader, "%d\n", &cases)
	for i := 1; i <= cases; i++ {
		var n int
		fmt.Fscanf(reader, "%d\n", &n)
		countMin := 0
		minS := n + 1
		horizontalWin := make([]int, n)
		horizontalSets := make([][]pair, n)
		verticalWin := make([]int, n)
		verticalSets := make([][]pair, n)
		var str string
		for j := 0; j < n; j++ {
			fmt.Fscanf(reader, "%s\n", &str)
			for k, p := range str {
				if p == 'O' {
					horizontalWin[j] = -1
					verticalWin[k] = -1
				} else if p == '.' {
					if horizontalWin[j] != -1 {
						horizontalWin[j]++
						horizontalSets[j] = append(horizontalSets[j], pair{j, k})
					}
					if verticalWin[k] != -1 {
						verticalWin[k]++
						verticalSets[k] = append(verticalSets[k], pair{j, k})
					}
				}
			}
		}

		for j := 0; j < n; j++ {
			v := verticalWin[j]
			vSet := verticalSets[j]
			if v != -1 {
				if v < minS {
					minS = v
					countMin = 1
				} else if v == minS {
					countMin++
				}
			}

			h := horizontalWin[j]
			hSet := horizontalSets[j]
			if h != -1 {

				if h < minS {
					minS = h
					countMin = 1
				} else if h == minS {
					if h == 1 && v == 1 && hSet[0] == vSet[0] {
						continue
					}
					countMin++
				}
			}
		}

		if countMin != 0 {
			fmt.Fprintf(&strB, "Case #%d: %d %d\n", i, minS, countMin)
		} else {
			fmt.Fprintf(&strB, "Case #%d: Impossible\n", i)
		}
	}
	fmt.Print(strB.String())
}
