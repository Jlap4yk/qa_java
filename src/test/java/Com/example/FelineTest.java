package Com.example;

import com.example.Feline;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void eatMeat_ReturnsPredatorFood() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals("Должен вернуть список еды для хищника", expected, feline.eatMeat());
    }

    @Test
    public void getFamily_ReturnsFelineFamily() {
        assertEquals("Должен вернуть семейство кошачьих", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgs_ReturnsOneKitten() {
        assertEquals("Должен вернуть 1 котенка по умолчанию", 1, feline.getKittens());
    }
}