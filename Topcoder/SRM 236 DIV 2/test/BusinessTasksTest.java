import org.junit.Test;
import static org.junit.Assert.*;

public class BusinessTasksTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] list = new String[] {"a","b","c","d"};
		int n = 2;
		assertEquals("a", new BusinessTasks().getTask(list, n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] list = new String[] {"a","b","c","d","e"};
		int n = 3;
		assertEquals("d", new BusinessTasks().getTask(list, n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] list = new String[] {"alpha","beta","gamma","delta","epsilon"};
		int n = 1;
		assertEquals("epsilon", new BusinessTasks().getTask(list, n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] list = new String[] {"a","b"};
		int n = 1000;
		assertEquals("a", new BusinessTasks().getTask(list, n));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] list = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
"u","v","w","x","y","z"};
		int n = 17;
		assertEquals("n", new BusinessTasks().getTask(list, n));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] list = new String[] {"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp",
"olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu",
"qgcxjbfx","my","mlhy","bt","bo","q"};
		int n = 9000000;
		assertEquals("fxjqzznvg", new BusinessTasks().getTask(list, n));
	}
}
