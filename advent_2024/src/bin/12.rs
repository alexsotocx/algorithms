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

const DIRECTIONS: [(i32, i32); 4] = [(-1, 0), (0, 1), (1, 0), (0, -1)];

type TestCase = Vec<Vec<char>>;

fn read_file<R: BufRead>(reader: R) -> Result<TestCase, Box<dyn Error>> {
    let mut result: TestCase = vec![];
    for line in reader.lines() {
        result.push(line.unwrap().chars().collect());
    }

    Ok(result)
}

fn inside(r: i32, c: i32, v: &TestCase) -> bool {
    r >= 0 && r < v.len() as i32 && c >= 0 && c < v[r as usize].len() as i32
}

fn flood_filling(row: i32, col: i32, v: &TestCase, visited: &mut Vec<Vec<bool>>) -> (i32, i32) {
    let mut area = 1;
    let mut perimeter = 0;
    visited[row as usize][col as usize] = true;

    let valid = |p: (i32, i32)| -> bool {
        let di = row + p.0;
        let dj = col + p.1;

        return inside(di, dj, v) && v[row as usize][col as usize] == v[di as usize][dj as usize];
    };

    for i in 0..4 {
        let dir1 = DIRECTIONS[i];
        let dir2 = DIRECTIONS[(i + 1) % 4];
        let dir3 = (dir1.0 + dir2.0, dir1.1 + dir2.1);
        if !valid(dir1) && !valid(dir2) {
            perimeter += 1;
        }
        if valid(dir1) && valid(dir2) && !valid(dir3) {
            perimeter += 1;
        }
    }

    for dir in DIRECTIONS {
        let di = row + dir.0;
        let dj = col + dir.1;

        if valid(dir) && !visited[di as usize][dj as usize] {
            let (a, p) = flood_filling(di, dj, v, visited);
            area += a;
            perimeter += p;
        }
    }

    return (area, perimeter);
}

fn part2(test_case: &TestCase) -> i32 {
    let mut visited = vec![vec![false; test_case[0].len()]; test_case.len()];
    let mut r = 0;
    for i in 0..test_case.len() {
        for j in 0..test_case[i].len() {
            if !visited[i][j] {
                let (area, perimeter) =
                    flood_filling(i as i32, j as i32, test_case, &mut visited);
                r += area * perimeter;
            }
        }
    }

    return r;
}


fn main() -> Result<(), Box<dyn Error>> {
    let test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part2(&test_case), 1206);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let test_case = read_file(input_file)?;
    println!("Result part 2 = {}", part2(&test_case));
    // println!("Result part 2 = {}", part2(&test_case));

    Ok(())
}
