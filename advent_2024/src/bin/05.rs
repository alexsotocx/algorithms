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

    for line in reader.lines() {
        let line = line?;
        if line.is_empty() {
            section += 1;
            continue;
        }

        if section == 1 {
            let parts: Vec<i32> = line.split('|').map(|x| x.parse().unwrap()).collect();
            rules.entry(parts[1]).or_insert_with(HashSet::new).insert(parts[0]);
        } else {
            let parts: Vec<i32> = line.split(',').map(|x| x.parse().unwrap()).collect();
            test_lines.push(parts);
        }
    }

    Ok((rules, test_lines))
}

fn valid_page(rules: &HashMap<i32, HashSet<i32>>, v: &[i32]) -> bool {
    let empty_set = &HashSet::new();
    for i in 0..v.len() {
        let rule_set = rules.get(&v[i]).unwrap_or(empty_set);
        if (i + 1..v.len()).any(|f| rule_set.contains(&v[f])) {
            return false;
        }
    }
    true
}

fn fix_page(rules: &HashMap<i32, HashSet<i32>>, page: &[i32]) -> i32 {
    let mut fixed = page.to_vec();
    let mut i = 0;
    let empty_set = &HashSet::new();

    while i < fixed.len() {
        let rule_set = rules.get(&fixed[i]).unwrap_or(empty_set);
        if (i + 1..fixed.len()).any(|f| rule_set.contains(&fixed[f])) {
            for j in (i + 1)..fixed.len() {
                if rule_set.contains(&fixed[j]) {
                    fixed.swap(i, j);
                    break;
                }
            }
        } else {
            i += 1;
        }
    }

    fixed[fixed.len() / 2]
}

fn part1(rules: &HashMap<i32, HashSet<i32>>, test_lines: &[Vec<i32>]) -> i32 {
    test_lines.iter().filter(|v| valid_page(rules, v)).map(|v| v[v.len() / 2]).sum()
}

fn part2(rules: &HashMap<i32, HashSet<i32>>, test_lines: &[Vec<i32>]) -> i32 {
    test_lines.iter().filter(|v| !valid_page(rules, v)).map(|v| fix_page(rules, v)).sum()
}

fn main() -> Result<(), Box<dyn Error>> {
    let (rules, test_cases) = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part1(&rules, &test_cases), 143);
    assert_eq!(part2(&rules, &test_cases), 123);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let (rules_set, test_cases) = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&rules_set, &test_cases));
    println!("Result part 2 = {}", part2(&rules_set, &test_cases));

    Ok(())
}
