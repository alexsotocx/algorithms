package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

var reader = bufio.NewReader(os.Stdin)
var writer = bufio.NewWriter(os.Stdout)

func printf(f string, a ...interface{}) { fmt.Fprintf(writer, f, a...) }
func scanf(f string, a ...interface{})  { fmt.Fscanf(reader, f, a...) }

type student struct {
	id, score int
}

func main() {
	var n, a, b, c, d int
	scanf("%d\n", &n)
	students := make([]*student, n)
	for i := 0; i < n; i++ {
		scanf("%d %d %d %d\n", &a, &b, &c, &d)
		students[i] = &student{id: i, score: a + b + c + d}
	}

	sort.Slice(students, func(i, j int) bool {
		if students[i].score != students[j].score {
			return students[i].score > students[j].score
		}
		return students[i].id < students[j].id
	})

	for i, s := range students {
		if s.id == 0 {
			printf("%d\n", i+1)
			break
		}
	}

	writer.Flush()
}
