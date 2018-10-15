package main

import (
    "bufio"
    "fmt"
    "io"
    "os"
    "strconv"
    "strings"
  "math"
)

// Complete the minimumPasses function below.
func buy(c, m, w, p uint64) (float64, uint64, uint64) {

  if w != m {
    if p * (m - w) > c {
      w += c / p
      c -= (c / p) * p
    } else {
      c -= p * (m - w)
      w = m
    }
  }
  t := c / p
  c -= t * p
  w += t / 2
  m += t - t/2

  return float64(c), m, w
}

func minimumPasses(m , w , p , n uint64) uint64 {
  var days uint64
  var c, nn float64
  nn = float64(n)
  if m < w {
    t := m
    m = w
    w = t
  }
  for c < nn {
    c0, m0, w0 := buy(uint64(c), m, w, p)
    if ((nn - c0) / (float64(m0) * float64(w0)) ) > ((nn - c)/ (float64(m) * float64(w) ) ) {
      return days + uint64(math.Ceil((nn - c) / (float64(m) * float64(w))))

    }

    c = c0
    m = m0
    w = w0
    d := uint64(math.Ceil((float64(p) - c) / (float64(m) * float64(w))))
    days+= d
    c += (float64(m) * float64(w)) * float64(d)
    /*days++
    c += m* w */
  }
  return days
}

func main() {
    reader := bufio.NewReaderSize(os.Stdin, 1024 * 1024)

    stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
    checkError(err)

    defer stdout.Close()

    writer := bufio.NewWriterSize(stdout, 1024 * 1024)

    mwpn := strings.Split(readLine(reader), " ")

    m, err := strconv.ParseInt(mwpn[0], 10, 64)
    checkError(err)

    w, err := strconv.ParseInt(mwpn[1], 10, 64)
    checkError(err)

    p, err := strconv.ParseInt(mwpn[2], 10, 64)
    checkError(err)

    n, err := strconv.ParseInt(mwpn[3], 10, 64)
    checkError(err)

  result := minimumPasses(uint64(m), uint64(w), uint64(p), uint64(n))

    fmt.Fprintf(writer, "%d\n", result)

    writer.Flush()
}

func readLine(reader *bufio.Reader) string {
    str, _, err := reader.ReadLine()
    if err == io.EOF {
        return ""
    }

    return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
    if err != nil {
        panic(err)
    }
}
