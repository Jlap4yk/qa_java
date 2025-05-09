package Com.example;

import com.example.Cat;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CatTest {

    private Predator predatorMock;
    private Cat cat;

    @Before
    public void setUp() {
        predatorMock = Mockito.mock(Predator.class);
        cat = new Cat(predatorMock);
    }

    @Test
    public void getSound_ReturnsMeow() {
        assertEquals("Должен вернуть 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void getFood_ReturnsPredatorFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);
        assertEquals("Должен вернуть еду хищника", expectedFood, cat.getFood());
    }

    @Test(expected = Exception.class)
    public void getFood_ThrowsException() throws Exception {
        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка"));
        cat.getFood();
    }
}