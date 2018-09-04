package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// Complete the substrCount function below.
func substrCount(n int, s string) int64 {
	count := int64(0)
	for i := n - 1; i >= 0; i-- {
		for j := 1; j <= n; j++ {
			di := i + j
			dj := i - j
			if di >= n || dj < 0 || s[di] != s[dj] {
				break
			}
			count++
		}

		for j := 0; j <= n; j++ {
			di := i + j
			if di >= n || s[di] != s[i] {
				break
			}
			count++
		}
	}
	return count
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	nTemp, err := strconv.ParseInt(readLine(reader), 10, 64)
	checkError(err)
	n := int(nTemp)

	s := readLine(reader)

	result := substrCount(n, s)

	fmt.Fprintf(writer, "%d\n", result)

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
