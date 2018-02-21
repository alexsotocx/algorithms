import org.junit.Test;
import static org.junit.Assert.*;

public class UserNameTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] existingNames = new String[] {"MasterOfDisaster", "DingBat", "Orpheus", "WolfMan", "MrKnowItAll"};
		String newName = "TygerTyger";
		assertEquals("TygerTyger", new UserName().newMember(existingNames, newName));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] existingNames = new String[] {"MasterOfDisaster", "TygerTyger1", "DingBat", "Orpheus", 
 "TygerTyger", "WolfMan", "MrKnowItAll"};
		String newName = "TygerTyger";
		assertEquals("TygerTyger2", new UserName().newMember(existingNames, newName));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] existingNames = new String[] {"TygerTyger2000", "TygerTyger1", "MasterDisaster", "DingBat", 
 "Orpheus", "WolfMan", "MrKnowItAll"};
		String newName = "TygerTyger";
		assertEquals("TygerTyger", new UserName().newMember(existingNames, newName));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] existingNames = new String[] {"grokster2", "BrownEyedBoy", "Yoop", "BlueEyedGirl", 
 "grokster", "Elemental", "NightShade", "Grokster1"};
		String newName = "grokster";
		assertEquals("grokster1", new UserName().newMember(existingNames, newName));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] existingNames = new String[] {"Bart4", "Bart5", "Bart6", "Bart7", "Bart8", "Bart9", "Bart10",
 "Lisa", "Marge", "Homer", "Bart", "Bart1", "Bart2", "Bart3",
 "Bart11", "Bart12"};
		String newName = "Bart";
		assertEquals("Bart13", new UserName().newMember(existingNames, newName));
	}
}
