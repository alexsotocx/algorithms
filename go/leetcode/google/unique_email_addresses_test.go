package google_test

import (
	"testing"

	ex "github.com/alexsotocx/algorithms/go/leetcode/google"
	"github.com/stretchr/testify/require"
)

func TestUniqueEmailAddresses(t *testing.T) {
	emails := []string{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}
	require.Equal(t, 2, ex.NumUniqueEmails(emails))
	emails = []string{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"}
	require.Equal(t, 3, ex.NumUniqueEmails(emails))
}
