package Com.example;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final Feline feline = new Feline();
    private final int kittensCount;
    private final int expectedKittens;

    public FelineParameterizedTest(int kittensCount, int expectedKittens) {
        this.kittensCount = kittensCount;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5},
                {10, 10}
        });
    }

    @Test
    public void getKittensWithArgs_ReturnsSpecifiedCount() {
        assertEquals("Должен вернуть указанное количество котят", expectedKittens, feline.getKittens(kittensCount));
    }
}