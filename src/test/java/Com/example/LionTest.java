package Com.example;

import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    private Predator predatorMock;
    private final String sex;
    private final boolean expectedMane;

    public LionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Before
    public void setUp() {
        predatorMock = Mockito.mock(Predator.class);
    }

    @Test
    public void constructor_ValidSex_SetsManeCorrectly() throws Exception {
        Lion lion = new Lion(sex, predatorMock);
        assertEquals("Грива должна соответствовать полу", expectedMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void constructor_InvalidSex_ThrowsException() throws Exception {
        new Lion("Недопустимый", predatorMock);
    }

    @Test
    public void getKittens_ReturnsPredatorKittens() throws Exception {
        when(predatorMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", predatorMock);
        assertEquals("Должен вернуть количество котят от Predator", 3, lion.getKittens());
    }

    @Test
    public void getFood_ReturnsPredatorFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", predatorMock);
        assertEquals("Должен вернуть еду от Predator", expectedFood, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void getFood_ThrowsException() throws Exception {
        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка"));
        Lion lion = new Lion("Самка", predatorMock);
        lion.getFood();
    }
}