package google

/**
 * The read4 API is already defined for you.
 *
 *     read4 := func(buf4 []byte) int
 *
 * // Below is an example of how the read4 API can be called.
 * file := File("abcdefghijk") // File is "abcdefghijk", initially file pointer (fp) points to 'a'
 * buf4 := make([]byte, 4) // Create buffer with enough space to store characters
 * read4(buf4) // read4 returns 4. Now buf = ['a','b','c','d'], fp points to 'e'
 * read4(buf4) // read4 returns 4. Now buf = ['e','f','g','h'], fp points to 'i'
 * read4(buf4) // read4 returns 3. Now buf = ['i','j','k',...], fp points to end of file
 */

func maxAB(a, b int) int {
	if a < b {
		return b
	}
	return a
}

var solution = func(read4 func([]byte) int) func([]byte, int) int {
	totalFile := make([]byte, 0)
	readUntil := 0
	return func(buf []byte, n int) int {
		charRead := 0
		toRead := maxAB(n-len(totalFile)-readUntil, 0)
		reads := toRead / 4
		if (toRead % 4) != 0 {
			reads++
		}
		mybuf := make([]byte, 4)
		for reads > 0 {
			read := read4(mybuf)
			for i := 0; i < read; i++ {
				totalFile = append(totalFile, mybuf[i])
			}
			if read < 4 {
				break
			}
			reads--
		}
		for i := 0; i < n && readUntil+i < len(totalFile); i++ {
			buf[i] = totalFile[i+readUntil]
			charRead++
		}
		readUntil += charRead

		return charRead
	}
}
