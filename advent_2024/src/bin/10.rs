use std::{
    cmp,
    collections::{HashSet, VecDeque},
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
    vec,
};

const INPUT_FILE: &str = "input/10.txt";

const TEST: &str = "\
89010123
78121874
87430965
96549874
45678903
32019012
01329801
10456732
";

type TestCase = Vec<Vec<i32>>;
const DIRECTIONS: [(i32, i32); 4] = [
    (-1, 0),
    (0, -1),
    (0, 1),
    (1, 0),
];

fn read_file<R: BufRead>(reader: R) -> Result<TestCase, Box<dyn Error>> {
    let mut result = vec![];
    for line in reader.lines() {
        result.push(line.unwrap().chars().map(|c| c.to_digit(10).unwrap() as i32).collect());
    }
    Ok(result)
}

fn dfs(case: &TestCase, i: i32, j: i32, result: &mut i32, visited: &mut HashSet<(i32, i32)>) {
    if case[i as usize][j as usize] == 9 && !visited.contains(&(i, j)) {
        *result += 1;
        visited.insert((i, j));
    }
    for (di, dj) in DIRECTIONS.iter() {
        let ni = i + di;
        let nj = j + dj;
        if ni < 0 || nj < 0 || ni >= case.len() as i32 || nj >= case[0].len() as i32 {
            continue;
        }
        if case[ni as usize][nj as usize] != case[i as usize][j as usize] + 1{
            continue;
        }
        dfs(case, ni, nj, result, visited)
    }
}

fn part1(test_cases: &TestCase) -> i32 {
    let mut result = 0;

    for i in 0..test_cases.len() {
        for j in 0..test_cases[i].len() {
            if test_cases[i][j] == 0 {
                dfs(test_cases, i as i32, j as i32, &mut result, &mut HashSet::new());
            }
        }
    }

    return result;
}


fn part2(test_cases: &TestCase) -> i128 {
    return 0;
}

fn main() -> Result<(), Box<dyn Error>> {
    let test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part1(&test_case), 36);
    // assert_eq!(part2(&test_case), 2858);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let test_case = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&test_case));
    // println!("Result part 2 = {}", part2(&test_case));

    Ok(())
}

//6350141442586
