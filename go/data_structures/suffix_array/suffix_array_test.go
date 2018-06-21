package suffix_array_test

import (
	"fmt"
	"testing"

	"github.com/alexsotocx/algorithms/go/data_structures/suffix_array"
)

func TestNew(t *testing.T) {
	str := "GATAGACA$"
	sufar := suffix_array.New(str)
	fmt.Println(sufar.Show())
}
