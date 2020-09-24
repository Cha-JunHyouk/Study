import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IftestTest extends Iftest {

    @Test
    public void testMain() {
    }

    @Test
    public void testMaxOfThree() {
        Iftest mot=new Iftest();
            int result=mot.maxOfThree(3,61,9);
            assertEquals(61,result);
    }
}