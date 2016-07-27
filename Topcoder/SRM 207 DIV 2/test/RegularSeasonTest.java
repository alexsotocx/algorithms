import org.junit.Test;
import static org.junit.Assert.*;

public class RegularSeasonTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] teams = new String[] {"A 0 10 50",
"B 100 0 100",
"C 50 10 0"};
		int rounds = 5;
		assertArrayEquals(new String[] { "B 19",  "A 6",  "C 6" }, new RegularSeason().finalStandings(teams, rounds));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] teams = new String[] {"SPURS 0 33 67 100",
"LAKERS 67 0 33 100",
"WOLVES 33 67 0 100",
"KINGS 0 75 75 0"};
		int rounds = 2;
		assertArrayEquals(new String[] { "SPURS 8",  "LAKERS 7",  "WOLVES 7",  "KINGS 3" }, new RegularSeason().finalStandings(teams, rounds));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] teams = new String[] {"A 0 10 20 30 40 50 60 70 80 90",
"AA 90 0 10 20 30 40 50 60 70 80",
"AAA 80 90 0 10 20 30 40 50 60 70",
"AAAA 70 80 90 0 10 20 30 40 50 60",
"AAAAA 60 70 80 90 0 10 20 30 40 50",
"AAAAAA 50 60 70 80 90 0 10 20 30 40",
"AAAAAAA 40 50 60 70 80 90 0 10 20 30",
"AAAAAAAA 30 40 50 60 70 80 90 0 10 20",
"AAAAAAAAA 20 30 40 50 60 70 80 90 0 10",
"AAAAAAAAAA 10 20 30 40 50 60 70 80 90 0"};
		int rounds = 10;
		assertArrayEquals(new String[] { "A 90",  "AA 90",  "AAA 90",  "AAAA 90",  "AAAAA 90",  "AAAAAA 90",  "AAAAAAA 90",  "AAAAAAAA 90",  "AAAAAAAAA 90",  "AAAAAAAAAA 90" }, new RegularSeason().finalStandings(teams, rounds));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] teams = new String[] {"WF 0 0 71 10 62 87 49 75 50","OZ 38 0 79 55 36 96 63 17 37",
"C 13 75 0 96 61 2 33 5 64","LCG 13 85 87 0 60 72 86 1 12",
"GDDYC 71 62 21 6 0 17 63 34 32","B 37 66 81 81 53 0 61 80 90",
"XK 14 63 40 25 13 86 0 6 43","YVN 57 30 55 22 31 11 81 0 13",
"SKGAN 28 79 90 79 75 62 36 86 0"};
		int rounds = 10;
		assertArrayEquals(new String[] { "SKGAN 99",  "WF 93",  "B 92",  "LCG 84",  "YVN 80",  "OZ 76",  "GDDYC 72",  "C 63",  "XK 62" }, new RegularSeason().finalStandings(teams, rounds));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] teams = new String[] {
"ZSN 0 61 70 44 69 40 84 59 20",
"SJKB 95 0 88 39 99 18 90 58 44",
"EBIUF 63 71 0 5 28 26 41 90 71",
"MA 73 90 39 0 40 91 31 39 57",
"NPT 35 74 75 74 0 74 14 20 27",
"JVY 68 92 37 52 11 0 91 20 52",
"ZBOW 66 44 69 9 8 7 0 2 35",
"HH 31 70 14 39 6 68 73 0 20",
"P 70 62 66 54 9 55 5 98 0"};
		int rounds = 10;
		assertArrayEquals(new String[] { "MA 94",  "NPT 92",  "P 89",  "JVY 84",  "SJKB 77",  "ZSN 75",  "EBIUF 74",  "HH 74",  "ZBOW 61" }, new RegularSeason().finalStandings(teams, rounds));
	}
}
