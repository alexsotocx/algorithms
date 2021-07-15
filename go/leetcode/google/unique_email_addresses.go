package google

import "strings"

var void = struct{}{}

func NumUniqueEmails(emails []string) int {
	var sb strings.Builder
	var uniqueEmailsSet = make(map[string]struct{})
	for _, email := range emails {
		ignoring := false
		for pos, char := range email {
			if char == '@' {
				sb.WriteString(email[pos:])
				break
			}
			if ignoring {
				continue
			}
			if char == '.' {
				continue
			}
			if char == '+' {
				ignoring = true
				continue
			}
			sb.WriteRune(char)
		}
		emailName := sb.String()
		uniqueEmailsSet[emailName] = void
		sb.Reset()
	}
	return len(uniqueEmailsSet)
}
