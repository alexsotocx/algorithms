use std::{
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
};

const INPUT_FILE: &str = "input/02.txt";

const TEST: &str = "\
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
";

fn read_file<R: BufRead>(reader: R) -> Result<Vec<Vec<i32>>, Box<dyn Error>> {
    let lines = reader.lines();
    let mut l1: Vec<Vec<i32>> = vec![];
    for line in lines {
        let line = line?;
        let mut it = line.split_whitespace();

        let mut l2: Vec<i32> = vec![];
        while let Some(v) = it.next() {
            l2.push(v.parse()?);
        }
        l1.push(l2);
    }
    Ok(l1)
}

fn part1(l1: &Vec<Vec<i32>>) -> i32 {
    let mut res = 0;

    for l2 in l1 {
        let increasing = l2.windows(2).all(|w| w[0] < w[1]);
        let decreasing = l2.windows(2).all(|w| w[0] > w[1]);
        let diff = l2
            .windows(2)
            .all(|w| (w[0] - w[1]).abs() >= 1 && (w[0] - w[1]).abs() <= 3);

        if (increasing || decreasing) && diff {
            res += 1;
        }
    }

    return res;
}
// fn part2(l1: &Vec<Vec<i32>>) -> i32 {
//     let mut res = 0;

//     for l2 in l1 {
//         let increasing = l2.windows(2).filter(|w| w[0] < w[1]).count();
//         let decreasing = l2.windows(2).filter(|w| w[0] > w[1]).count();
//         let diff = l2
//             .windows(2)
//             .filter(|w| (w[0] - w[1]).abs() >= 1 && (w[0] - w[1]).abs() <= 3).count();

//         if (increasing || decreasing) && diff {
//             res += 1;
//         }
//     }

//     return res;
// }


fn main() -> Result<(), Box<dyn Error>> {
    let test_data = BufReader::new(TEST.as_bytes());
    let l1 = read_file(test_data)?;
    assert_eq!(2, part1(&l1));

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let l1 = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&l1));
    // println!("Result part 2 = {}", part2(&l1, &l2));

    Ok(())
}
