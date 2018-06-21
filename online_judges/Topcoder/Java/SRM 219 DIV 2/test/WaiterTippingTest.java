import org.junit.Test;
import static org.junit.Assert.*;

public class WaiterTippingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int total = 500;
		int taxPercent = 10;
		int money = 600;
		assertEquals(10, new WaiterTipping().maxPercent(total, taxPercent, money));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int total = 500;
		int taxPercent = 10;
		int money = 604;
		assertEquals(10, new WaiterTipping().maxPercent(total, taxPercent, money));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int total = 850;
		int taxPercent = 8;
		int money = 870;
		assertEquals(-1, new WaiterTipping().maxPercent(total, taxPercent, money));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int total = 226;
		int taxPercent = 48;
		int money = 584;
		assertEquals(111, new WaiterTipping().maxPercent(total, taxPercent, money));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int total = 123;
		int taxPercent = 52;
		int money = 696;
		assertEquals(415, new WaiterTipping().maxPercent(total, taxPercent, money));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int total = 500;
		int taxPercent = 10;
		int money = 550;
		assertEquals(0, new WaiterTipping().maxPercent(total, taxPercent, money));
	}
}
