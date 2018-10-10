package bit_manipulation

import (
	"math/bits"
)

func getMoreSignficantBit(n int64) int64 {
	var x int64
	for n > 0 {
		x++
		n >>= 1
	}
	return x - 1
}

func counterGame(n int64) string {
	ones := int64(bits.OnesCount64(uint64(n)))
	posLeast := getMoreSignficantBit(n & -n)
	counter := ones - 1 + posLeast
	if counter%2 == 1 {
		return "Louise"
	}
	return "Richard"
}
