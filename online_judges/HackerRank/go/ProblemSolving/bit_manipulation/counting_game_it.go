package bit_manipulation

func getMoreSignficantBit(n uint64) uint64 {
	var x uint64
	for n > 0 {
		x++
		n >>= 1
	}
	return x - 1
}

func isPowerOfTwo(n uint64) bool {
	return (n & (n - 1)) == 0
}

func counterGame(n uint64) string {
	if n == 1 {
		return "Richard"
	}
	counter := 0
	for n != 1 {
		if isPowerOfTwo(n) {
			n /= 2
		} else {
			n -= (uint64(1) << getMoreSignficantBit(n))
		}

		counter++
	}
	if counter%2 == 1 {
		return "Louise"
	}
	return "Richard"
}
