import org.junit.jupiter.api.Test;

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

}
