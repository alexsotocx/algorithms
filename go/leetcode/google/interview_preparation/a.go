package google

import (
	"fmt"
	"strings"
)

/*
	Create a function that works similar to node js path.resolve
	examples:
	args string[] = {"/usr/user_a/home", "..", "desktop", "../.."} -> "/usr"
	args string[] = {"/usr/user_a/home", "..", "desktop", "../..", "user_b"} -> "/usr/user_b"
*/

func resolve(args ...string) (string, error) {
	path := make([]string, 0)
	for _, p := range args {
		fields := strings.Split(p, "/")
		for _, f := range fields {
			if f == "" {
				continue
			} else if f != ".." {
				path = append(path, f)
			} else {
				if len(path) == 0 {
					return "", fmt.Errorf("invalid path was given")
				}
				path = path[:len(path)-1]
			}
		}
	}

	if len(path) == 0 {
		return "/", nil
	}
	return fmt.Sprintf("/%s", strings.Join(path, "/")), nil
}
