package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

type pair struct {
	c     byte
	count int
	sub   int
}

const mod = 1000000007

func solve(reader *bufio.Reader) int {
	var n int
	fmt.Fscan(reader, &n)
	var task string
	fmt.Fscan(reader, &task)
	p := -1
	total := 0
	N := len(task)
	for i, c := range task {
		if c == 'F' {
			continue
		}
		if p != -1 && byte(c) != task[p] {
			total = (total + ((p+1)*(N-i))%mod) % mod
		}
		p = i
	}

	return total
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	var strB strings.Builder
	var cases int
	fmt.Fscan(reader, &cases)
	for i := 1; i <= cases; i++ {
		strB.WriteString(fmt.Sprintf("Case #%d: %d\n", i, solve(reader)))
	}
	fmt.Print(strB.String())
}
