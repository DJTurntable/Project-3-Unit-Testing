import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoresTest {
    //note to self: remember to pull first and commit and push when done
    //Lin: tests for Scores() constructor
    //Adam: tests for getMax() method

    @Test
    public void ConstructorTest(){
        String numbers = "-6 9 31 587";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getNumScores(), 4);
    }

    @Test
    public void WhiteSpaceTest(){
        String numbers = "6\n9\t5";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getNumScores(), 3);
    }

    @Test
    public void EmptyTest(){
        String numbers = "";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getNumScores(), 0);
    }

    @Test
    public void BadInputTest(){
        String numbers = "we are not numbers";
        Scores practice;
        assertThrows(IllegalArgumentException.class, () -> {new Scores(numbers);});
    }

    @Test
    public void NoWhiteSpaceTest(){
        String numbers = "6,3.5,2,7";
        Scores practice;
        assertThrows(IllegalArgumentException.class, () -> {new Scores(numbers);});
    }
    @Test
    public void getMaxNormalTest(){
        String numbers = "1 3 5 7 9";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getMax(), 9);
    }
    @Test
    public void getMaxAllNegativeTest(){
        String numbers = "-10 -5 -20";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getMax(), -5);
    }
    @Test
    public void getMaxSingleValueTest(){
        String numbers = "15";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getMax(), 15);
    }
    @Test
    public void getMaxEmptyListTest(){
        String numbers = "";
        Scores practice = new Scores(numbers);
        assertThrows(NoSuchElementException.class, practice::getMax);
    }
    @Test
    public void getMaxBoundaryValueTest(){
        String numbers = "1 3 2147483647 -2147483648";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getMax(), Integer.MAX_VALUE);
    }
    @Test
    public void LargeInputConstructorTest(){
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            numbers.append(i).append(" ");
        }
        Scores practice = new Scores(numbers.toString().trim());
        assertEquals(practice.getNumScores(), 1000);
    }
    @Test
    public void WhitespaceOnlyTest(){
        String numbers = "   \n\t   ";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getNumScores(), 0);
    }
    @Test
    public void MultipleZerosTest(){
        String numbers = "0 0 0";
        Scores practice = new Scores(numbers);
        assertEquals(practice.getMax(), 0);
        assertEquals(practice.getNumScores(), 3);
    }
}
