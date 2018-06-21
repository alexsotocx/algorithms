import org.junit.Test;
import static org.junit.Assert.*;

public class CaptureThemAllTest {
	
	@Test(timeout=2000)
	public void test0() {
		String knight = "a1";
		String rook = "b3";
		String queen = "c5";
		assertEquals(2, new CaptureThemAll().fastKnight(knight, rook, queen));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String knight = "b1";
		String rook = "c3";
		String queen = "a3";
		assertEquals(3, new CaptureThemAll().fastKnight(knight, rook, queen));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String knight = "a1";
		String rook = "a2";
		String queen = "b2";
		assertEquals(6, new CaptureThemAll().fastKnight(knight, rook, queen));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String knight = "a5";
		String rook = "b7";
		String queen = "e4";
		assertEquals(3, new CaptureThemAll().fastKnight(knight, rook, queen));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String knight = "h8";
		String rook = "e2";
		String queen = "d2";
		assertEquals(6, new CaptureThemAll().fastKnight(knight, rook, queen));
	}
}
