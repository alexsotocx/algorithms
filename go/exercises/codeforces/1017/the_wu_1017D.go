package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

var reader = bufio.NewReader(os.Stdin)
var writer = bufio.NewWriter(os.Stdout)

func printf(f string, a ...interface{}) { fmt.Fprintf(writer, f, a...) }
func scanf(f string, a ...interface{})  { fmt.Fscanf(reader, f, a...) }
func readLine() string {
	var x string
	x, _ = reader.ReadString('\n')
	return x
}

func main() {
	var n, m, q int
	scanf("%d %d %d\n", &n, &m, &q)
	wu := make([]int, 0)
	for _, v := range strings.Fields(readLine()) {
		vi, _ := strconv.Atoi(v)
		wu = append(wu, vi)
	}

	s := make([]int, 0)
	for m > 0 {
		var x int
		scanf("%b\n", &x)
		s = append(s, x)
		m--
	}
	sort.Ints(s)

	for q > 0 {
		var k, c, xn int
		scanf("%b %d\n", &xn, &k)
		for _, v := range s {
			biton := ^uint(xn ^ v)
			wv := 0
			for i := n - 1; i >= 0; i-- {
				if biton&(1) != 0 {
					wv += wu[i]
				}

				biton >>= 1
			}
			if wv <= k {
				c++
			}
		}

		printf("%d\n", c)
		q--
	}
	writer.Flush()
}
