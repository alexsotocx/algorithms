use std::{error::Error, fs::File, io::{BufRead, BufReader}};

const INPUT_FILE: &str = "input/01.txt"; // Changed to concat! macro

const TEST: &str = "\
3   4
4   3
2   5
1   3
3   9
3   3
"; // TODO: Add the test input

fn main() -> Result<(), Box<dyn Error>> {
    //region Part 1
    println!("=== Part 1 ===");

    fn part1<R: BufRead>(reader: R) -> Result<i32, Box<dyn Error>> {
      let lines = reader.lines();
      let mut l1: Vec<i32> = vec![];
      let mut l2: Vec<i32> = vec![];
      for l in lines {
        let line = l?;
        let mut it = line.split_whitespace();
        l1.push(it.next().ok_or("Missing value")?.parse()?);
        l2.push(it.next().ok_or("Missing value")?.parse()?);
      }
      l1.sort_unstable();
      l2.sort_unstable();
      let mut res = 0;
      for i in 0..l1.len() {
        res += (l1[i] - l2[i]).abs();
      }

      Ok(res)
    }

    // TODO: Set the expected answer for the test input
    assert_eq!(11, part1(BufReader::new(TEST.as_bytes()))?);

    // Uncomment to use the input file
     let input_file = BufReader::new(File::open(INPUT_FILE)?);
     println!("Result = {}", part1(input_file)?);

    //endregion

    //Part 2

    Ok(())
}
