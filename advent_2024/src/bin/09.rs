use std::{
    cmp,
    collections::VecDeque,
    error::Error,
    fs::File,
    io::{BufRead, BufReader},
    vec,
};

const INPUT_FILE: &str = "input/09.txt";

const TEST: &str = "\
2333133121414131402
";

type TestCase = String;
#[derive(Debug)]
struct FileBlock {
    id: i32,
    size: i32,
    start: i32,
}

fn read_file<R: BufRead>(reader: R) -> Result<TestCase, Box<dyn Error>> {
    let lines = reader.lines().collect::<Result<Vec<_>, _>>()?;
    Ok(lines.join("\n"))
}

fn part1(test_cases: &TestCase) -> i128 {
    let chars: Vec<char> = test_cases.chars().collect();
    let mut file_blocks = vec![];
    let mut free_blocks = VecDeque::new();
    let mut current_pos = 0;
    for (i, c) in chars.iter().enumerate() {
        let length = c.to_digit(10).unwrap();
        if i % 2 == 0 {
            file_blocks.push(FileBlock {
                id: (i / 2) as i32,
                size: length as i32,
                start: current_pos,
            });
        } else {
            free_blocks.push_back(FileBlock {
                id: -1,
                size: length as i32,
                start: current_pos,
            });
        }
        current_pos += length as i32;
    }

    let mut result_files = vec![];
    for fb in file_blocks.iter_mut().rev() {
        while let Some(fs) = free_blocks.front_mut() {
            if fs.size == 0 {
                free_blocks.pop_front();
                continue;
            }

            if fs.start >= fb.start || fb.size == 0 {
                break;
            }

            let length = cmp::min(fb.size, fs.size);
            result_files.push(FileBlock {
                id: fb.id,
                size: length,
                start: fs.start,
            });

            fb.size -= length;
            fs.size -= length;
            fs.start += length;
        }

        if fb.size != 0 {
            result_files.push(FileBlock {
                id: fb.id,
                size: fb.size,
                start: fb.start,
            });
        }

    }

    let mut result: i128 = 0;
    for fb in result_files.iter() {
        for i in 0..fb.size {
            result += (fb.id as i128) * (fb.start + i) as i128;
        }
    }

    return result;
}


fn part2(test_cases: &TestCase) -> i128 {
    let chars: Vec<char> = test_cases.chars().collect();
    let mut file_blocks = vec![];
    let mut free_blocks = vec![];
    let mut current_pos = 0;
    for (i, c) in chars.iter().enumerate() {
        let length = c.to_digit(10).unwrap();
        if i % 2 == 0 {
            file_blocks.push(FileBlock {
                id: (i / 2) as i32,
                size: length as i32,
                start: current_pos,
            });
        } else {
            free_blocks.push(FileBlock {
                id: -1,
                size: length as i32,
                start: current_pos,
            });
        }
        current_pos += length as i32;
    }

    for fb in file_blocks.iter_mut().rev() {
        for fs in free_blocks.iter_mut() {
            if fs.start >= fb.start {
                break;
            }
            if fb.size <= fs.size && fb.start >= fs.start {
                fb.start = fs.start;
                fs.size -= fb.size;
                fs.start += fb.size;
                break;
            }
        }
    }


    let mut result: i128 = 0;
    for fb in file_blocks.iter() {
        for i in 0..fb.size {
            result += (fb.id as i128) * (fb.start + i) as i128;
        }
    }


    return result;
}

fn main() -> Result<(), Box<dyn Error>> {
    let test_case = read_file(BufReader::new(TEST.as_bytes()))?;
    assert_eq!(part1(&test_case), 1928);
    assert_eq!(part2(&test_case), 2858);

    let input_file = BufReader::new(File::open(INPUT_FILE)?);
    let test_case = read_file(input_file)?;
    println!("Result part 1 = {}", part1(&test_case));
    println!("Result part 2 = {}", part2(&test_case));

    Ok(())
}

//6350141442586
