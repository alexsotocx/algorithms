package main

import (
	"bufio"
	"fmt"
	"os"
)

var reader = bufio.NewReader(os.Stdin)
var writer = bufio.NewWriter(os.Stdout)

func printf(f string, a ...interface{}) { fmt.Fprintf(writer, f, a...) }
func scanf(f string, a ...interface{})  { fmt.Fscanf(reader, f, a...) }
func ways(a, b string) int64 {
	var s10, s00, one, zero int64
	for i, v := range a {
		bc := b[i]
		if v == '0' {
			zero++
		} else {
			one++
		}
		if v == '0' && bc == '0' {
			s00++
		}
		if v == '1' && bc == '0' {
			s10++
		}
	}
	return s10*(zero-s00) + s00*one
}

func main() {
	var n int
	var a, b string
	scanf("%d\n%s\n%s\n", &n, &a, &b)
	printf("%d\n", ways(a, b))

	writer.Flush()
}
