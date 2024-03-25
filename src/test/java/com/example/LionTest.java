package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    String SEX = "Неизвестно";
    private final String lionSex;
    private final boolean expectedMane;

    @Mock
    Feline feline;

    public LionTest(String lionSex, boolean actualMane) {
        this.lionSex = lionSex;
        this.expectedMane = actualMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestValues() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkLionSexExceptionThrow() throws Exception {
        Assert.assertThrows(Exception.class, () -> new Lion(SEX, feline));
    }

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittensCount = 1;
        assertEquals(expectedKittensCount, lion.getKittens());
    }

    @Test
    public void checkDoesHaveMane() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    public void checkGetFood() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }
}