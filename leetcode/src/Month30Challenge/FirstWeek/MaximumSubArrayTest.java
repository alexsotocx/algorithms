package Month30Challenge.FirstWeek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubArrayTest {

    @Test
    void maxSubArray() {
      assertEquals(6, new MaximumSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
