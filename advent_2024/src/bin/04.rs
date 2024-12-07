use std::{
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
};

const TEXT: &str = "XMAS";
const TEXT1: &str = "MAS";
const TEXT2: &str = "SAM";

const INPUT_FILE: &str = "input/04.txt";

const TEST: &str = "\
MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX
";

fn read_file<R: BufRead>(reader: R) -> Result<Vec<String>, Box<dyn Error>> {
    let mut content = Vec::new();
    for line in reader.lines() {
        content.push(line.unwrap());
    }
    Ok(content)
}

fn valid_position(input: &Vec<String>, i: i32, j: i32) -> bool {
    i >= 0 && j >= 0 && i < input.len() as i32 && j < input[i as usize].len() as i32
}

fn safe_get(input: &Vec<String>, i: i32, j: i32) -> char {
    if valid_position(input, i, j) {
        return input[i as usize].chars().nth(j as usize).unwrap_or(' ');
    }

    return ' ';
}

fn check_horizontal(input: &Vec<String>, i: i32, j: i32) -> i32 {
    let h1 = check_text_with_direction(input, i, j, TEXT, 0, 1).then(|| 1).unwrap_or(0);
    let h2 = check_text_with_direction(input, i, j, TEXT, 0, -1).then(|| 1).unwrap_or(0);

    h1 + h2
}

fn check_vertical(input: &Vec<String>, i: i32, j: i32) -> i32 {
    let v1 = check_text_with_direction(input, i, j, TEXT, 1, 0).then(|| 1).unwrap_or(0);
    let v2 = check_text_with_direction(input, i, j, TEXT, -1, 0).then(|| 1).unwrap_or(0);

    v1 + v2
}

fn check_diagonal(input: &Vec<String>, i: i32, j: i32) -> i32 {
    let d1 = check_text_with_direction(input, i, j, TEXT, 1, 1).then(|| 1).unwrap_or(0);
    let d2 = check_text_with_direction(input, i, j, TEXT, -1, -1).then(|| 1).unwrap_or(0);
    let d3 = check_text_with_direction(input, i, j, TEXT, 1, -1).then(|| 1).unwrap_or(0);
    let d4 = check_text_with_direction(input, i, j, TEXT, -1, 1).then(|| 1).unwrap_or(0);

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

fn check_text_with_direction(
    input: &Vec<String>,
    i: i32,
    j: i32,
    text: &str,
    d1: i32,
    d2: i32,
) -> bool {
    (0..text.len()).all(|f: usize| {
        safe_get(input, i + (f as i32) * d1, j + (f as i32) * d2) == text.chars().nth(f).unwrap()
    })
}

fn check_xmas(input: &Vec<String>, i: i32, j: i32) -> i32 {
    let h1 = check_text_with_direction(input, i, j, TEXT1, 1, 1);
    let h2 = check_text_with_direction(input, i, j, TEXT2, 1, 1);

    if h1 || h2 {
        let h3 = check_text_with_direction(input, i, j + 2, TEXT1, 1, -1);
        let h4 = check_text_with_direction(input, i, j + 2, TEXT2, 1, -1);

        if h3 || h4 {
            return 1;
        }
    }
    return 0;
}

fn part2(input: &Vec<String>) -> i32 {
    let mut result = 0;
    for i in 0..input.len() as i32 {
        for j in 0..input[0].len() as i32 {
            result += check_xmas(input, i, j)
        }
    }
    result
}

fn main() -> Result<(), Box<dyn Error>> {
    assert_eq!(part1(&read_file(BufReader::new(TEST.as_bytes()))?), 18);
    assert_eq!(part2(&read_file(BufReader::new(TEST.as_bytes()))?), 9);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let input_content = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&input_content));
    println!("Result part 2 = {}", part2(&input_content));

    Ok(())
}
