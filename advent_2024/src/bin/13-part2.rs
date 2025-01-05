use regex::Regex;

use std::{
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
    vec,
};

const INPUT_FILE: &str = "input/13.txt";

const TEST: &str = "\
Button A: X+94, Y+34
Button B: X+22, Y+67
Prize: X=8400, Y=5400

Button A: X+26, Y+66
Button B: X+67, Y+21
Prize: X=12748, Y=12176

Button A: X+17, Y+86
Button B: X+84, Y+37
Prize: X=7870, Y=6450

Button A: X+69, Y+23
Button B: X+27, Y+71
Prize: X=18641, Y=10279
";


#[derive(Debug)]
struct Input {
    a: (i64, i64),
    b: (i64, i64),
    z: (i64, i64),
}

type TestCase = Vec<Input>;

fn parse_line(s: &String) -> (i64, i64) {
    let re = Regex::new(r"X\+?\=?(\d+), Y\+?\=?(\d+)").unwrap();
    let caps = re.captures(s).unwrap();
    (caps[1].parse().unwrap(), caps[2].parse().unwrap())
}

fn read_file<R: BufRead>(reader: R) -> Result<TestCase, Box<dyn Error>> {
    let mut result: TestCase = vec![];
    let mut l = reader.lines().peekable();
    while l.peek().is_some() {
        let a = l.next().unwrap().unwrap();
        let b = l.next().unwrap().unwrap();
        let p = l.next().unwrap().unwrap();
        let x = parse_line(&p);
        result.push(Input {
            a: parse_line(&a),
            b: parse_line(&b),
            z: (x.0  + 10000000000000, x.1 + 10000000000000)
            // z: (x.0 + 0, x.1 + 0),
        });

        l.next();
    }

    Ok(result)
}

fn solve(input: &Input) -> i64 {
    let x1 = input.a.0;
    let x2 = input.b.0;
    let y1 = input.a.1;
    let y2 = input.b.1;
    let z1 = input.z.0;
    let z2 = input.z.1;
    let b = (x1 * z2 - y1 * z1) / (x1 * y2 - x2 * y1);

    let a = (z1 - x2 * b) / x1;

    // if a > 100 || b > 100 {
    //     return 0;
    // }

    if x1*a + x2*b != z1 || y1*a + y2 * b != z2 {
        return 0;
    }

    return a*3 + b;
}

fn part1(test_case: &TestCase) -> i64 {
    return test_case
        .iter()
        .map(|i| {
            solve(i)
        })
        .sum();
}

fn main() -> Result<(), Box<dyn Error>> {
    let test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    // assert_eq!(part1(&test_case), 480);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let test_case = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&test_case));

    Ok(())
}
