package pl.dolega;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class AppTest {

    private GraphCounter graphCounter;

    @BeforeEach
    public void setup() {
        graphCounter = new GraphCounter();
    }

    @Test
    public void graphCounterTest11() {
        graphCounter.run("2 1 2 2 3");
        assertEquals(1, graphCounter.numberOfGraphs);
    }

    @Test
    public void graphCounterTest12() {
        graphCounter.run("4 1 2 2 3 4 5 3 5");
        assertEquals(1, graphCounter.numberOfGraphs);
    }

    @Test
    public void graphCounterTest21() {
        graphCounter.run("2 1 2 3 4");
        assertEquals(2, graphCounter.numberOfGraphs);
    }

    @Test
    public void graphCounterTest22() {
        graphCounter.run("4 1 2 3 4 1 5 3 6");
        assertEquals(2, graphCounter.numberOfGraphs);
    }

    @Test
    public void graphCounterTest31() {
        graphCounter.run("3 1 2 3 4 5 6");
        assertEquals(3, graphCounter.numberOfGraphs);
    }

    @Test
    public void graphCounterTest32() {
        graphCounter.run("3 1 2 3 4 5 6 3 7 8 5 18 6");
        assertEquals(3, graphCounter.numberOfGraphs);
    }

    @Test
    public void graphCounterTest500() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(100000 + " ");
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i + " ");
        }
        String input = stringBuilder.toString().trim();
        graphCounter.run(input);
        assertEquals(50000, graphCounter.numberOfGraphs);
    }



}
