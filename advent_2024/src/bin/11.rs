use std::{
    collections::{hash_map, HashMap, HashSet},
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
    vec,
};

use cached::proc_macro::cached;



const INPUT_FILE: &str = "input/11.txt";

const TEST: &str = "\
125 17
";

type TestCase = Vec<i128>;

fn read_file<R: BufRead>(reader: R) -> Result<TestCase, Box<dyn Error>> {
    for line in reader.lines() {
        return Ok(line?
            .split_whitespace()
            .map(|x| x.parse::<i128>().unwrap())
            .collect());
    }

    Ok(vec![])
}

#[cached]
fn solve(number: i128, steps: i32) -> i128 {

    if steps == 0 {
        return 1;
    }

    if number == 0 {
        return solve(1, steps - 1);
    }

    let s = number.to_string();
    let ln= s.len();
    if ln % 2 == 0 {
        let n1: i128 = s[0..ln/2].parse().unwrap();
        let n2: i128 = s[ln/2..].parse().unwrap();

        return solve(n1, steps - 1) + solve(n2, steps - 1);
    }
    return solve(number * 2024, steps - 1);
}


fn part2(test_cases: &TestCase, num: i32) -> i128 {
    let mut result:i128 = 0;
    for x in test_cases.iter() {
        result += solve(x.clone(), num);
    }


    return result;
}




fn main() -> Result<(), Box<dyn Error>> {
    let test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part2(&test_case, 25), 55312);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let test_case = read_file(input_file)?;
    println!("Result part 1 = {}", part2(&test_case, 25));
    println!("Result part 2 = {}", part2(&test_case, 75));
    // println!("Result part 2 = {}", part2(&test_case));

    Ok(())
}

//6350141442586
