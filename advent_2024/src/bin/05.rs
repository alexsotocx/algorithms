use std::{
    collections::{HashMap, HashSet},
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
};

const INPUT_FILE: &str = "input/05.txt";

const TEST: &str = "\
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47
";

fn read_file<R: BufRead>(
    reader: R,
) -> Result<(HashMap<i32, HashSet<i32>>, Vec<Vec<i32>>), Box<dyn Error>> {
    let mut rules: HashMap<i32, HashSet<i32>> = HashMap::new();
    let mut test_lines: Vec<Vec<i32>> = Vec::new();
    let mut section = 1;
    reader.lines().for_each(|line| {
        let line = line.unwrap();
        if line.is_empty() {
            section += 1;
            return;
        }

        if section == 1 {
            let parts: Vec<i32> = line.split('|').map(|x| x.parse::<i32>().unwrap()).collect();
            rules.entry(parts[1]).or_insert(HashSet::new()).insert(parts[0]);
        } else {
            let parts: Vec<i32> = line.split(',').map(|x| x.parse::<i32>().unwrap()).collect();
            test_lines.push(parts);
        }
    });

    Ok((rules, test_lines))
}

fn part1(rules: &HashMap<i32, HashSet<i32>>, test_lines: &Vec<Vec<i32>>) -> i32 {
    let mut result = 0;
    let empty_hash = &HashSet::new();
    for v in test_lines {
        let mut valid = true;
        for i in 0..v.len() {
            if !valid {
                break;
            }
            let rule_set = rules.get(&v[i]).unwrap_or(empty_hash);
            valid &= !((i+1)..v.len()).any(|f| rule_set.contains(&v[f]));
        }
        if valid {
            result += v[v.len() / 2];
        }
    }
    result
}

// fn part2(input: &[String]) -> i32 {
//     let mut result = 0;
//     for i in 0..input.len() as i32 {
//         for j in 0..input[0].len() as i32 {
//             result += check_xmas(input, i, j);
//         }
//     }
//     result
// }

fn main() -> Result<(), Box<dyn Error>> {
    let (rules, test_cases)= &read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part1(&rules, &test_cases), 143);
    // assert_eq!(part2(&read_file(BufReader::new(TEST.as_bytes()))?), 9);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let (rulse_set, test_cases) = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&rulse_set, &test_cases));
    // println!("Result part 2 = {}", part2(&input_content));

    Ok(())
}
