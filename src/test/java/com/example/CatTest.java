package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void checkGetSound() {
        Cat cat = new Cat(feline);
        String actualSound = "Мяу";
        assertEquals(cat.getSound(), actualSound);
    }

    @Test
    public void checkGetFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(actualFood, cat.getFood());
    }
}