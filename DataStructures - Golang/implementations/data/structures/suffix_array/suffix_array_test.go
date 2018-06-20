package suffix_array_test

import (
	"fmt"
	"testing"

	"../suffix_array"
)

func TestNew(t *testing.T) {
	str := "banana"
	sufar := suffix_array.New(str)
	fmt.Println(sufar.Show())
}
