use std::{
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
};

use regex::Regex;

const INPUT_FILE: &str = "input/03.txt";

const TEST: &str = "\
xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
";

fn read_file<R: BufRead>(reader: R) -> Result<String, Box<dyn Error>> {
    let mut content = String::new();
    for line in reader.lines() {
        content.push_str(&line?);
    }
    Ok(content)
}

fn part1(input: &str) -> i32 {
    let re = Regex::new(r"mul\((\d+),(\d+)\)").unwrap();
    re.captures_iter(input)
        .map(|cap| {
            let a: i32 = cap[1].parse().unwrap();
            let b: i32 = cap[2].parse().unwrap();
            a * b
        })
        .sum()
}

fn part2(input: &str) -> i32 {
    let re = Regex::new(r"do\(\)|don\'t\(\)").unwrap();
    let mut result = 0;
    let mut enabled = true;
    let mut last_pos = 0;

    for cap in re.captures_iter(input) {
        let instruction = &cap[0];
        let end = cap.get(0).unwrap().end();

        if enabled {
            result += part1(&input[last_pos..end]);
        }

        enabled = instruction == "do()";
        last_pos = end;
    }

    if enabled {
        result += part1(&input[last_pos..]);
    }

    result
}

fn main() -> Result<(), Box<dyn Error>> {
    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let input_content = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&input_content));

    let test_data = BufReader::new(TEST.as_bytes());
    let test_content = read_file(test_data)?;
    assert_eq!(48, part2(&test_content));
    println!("Result part 2 = {}", part2(&input_content));

    Ok(())
}
