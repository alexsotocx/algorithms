use std::{
    collections::HashMap,
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
};

const INPUT_FILE: &str = "input/01.txt";

const TEST: &str = "\
3   4
4   3
2   5
1   3
3   9
3   3
";

fn read_file<R: BufRead>(reader: R) -> Result<(Vec<i32>, Vec<i32>), Box<dyn Error>> {
    let lines = reader.lines();
    let mut l1: Vec<i32> = vec![];
    let mut l2: Vec<i32> = vec![];
    for line in lines {
        let line = line?;
        let mut it = line.split_whitespace();
        l1.push(it.next().ok_or("Missing value in column 1")?.parse()?);
        l2.push(it.next().ok_or("Missing value in column 2")?.parse()?);
    }
    Ok((l1, l2))
}

fn part1(l1: &mut Vec<i32>, l2: &mut Vec<i32>) -> i32 {
    l1.sort_unstable();
    l2.sort_unstable();
    l1.iter().zip(l2).map(|(a, b)| (*a - *b).abs()).sum()
}

fn part2(l1: &[i32], l2: &[i32]) -> i32 {
    let mut count = HashMap::new();
    for &v in l2 {
        *count.entry(v).or_default() += 1;
    }
    l1.iter().map(|&v| count.get(&v).unwrap_or(&0) * v).sum()
}

fn main() -> Result<(), Box<dyn Error>> {
    let test_data = BufReader::new(TEST.as_bytes());
    let (l1, l2) = read_file(test_data)?;
    assert_eq!(11, part1(&mut l1.clone(), &mut l2.clone()));

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let (mut l1, mut l2) = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&mut l1, &mut l2));
    println!("Result part 2 = {}", part2(&l1, &l2));

    Ok(())
}
