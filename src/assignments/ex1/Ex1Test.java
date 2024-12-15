package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = assignments.ex1.Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = assignments.ex1.Ex1.number2Int(s10);
        s2 = assignments.ex1.Ex1.int2Number(v,2);
        int v2 = assignments.ex1.Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(assignments.ex1.Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = assignments.ex1.Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = assignments.ex1.Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        String[] numbers = {"15bD", "1234b5", "5454bC", "123", "ABbG", "11101b2"};
        String[] base10 = {"18", "194", "9280", "123", "171", "29"};
        boolean flag = true;

        for (int i = 0; i < numbers.length; i++) {
            if (!Ex1.equals(numbers[i], base10[i])) {
                flag = false;
            }
        }

        assertTrue(flag);
        assertEquals( "FFbG", Ex1.int2Number(255, 16)); // Decimal to hexadecimal
        assertEquals( "111b2" , Ex1.int2Number(7, 2)); // Decimal to binary
        assertEquals( "111" , Ex1.int2Number(111, 10)); // Decimal to binary
    }
    @Test
    void maxIndexTest() {
        String[][] numbersToTest = {
                {"123", "122", "122", "12b3"},
                {"599", "12bD", "599bG", "100b2"},
                {"15bG", "0", "1", "13"},
                {"555", "555b6", "555b7", "555bG"}
        };
        int[] numbersAnswers = {123, 1433, 21, 1365};
        boolean flag = true;

        for (int i = 0; i < numbersToTest.length; i++) {
            int res = Ex1.maxIndex(numbersToTest[i]);
            int compare = numbersAnswers[i];
            int result = Ex1.number2Int(numbersToTest[i][res]);
            if (result != compare) {
                flag = false;
            }
        }
        assertTrue(flag);
    }

    // Add additional test functions - test as much as you can.
}
