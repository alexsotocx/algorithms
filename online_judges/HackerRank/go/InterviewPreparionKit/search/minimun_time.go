package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// Complete the minTime function below.
func calculate(m []uint64, d uint64) uint64 {
	total := uint64(0)
	for _, v := range m {
		total += d / v
	}
	return total
}

func minTime(machines []uint64, goal uint64) uint64 {
	low := uint64(1)
	hi := uint64((1 << 63) + 1)
	for low < hi {
		mid := (low + hi) / 2
		if calculate(machines, mid) >= goal {
			hi = mid
		} else {
			low = mid + 1
		}
	}
	return hi
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	nGoal := strings.Split(readLine(reader), " ")

	nTemp, err := strconv.ParseInt(nGoal[0], 10, 64)
	checkError(err)
	n := int32(nTemp)

	goal, err := strconv.ParseInt(nGoal[1], 10, 64)
	checkError(err)

	machinesTemp := strings.Split(readLine(reader), " ")

	var machines []uint64

	for i := 0; i < int(n); i++ {
		machinesItem, err := strconv.ParseInt(machinesTemp[i], 10, 64)
		checkError(err)
		machines = append(machines, uint64(machinesItem))
	}

	ans := minTime(machines, uint64(goal))

	fmt.Fprintf(writer, "%d\n", ans)

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
