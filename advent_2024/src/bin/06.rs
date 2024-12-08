use std::{
    collections::{HashMap, HashSet},
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
};

const INPUT_FILE: &str = "input/06.txt";

const TEST: &str = "\
....#.....
.........#
..........
..#.......
.......#..
..........
.#..^.....
........#.
#.........
......#...
";

const ORENTATIONS: &[(i32, i32)] = &[(-1, 0), (0, 1), (1, 0), (0, -1)];

fn read_file<R: BufRead>(reader: R) -> Result<Vec<Vec<char>>, Box<dyn Error>> {
    let mut test_lines: Vec<Vec<char>> = Vec::new();

    for line in reader.lines() {
        let parts: Vec<char> = line?.chars().collect();
        test_lines.push(parts);
    }

    Ok(test_lines)
}

fn inside_maze(maze: &Vec<Vec<char>>, x: i32, y: i32) -> bool {
    x >= 0 && x < maze.len() as i32 && y >= 0 && y < maze[x as usize].len() as i32
}

fn part1(maze: &mut Vec<Vec<char>>) -> i32 {
    let mut res = 1;
    let mut x = 0;
    let mut y = 0;
    let mut orentation = 0;

    'outer: for i in 0..maze.len() {
        for j in 0..maze[i].len() {
            if maze[i][j] == '^' {
                x = i as i32;
                y = j as i32;
                maze[i][j] = 'X';
                break 'outer;
            }
        }
    }

    while inside_maze(maze, x, y) {
        if maze[x as usize][y as usize] == '#' {
            x -= ORENTATIONS[orentation].0;
            y -= ORENTATIONS[orentation].1;
            orentation = (orentation + 1) % 4;
        }
        if maze[x as usize][y as usize] == '.' {
            res += 1;
        }
        maze[x as usize][y as usize] = 'X';
        x += ORENTATIONS[orentation].0;
        y += ORENTATIONS[orentation].1;
    }

    res
}

// fn part2(rules: &HashMap<i32, HashSet<i32>>, test_lines: &[Vec<i32>]) -> i32 {
//     test_lines.iter().filter(|v| !valid_page(rules, v)).map(|v| fix_page(rules, v)).sum()
// }

fn main() -> Result<(), Box<dyn Error>> {
    let mut test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part1(&mut test_case), 41);
    // assert_eq!(part2(&rules, &test_cases), 123);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let mut test_case = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&mut test_case));
    // println!("Result part 2 = {}", part2(&test_cases));

    Ok(())
}
