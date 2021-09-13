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
			h := horizontalWin[j]
			if v != -1 {
				minS = min(v, minS)
			}
			if h != -1 {
				minS = min(h, minS)
			}
		}
		sols := make([][]pair, 0)
		for j := 0; j < n; j++ {
			v := verticalWin[j]
			h := horizontalWin[j]
			if v != -1 && v == minS {
				sols = append(sols, verticalSets[j])
			}
			if h != -1 && h == minS {
				sols = append(sols, horizontalSets[j])
			}
		}

		if len(sols) != 0 {
			countMin := len(sols)
			if minS == 1 {
				unique := make(map[pair]struct{})
				for _, s := range sols {
					unique[s[0]] = struct{}{}
				}
				countMin = len(unique)
			}
			fmt.Fprintf(&strB, "Case #%d: %d %d\n", i, minS, countMin)
		} else {
			fmt.Fprintf(&strB, "Case #%d: Impossible\n", i)
		}
	}
	fmt.Print(strB.String())
}
