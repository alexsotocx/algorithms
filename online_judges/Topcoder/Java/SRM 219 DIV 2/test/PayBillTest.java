import org.junit.Test;
import static org.junit.Assert.*;

public class PayBillTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] meals = new int[] { 1000, 1200, 1300 };
		int totalMoney = 2500;
		assertArrayEquals(new int[] { 1,  2 }, new PayBill().whoPaid(meals, totalMoney));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] meals = new int[] { 100, 200, 350 };
		int totalMoney = 300;
		assertArrayEquals(new int[] { 0,  1 }, new PayBill().whoPaid(meals, totalMoney));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] meals = new int[] { 150, 200, 350, 400 };
		int totalMoney = 900;
		assertArrayEquals(new int[] { 0,  2,  3 }, new PayBill().whoPaid(meals, totalMoney));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] meals = new int[] {6584,6733,6018,5840,2723,4902,4260,
 5375,6745,1234,3000,8222,2472,
 4348,1716,9995,415,1234,2345,5679};
		int totalMoney = 70630;
		assertArrayEquals(new int[] { 0,  1,  3,  4,  5,  6,  8,  9,  11,  13,  14,  15,  16,  17,  19 }, new PayBill().whoPaid(meals, totalMoney));
	}
}
