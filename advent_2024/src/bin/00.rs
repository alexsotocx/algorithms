const DAY: &str = "01"; // TODO: Fill the day
const INPUT_FILE: &str = concatcp!("input/", DAY, ".txt");


const TEST: &str = "\
<TEST-INPUT>
"; // TODO: Add the test input


fn main() -> Result<()> {
   start_day(DAY);


   //region Part 1
   println!("=== Part 1 ===");


   fn part1<R: BufRead>(reader: R) -> Result<usize> {
       // TODO: Solve Part 1 of the puzzle
       let answer = reader.lines().flatten().count();
       Ok(answer)
   }


   // TODO: Set the expected answer for the test input
   assert_eq!(0, part1(BufReader::new(TEST.as_bytes()))?);


   let input_file = BufReader::new(File::open(INPUT_FILE)?);
   let result = time_snippet!(part1(input_file)?);
   println!("Result = {}", result);
   //endregion


   //Part 2


   Ok(())
}
