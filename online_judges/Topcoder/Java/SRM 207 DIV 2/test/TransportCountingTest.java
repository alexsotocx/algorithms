import org.junit.Test;
import static org.junit.Assert.*;

public class TransportCountingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int speed = 100;
		int[] positions = new int[] {0};
		int[] velocities = new int[] {0};
		int time = 0;
		assertEquals(1, new TransportCounting().countBuses(speed, positions, velocities, time));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int speed = 5;
		int[] positions = new int[] {10, 10};
		int[] velocities = new int[] {0, 1};
		int time = 2;
		assertEquals(1, new TransportCounting().countBuses(speed, positions, velocities, time));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int speed = 5;
		int[] positions = new int[] {10, 10};
		int[] velocities = new int[] {0, 1};
		int time = 3;
		assertEquals(2, new TransportCounting().countBuses(speed, positions, velocities, time));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int speed = 777;
		int[] positions = new int[] {10,20,30,40,50,60,70,80,90,100,
110,120,130,140,150,160,170,180,190,200,
210,220,230,240,250,260,270,280,290,300,
310,320,330,340,350,360,370,380,390,400,
410,420,430,440,450,460,470,480,490,500};
		int[] velocities = new int[] {10,20,30,40,50,60,70,80,90,100,
110,120,130,140,150,160,170,180,190,200,
210,220,230,240,250,260,270,280,290,300,
310,320,330,340,350,360,370,380,390,400,
410,420,430,440,450,460,470,480,490,500};
		int time = 333;
		assertEquals(50, new TransportCounting().countBuses(speed, positions, velocities, time));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int speed = 5;
		int[] positions = new int[] {0,0,0};
		int[] velocities = new int[] {4,5,6};
		int time = 10;
		assertEquals(3, new TransportCounting().countBuses(speed, positions, velocities, time));
	}
}
