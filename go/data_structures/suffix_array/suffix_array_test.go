package suffix_array_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/data_structures/suffix_array"
)

func TestNew(t *testing.T) {
	str := "GATAGACA$"
	sArray := suffix_array.New(str)
	expected := []string{"$", "A$", "ACA$", "AGACA$", "ATAGACA$", "CA$", "GACA$", "GATAGACA$", "TAGACA$"}
	output := sArray.Show()

	for i, v := range output {
		if v != expected[i] {
			t.Fatalf("Expected %s, got %s", expected[i], v)
		}
	}

}
