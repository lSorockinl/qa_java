package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void checkEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void checkGetFamily() {
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, feline.getFamily());
    }

    @Test
    public void checkGetKittens() {
        int expectedKittensCount = 1;
        assertEquals(expectedKittensCount, feline.getKittens());
    }

    @Test
    public void checkGetKittensNewValue() {
        int expectedKittensCount = 5;
        assertEquals(expectedKittensCount, feline.getKittens(5));
    }
}