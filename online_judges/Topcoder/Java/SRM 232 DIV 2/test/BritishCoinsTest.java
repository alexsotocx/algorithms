import org.junit.Test;
import static org.junit.Assert.*;

public class BritishCoinsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int pence = 533;
		assertArrayEquals(new int[] { 2,
  4,
  5 }, new BritishCoins().coins(pence));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int pence = 0;
		assertArrayEquals(new int[] { 0,
  0,
  0 }, new BritishCoins().coins(pence));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int pence = 6;
		assertArrayEquals(new int[] { 0,
  0,
  6 }, new BritishCoins().coins(pence));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int pence = 4091;
		assertArrayEquals(new int[] { 17,
  0,
  11 }, new BritishCoins().coins(pence));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int pence = 10000;
		assertArrayEquals(new int[] { 41,
  13,
  4 }, new BritishCoins().coins(pence));
	}
}
