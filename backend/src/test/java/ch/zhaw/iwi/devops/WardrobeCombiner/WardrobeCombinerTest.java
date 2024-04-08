package ch.zhaw.iwi.devops.WardrobeCombiner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

import java.io.*;

public class WardrobeCombinerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMain() {
        String input = "200\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] args = {};
        WardrobeCombiner.main(args);

        // Verify the output
        String[] lines = outContent.toString().split(System.lineSeparator());
        assertTrue(lines[0].contains("Enter the target size for the wardrobe (in cm):"));
        // Add more assertions based on your expected output
    }

    @Test
    public void test250cm() {
        WardrobeCombiner wardrobeCombiner = new WardrobeCombiner(250);
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> actualCombinations = wardrobeCombiner.findCombinations(sizes);
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 50, 50, 50, 50),
            Arrays.asList(50, 50, 50, 100),
            Arrays.asList(50, 50, 75, 75),
            Arrays.asList(50, 100, 100),
            Arrays.asList(75, 75, 100)
        );
        assertEquals(expectedCombinations, actualCombinations);
    }

    @Test
    public void test300cm() {
        WardrobeCombiner wardrobeCombiner = new WardrobeCombiner(300);
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> actualCombinations = wardrobeCombiner.findCombinations(sizes);
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 50, 50, 50, 50, 50),
            Arrays.asList(50, 50, 50, 50, 100),
            Arrays.asList(50, 50, 50, 75, 75),
            Arrays.asList(50, 50, 100, 100),
            Arrays.asList(50, 75, 75, 100),
            Arrays.asList(75, 75,75,75),
            Arrays.asList(100, 100, 100)
        );
        assertEquals(expectedCombinations, actualCombinations);
    }

    @Test
    public void test100cm() {
        WardrobeCombiner wardrobeCombiner = new WardrobeCombiner(100);
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> actualCombinations = wardrobeCombiner.findCombinations(sizes);
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 50),
            Arrays.asList(100)
        );
        assertEquals(expectedCombinations, actualCombinations);
    }
    @Test
    public void test50cm() {
        WardrobeCombiner wardrobeCombiner = new WardrobeCombiner(50);
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> actualCombinations = wardrobeCombiner.findCombinations(sizes);
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50)

        );
        assertEquals(expectedCombinations, actualCombinations);
    }
}