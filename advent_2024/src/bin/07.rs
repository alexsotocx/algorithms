use std::{
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
};

const INPUT_FILE: &str = "input/07.txt";

const TEST: &str = "\
190: 10 19
3267: 81 40 27
83: 17 5
156: 15 6
7290: 6 8 6 15
161011: 16 10 13
192: 17 8 14
21037: 9 7 18 13
292: 11 6 16 20
";


fn read_file<R: BufRead>(reader: R) -> Result<Vec<(i64, Vec<i64>)>, Box<dyn Error>> {
    let test_lines: Vec<(i64, Vec<i64>)> = reader
        .lines()
        .map(|line| {
            let line = line.expect("Failed to read line");
            let mut parts = line.split(": ");
            let key = parts.next().expect("Failed to parse key").parse().expect("Failed to parse key as i32");
            let values = parts
                .next()
                .expect("Failed to parse values")
                .split_whitespace()
                .map(|v| v.parse().expect("Failed to parse value as i32"))
                .collect();
            (key, values)
        })
        .collect();

    Ok(test_lines)
}

fn solve_part_1(target: i64, values: &Vec<i64>, i: usize, current: i64) -> bool {
    if i == values.len() {
        return target == current;
    }

    if solve_part_1(target, values, i + 1, current + values[i]) {
        return true;
    }
    if solve_part_1(target, values, i + 1, current * values[i]) {
        return true;
    }
    false
}

fn part1(test_cases: &Vec<(i64, Vec<i64>)>) -> i64 {
    let mut sum = 0;
    for (target, values) in test_cases {
        if solve_part_1(*target, &values, 0, 0) {
            sum += target;
        }
    }
    sum
}


fn main() -> Result<(), Box<dyn Error>> {
    let test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part1(&test_case), 3749);
    // assert_eq!(part2(&rules, &test_cases), 123);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let mut test_case = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&mut test_case));
    // println!("Result part 2 = {}", part2(&test_cases));

    Ok(())
}
