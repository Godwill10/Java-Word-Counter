import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the Word Count application
 *
 */
public class WordCountTest {
    private Controller controller;

    /**
     * Empty test class constructor
     *
     */
    public WordCountTest() {
    }

    /**
     * Creates a new object of WordCount before every test
     *
     */
    @BeforeEach
    public void setup() {
        System.out.println("Creating a new word counter!");
        controller = new Controller();
    }

    /**
     * Prints "Running AfterEach" after every test is executed
     *
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Running AfterEach");
    }

    /**
     * Prints "STARTING TESTS" before any test is executed
     *
     */
    @BeforeAll
    public static void setUpClass() {
        System.out.println("STARTING TESTS");
    }

    /**
     * Prints "FINISHED ALL TESTS" after all tests are executed
     *
     */
    @AfterAll
    public static void tearDownClass() {
        System.out.println("FINISHED ALL TESTS");
    }

    /**
     * Tests the testRemovePunctuations() method
     *
     */
    @Test
    public void testRemovePunctuations() {
        // I except this "Hello, world!" to be returned as "Hello world"
        System.out.println("Testing removing punctuations");
        System.out.println();
        String input = "Hello, world!";
        String expectedOutput = "Hello world";
        String actualOutput = controller.removePunctuations(input);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests the testRemoveHyphens() method
     */
    @Test
    public void testRemoveHyphens() {
        // I except this "co-operate" to be returned as "cooperate"
        System.out.println("Testing removing hyphens");
        System.out.println();
        String input = "co-operate";
        String expectedOutput = "cooperate";
        String actualOutput = controller.removeHyphens(input);
        assertEquals(expectedOutput, actualOutput);
    }

    /*
         * Tests the getWordCount() method
         *
         *
    @Test
    public void testGetWordCount() throws Exception {
        String input = "The quick brown fox jumps over the lazy dog";
        Map<String, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put("the", 2);
        expectedOutput.put("quick", 1);
        expectedOutput.put("brown", 1);
        expectedOutput.put("fox", 1);
        expectedOutput.put("jumps", 1);
        expectedOutput.put("over", 1);
        expectedOutput.put("lazy", 1);
        expectedOutput.put("dog", 1);
        Map<String, Integer> actualOutput = wordCounter.getWordCount(input);
        assertEquals(expectedOutput, actualOutput);
    }
    */
}
