package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"sort"
	"strconv"
	"strings"
)

// Complete the triplets function below.
func upperBound(arr []int, x int) int {
	var low, hi, mid int
	hi = len(arr) - 1
	for low < hi {
		mid = (low + hi) / 2
		if x < arr[mid] {
			hi = mid
		} else {
			low = mid + 1
		}
	}
	if arr[hi] <= x {
		return hi + 1
	}
	return hi
}
func deleteRepeated(arr []int) []int {
	h := make(map[int]bool)
	ret := make([]int, 0)
	for _, v := range arr {
		if !h[v] {
			ret = append(ret, v)
		}
		h[v] = true
	}
	return ret
}

func triplets(a, b, c []int) int64 {
	a = deleteRepeated(a)
	b = deleteRepeated(b)
	c = deleteRepeated(c)
	sort.Ints(a)
	sort.Ints(c)
	count := int64(0)
	for _, v := range b {
		count += int64(upperBound(a, v)) * int64(upperBound(c, v))
	}

	return count
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	lenaLenbLenc := strings.Split(readLine(reader), " ")

	lenaTemp, err := strconv.ParseInt(lenaLenbLenc[0], 10, 64)
	checkError(err)
	lena := int(lenaTemp)

	lenbTemp, err := strconv.ParseInt(lenaLenbLenc[1], 10, 64)
	checkError(err)
	lenb := int(lenbTemp)

	lencTemp, err := strconv.ParseInt(lenaLenbLenc[2], 10, 64)
	checkError(err)
	lenc := int(lencTemp)

	arraTemp := strings.Split(readLine(reader), " ")

	var arra []int

	for i := 0; i < int(lena); i++ {
		arraItemTemp, err := strconv.ParseInt(arraTemp[i], 10, 64)
		checkError(err)
		arraItem := int(arraItemTemp)
		arra = append(arra, arraItem)
	}

	arrbTemp := strings.Split(readLine(reader), " ")

	var arrb []int

	for i := 0; i < int(lenb); i++ {
		arrbItemTemp, err := strconv.ParseInt(arrbTemp[i], 10, 64)
		checkError(err)
		arrbItem := int(arrbItemTemp)
		arrb = append(arrb, arrbItem)
	}

	arrcTemp := strings.Split(readLine(reader), " ")

	var arrc []int

	for i := 0; i < int(lenc); i++ {
		arrcItemTemp, err := strconv.ParseInt(arrcTemp[i], 10, 64)
		checkError(err)
		arrcItem := int(arrcItemTemp)
		arrc = append(arrc, arrcItem)
	}

	ans := triplets(arra, arrb, arrc)

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
