package google

import (
	"fmt"
	"strings"
)

/*
	Create a function to simulate change directory(cd) in your terminal, we want to find
	in which folder you end up.

	Given a an array of paths where you will use cd path[i], find the result folder

	Input:

	paths string[], where paths[i] is a valid path.
	paths[0] = will be your start folder, so it will be a valid path directory.

	example 1:
	paths[] = {"/usr/user_a/home", "..", "desktop", "../.."} -> "/usr"
	explanation:
	cd /usr/user_a/home  -> current path "/usr/user_a/home"
	cd .. -> go up one folder, current path "/usr/user_a/"
	cd desktop -> move to folder desktop, current path "/usr/user_a/desktop"
	cd "../.." -> move two folders up, current path "/usr"

	example 2:
	args string[] = {"/usr/user_a/home", "..", "desktop/../../user_b",} -> "/usr/user_b"
	cd /usr/user_a/home  -> current path "/usr/user_a/home"
	cd .. -> go up one folder, current path "/usr/user_a/"
	cd "desktop/../../user_b" -> move to folder desktop, current path "/usr/user_a/desktop", then move two folders up "/usr/", then move to user_b "/usr/user_b"
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
