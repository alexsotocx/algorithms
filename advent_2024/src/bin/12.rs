use std::{
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
    vec,
};

const INPUT_FILE: &str = "input/12.txt";

const TEST: &str = "\
RRRRIICCFF
RRRRIICCCF
VVRRRCCFFF
VVRCCCJFFF
VVVVCJJCFE
VVIVCCJJEE
VVIIICJJEE
MIIIIIJJEE
MIIISIJEEE
MMMISSJEEE
";

const DIRECTIONS: [(i32, i32); 4] = [(-1, 0), (0, -1), (0, 1), (1, 0)];

type TestCase = Vec<Vec<char>>;

fn read_file<R: BufRead>(reader: R) -> Result<TestCase, Box<dyn Error>> {
    let mut result: TestCase = vec![];
    for line in reader.lines() {
        result.push(line.unwrap().chars().collect());
    }

    Ok(result)
}

fn flood_filling(
    i: i32,
    j: i32,
    test_case: &TestCase,
    visited: &mut Vec<Vec<bool>>,
) -> (i32, i32) {
    let mut area = 1;
    let mut permieter = 0;
    visited[i as usize][j as usize] = true;

    for dir in DIRECTIONS {
        let di = i + dir.0;
        let dj = j + dir.1;
        let inside =
            di >= 0 && di < test_case.len() as i32 && dj >= 0 && dj < test_case[0].len() as i32;
        if inside {
            if test_case[i as usize][j as usize] != test_case[di as usize][dj as usize] {
                permieter += 1;
            } else if !visited[di as usize][dj as usize] {
                let (r_area, r_permiter) = flood_filling(di, dj, test_case, visited);
                area += r_area;
                permieter += r_permiter;
            }
        } else {
            permieter += 1;
        }
    }

    return (area, permieter);
}

fn part1(test_case: &TestCase) -> i32 {
    let mut visited = vec![vec![false; test_case[0].len()]; test_case.len()];
    let mut r = 0;
    for i in 0..test_case.len() {
        for j in 0..test_case[i].len() {
            if !visited[i][j] {
                let (area, perimeter) = flood_filling(i as i32, j as i32, test_case, &mut visited);
                r += area * perimeter;
            }
        }
    }

    return r;
}

fn main() -> Result<(), Box<dyn Error>> {
    let test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part1(&test_case), 1930);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let test_case = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&test_case));
    // println!("Result part 2 = {}", part2(&test_case, 75));
    // println!("Result part 2 = {}", part2(&test_case));

    Ok(())
}

