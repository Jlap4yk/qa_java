package Com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionSimpleTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test(expected = Exception.class)
    public void constructor_InvalidSex_ThrowsException() throws Exception {
        new Lion("Недопустимый", felineMock);
    }

    @Test
    public void getKittens_ReturnsPredatorKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(1); // Changed from 3 to 1
        Lion lion = new Lion("Самец", felineMock);
        assertEquals("Должен вернуть количество котят от Feline", 1, lion.getKittens());
    }

    @Test
    public void getFood_ReturnsPredatorFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", felineMock);
        assertEquals("Должен вернуть еду от Feline", expectedFood, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void getFood_ThrowsException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));
        Lion lion = new Lion("Самка", felineMock);
        lion.getFood();
    }
}