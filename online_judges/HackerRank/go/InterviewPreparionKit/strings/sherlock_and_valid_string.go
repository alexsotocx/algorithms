package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strings"
)

// Complete the isValid function below.
func isValid(s string) string {
	count := make([]int, 'z'-'a'+1)
	for _, v := range s {
		v -= 'a'
		count[v]++
	}
	diffFre := make(map[int]int)
	for _, v := range count {
		if v == 0 {
			continue
		}
		diffFre[v] = diffFre[v] + 1
	}

	if len(diffFre) == 1 {
		return "YES"
	}

	if len(diffFre) == 2 {
		keys := make([]int, 0)
		for k := range diffFre {
			keys = append(keys, k)
		}

		if diffFre[keys[0]] == 1 && (keys[0]-1 == keys[1] || keys[0]-1 == 0) {
			return "YES"
		}
		if diffFre[keys[1]] == 1 && (keys[1]-1 == keys[0] || keys[1]-1 == 0) {
			return "YES"
		}
	}
	return "NO"
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	s := readLine(reader)

	result := isValid(s)

	fmt.Fprintf(writer, "%s\n", result)

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
