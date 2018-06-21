import org.junit.Test;
import static org.junit.Assert.*;

public class MassiveNumbersTest {
	
	@Test(timeout=2000)
	public void test0() {
		String numberA = "3^100";
		String numberB = "2^150";
		assertEquals("3^100", new MassiveNumbers().getLargest(numberA, numberB));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String numberA = "1^1000";
		String numberB = "2^1";
		assertEquals("2^1", new MassiveNumbers().getLargest(numberA, numberB));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String numberA = "893^605";
		String numberB = "396^906";
		assertEquals("396^906", new MassiveNumbers().getLargest(numberA, numberB));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String numberA = "999^1000";
		String numberB = "1000^999";
		assertEquals("999^1000", new MassiveNumbers().getLargest(numberA, numberB));
	}
}
