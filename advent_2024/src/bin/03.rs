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
    let mut l1 = String::new();
    for line in reader.lines() {
        l1.push_str(&line?);
    }
    Ok(l1)
}


fn part1(l1: String) -> i32 {
    let re = Regex::new(r"mul\((\d+,\d+)\)").unwrap();
    let mut res = 0;
    for cap in re.captures_iter(&l1) {
        let mut l2 = cap[1].split(",");
        let a: i32 = l2.next().unwrap().parse().unwrap();
        let b: i32 = l2.next().unwrap().parse().unwrap();
        res += a * b;
    }
    return res;
}


fn part2(l1: String) -> i32 {
    let re = Regex::new(r"do\(\)|don\'t\(\)").unwrap();
    let mut res = 0;
    let mut enabled = true;
    let mut last_instruction_pos = 0;
    for cap in re.captures_iter(&l1) {
        let instruction = &cap[0];
        let end = cap.get(0).unwrap().end();
        if enabled {
            let l2 = &l1[last_instruction_pos..end];
            res += part1(l2.to_string());
        }
        if instruction == "do()" {
            enabled = true;
        } else {
            enabled = false;
        }
        last_instruction_pos = end;
    }

    if enabled {
        res += part1(l1[last_instruction_pos..].to_string());
    }
    return res;
}
fn main() -> Result<(), Box<dyn Error>> {
    // assert_eq!(161, part1(l1));

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let l1 = read_file(input_file)?;
    println!("Result part 1 = {}", part1(l1.clone()));


    // part 2
    let test_data = BufReader::new(TEST.as_bytes());
    let test = read_file(test_data)?;
    assert_eq!(48, part2(test));
    println!("Result part 2 = {}", part2(l1.clone()));

    Ok(())
}
