use std::{
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
};

const TEXT: &str = "XMAS";

const INPUT_FILE: &str = "input/04.txt";

const TEST: &str = "\
.M.S......
..A..MSMS.
.M.S.MAA..
..A.ASMSM.
.M.S.M....
..........
S.S.S.S.S.
.A.A.A.A..
M.M.M.M.M.
..........
";

fn read_file<R: BufRead>(reader: R) -> Result<Vec<String>, Box<dyn Error>> {
    let mut content = Vec::new();
    for line in reader.lines() {
        content.push(line.unwrap());
    }
    Ok(content)
}

fn safe_get(input: &Vec<String>, i: i32, j: i32) -> char {
    if i < 0 || j < 0 {
        return ' ';
    }

    if i >= input.len() as i32 || j >= input[i as usize].len() as i32 {
        return ' ';
    }

    input[i as usize].chars().nth(j as usize).unwrap_or(' ')
}

fn check_horizontal(input: &Vec<String>, i: i32, j: i32) -> i32 {
    let h1 = (0..TEXT.len())
        .all(|f| safe_get(input, i, j + f as i32) == TEXT.chars().nth(f).unwrap())
        .then(|| 1)
        .unwrap_or(0);
    let h2 = (0..TEXT.len())
        .all(|f| safe_get(input, i, j - f as i32) == TEXT.chars().nth(f).unwrap())
        .then(|| 1)
        .unwrap_or(0);

    h1 + h2
}

fn check_vertical(input: &Vec<String>, i: i32, j: i32) -> i32 {
    let v1 = (0..TEXT.len())
        .all(|f| safe_get(input, i + f as i32, j) == TEXT.chars().nth(f).unwrap())
        .then(|| 1)
        .unwrap_or(0);
    let v2 = (0..TEXT.len())
        .all(|f| safe_get(input, i - f as i32, j) == TEXT.chars().nth(f).unwrap())
        .then(|| 1)
        .unwrap_or(0);
    v1 + v2
}

fn check_diagonal(input: &Vec<String>, i: i32, j: i32) -> i32 {
    let d1 = (0..TEXT.len())
        .all(|f| safe_get(input, i + f as i32, j + f as i32) == TEXT.chars().nth(f).unwrap())
        .then(|| 1)
        .unwrap_or(0);
    let d2 = (0..TEXT.len())
        .all(|f| safe_get(input, i - f as i32, j - f as i32) == TEXT.chars().nth(f).unwrap())
        .then(|| 1)
        .unwrap_or(0);

    let d3 = (0..TEXT.len())
        .all(|f| safe_get(input, i + f as i32, j - f as i32) == TEXT.chars().nth(f).unwrap())
        .then(|| 1)
        .unwrap_or(0);

    let d4 = (0..TEXT.len())
        .all(|f| safe_get(input, i - f as i32, j + f as i32) == TEXT.chars().nth(f).unwrap())
        .then(|| 1)
        .unwrap_or(0);

    d1 + d2 + d3 + d4
}

fn part1(input: &Vec<String>) -> i32 {
    let mut result = 0;
    for i in 0..input.len() as i32 {
        for j in 0..input[i as usize].len() as i32 {
            result += check_horizontal(input, i, j);
            result += check_vertical(input, i, j);
            result += check_diagonal(input, i, j);
        }
    }
    result
}

fn part2(input: &Vec<String>) -> i32 {
    let mut result = 0;
    for i in 0..input.len() as i32 {
        for j in 0..input[0].len() as i32 {
            result += check_horizontal(input, i, j);
            result += check_vertical(input, i, j);
            result += check_diagonal(input, i, j);
        }
    }
    result
}

fn main() -> Result<(), Box<dyn Error>> {
    let input_file = BufReader::new(TEST.as_bytes());
    assert_eq!(part1(&read_file(input_file)?), 18);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let input_content = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&input_content));

    Ok(())
}
