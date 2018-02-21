import org.junit.Test;
import static org.junit.Assert.*;

public class HealthFoodTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] protein = new int[] {3, 4};
		int[] carbs = new int[] {2, 8};
		int[] fat = new int[] {5, 2};
		String[] dietPlans = new String[] {"P", "p", "C", "c", "F", "f", "T", "t"};
		assertArrayEquals(new int[] { 1,  0,  1,  0,  0,  1,  1,  0 }, new HealthFood().selectMeals(protein, carbs, fat, dietPlans));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] protein = new int[] {3, 4, 1, 5};
		int[] carbs = new int[] {2, 8, 5, 1};
		int[] fat = new int[] {5, 2, 4, 4};
		String[] dietPlans = new String[] {"tFc", "tF", "Ftc"};
		assertArrayEquals(new int[] { 3,  2,  0 }, new HealthFood().selectMeals(protein, carbs, fat, dietPlans));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] protein = new int[] {18, 86, 76,  0, 34, 30, 95, 12, 21};
		int[] carbs = new int[] {26, 56,  3, 45, 88,  0, 10, 27, 53};
		int[] fat = new int[] {93, 96, 13, 95, 98, 18, 59, 49, 86};
		String[] dietPlans = new String[] {"f", "Pt", "PT", "fT", "Cp", "C", "t", "",
 "cCp", "ttp", "PCFt", "P", "pCt", "cP", "Pc"}
;
		assertArrayEquals(new int[] { 2,  6,  6,  2,  4,  4,  5,  0,  5,  5,  6,  6,  3,  5,  6 }, new HealthFood().selectMeals(protein, carbs, fat, dietPlans));
	}
}
