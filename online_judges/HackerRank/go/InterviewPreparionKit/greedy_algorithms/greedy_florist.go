package greedy_algorithms

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"sort"
	"strconv"
	"strings"
)

// Complete the getMinimumCost function below.
func getMinimumCost(k int, c []int) int {
	sort.Ints(c)
	cost := 0
	for i := 0; i < len(c); i++ {
		v := len(c) - 1 - i
		cost += (i/k + 1) * c[v]
	}
	return cost
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	nk := strings.Split(readLine(reader), " ")

	nTemp, err := strconv.ParseInt(nk[0], 10, 64)
	checkError(err)
	n := int32(nTemp)

	kTemp, err := strconv.ParseInt(nk[1], 10, 64)
	checkError(err)
	k := int(kTemp)

	cTemp := strings.Split(readLine(reader), " ")

	var c []int

	for i := 0; i < int(n); i++ {
		cItemTemp, err := strconv.ParseInt(cTemp[i], 10, 64)
		checkError(err)
		cItem := int(cItemTemp)
		c = append(c, cItem)
	}

	minimumCost := getMinimumCost(k, c)

	fmt.Fprintf(writer, "%d\n", minimumCost)

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
