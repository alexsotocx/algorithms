use std::{
    collections::{HashMap, HashSet},
    error::Error,
    fs::File,
    hash::Hash,
    io::{BufRead, BufReader},
};

const INPUT_FILE: &str = "input/08.txt";

const TEST: &str = "\
............
........0...
.....0......
.......0....
....0.......
......A.....
............
............
........A...
.........A..
............
............
";

type TestCase = (Vec<Vec<char>>, HashMap<char, Vec<(i32, i32)>>);

fn read_file<R: BufRead>(reader: R) -> Result<TestCase, Box<dyn Error>> {
    let mut test_lines = vec![];
    let mut dic: HashMap<char, Vec<(i32, i32)>> = HashMap::new();
    for (i, line) in reader.lines().enumerate() {
        let line = line?;
        let line = line
            .trim()
            .chars()
            .enumerate()
            .map(|(j, c)| {
                if c != '.' {
                    let entry = dic.entry(c).or_insert(vec![]);
                    entry.push((i as i32, j as i32));
                }
                c
            })
            .collect();
        test_lines.push(line);
    }

    Ok((test_lines, dic))
}

fn distance(a: (i32, i32), b: (i32, i32)) -> (i32, i32) {
    let (x1, y1) = a;
    let (x2, y2) = b;

    return ((x2 - x1), (y2 - y1));
}

fn in_bounds(x: i32, y: i32, v: &Vec<Vec<char>>) -> bool {
    return x >= 0 && x < v.len() as i32 && y >= 0 && y < v[x as usize].len() as i32;
}

fn part1(test_cases: &TestCase) -> i32 {
    let (test_lines, dic) = test_cases;
    let mut antinodes = HashSet::new();

    for (c, points) in dic.iter() {
        for i in 0..points.len() {
            for j in i + 1..points.len() {
                let d = distance(points[i], points[j]);



                let (dx, dy) = d;
                let p1  = (points[i].0 - dx, points[i].1 - dy);
                let p2  = (points[j].0 + dx, points[j].1 + dy);

                if in_bounds(p1.0, p1.1, test_lines){
                    antinodes.insert(p1);
                }

                if in_bounds(p2.0, p2.1, test_lines){
                    antinodes.insert(p2);
                }

            }
        }
    }


    antinodes.len() as i32
}

fn part2(test_cases: &TestCase) -> i32 {
    let (test_lines, dic) = test_cases;
    let mut antinodes = HashSet::new();

    for (c, points) in dic.iter() {
        for i in 0..points.len() {
            for j in i + 1..points.len() {
                let d = distance(points[i], points[j]);

                let (dx, dy) = d;
                let mut current_location = points[i];
                loop {
                    current_location = (current_location.0 + dx, current_location.1 + dy);
                    if !in_bounds(current_location.0, current_location.1, test_lines) {
                        break;
                    }
                    antinodes.insert(current_location);
                }

                current_location = points[j];
                loop {
                    current_location = (current_location.0 - dx, current_location.1 - dy);
                    if !in_bounds(current_location.0, current_location.1, test_lines) {
                        break;
                    }
                    antinodes.insert(current_location);
                }


            }
        }
    }


    antinodes.len() as i32
}


fn main() -> Result<(), Box<dyn Error>> {
    let test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part1(&test_case), 14);
    assert_eq!(part2(&test_case), 34);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let test_case = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&test_case));
    println!("Result part 2 = {}", part2(&test_case));

    Ok(())
}
