import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordCountTest {
    private WordCount wordCounter;

    public WordCountTest() {
    }

    @BeforeEach
    public void setup() {
        System.out.println("Creating a new word counter!");
        wordCounter = new WordCount();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Running AfterEach");
    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("STARTING TESTS");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("FINISHED ALL TESTS");
    }

    @Test
    public void testRemovePunctuations() {
        System.out.println("Testing removing punctuations");
        System.out.println("");
        String input = "Hello, world!";
        String expectedOutput = "Hello world";
        String actualOutput = wordCounter.removePunctuations(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemoveHyphens() {
        System.out.println("Testing removing hyphens");
        System.out.println("");
        String input = "co-operate";
        String expectedOutput = "co operate";
        String actualOutput = wordCounter.removeHyphens(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
