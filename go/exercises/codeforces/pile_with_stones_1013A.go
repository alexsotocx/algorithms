package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	var n int
	fmt.Scanf("%d\n", &n)
	sum1 := 0
	sum2 := 0
	reader := bufio.NewReader(os.Stdin)
	s1, _ := reader.ReadString('\n')
	s2, _ := reader.ReadString('\n')

	for _, v := range strings.Fields(s1) {
		x, _ := strconv.Atoi(v)
		sum1 += x
	}
	for _, v := range strings.Fields(s2) {
		x, _ := strconv.Atoi(v)
		sum2 += x
	}

	if sum1 >= sum2 {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}
