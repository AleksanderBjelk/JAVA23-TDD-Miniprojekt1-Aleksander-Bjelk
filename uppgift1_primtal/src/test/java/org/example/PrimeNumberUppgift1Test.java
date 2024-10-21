package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberUppgift1Test {

    //testar först med 10 för att det går att räkna i huvudet


    //2,3,5,7 (definitionsfråga med 1, men räknas inte som "unik")
    @Test
    @DisplayName("Test för antal primtal till 10")
    public void countPrimeNumbersToTen() {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();
        int result = counter.countPrimeNumbers(0, 10);

        assertEquals(4, result, "Det borde finnas 4 primtal mellan 0 och 10");
    }

    //2+3+5+7 = 17
    @Test
    @DisplayName("Test för summan av de 10 första primtalen")
    public void sumPrimeNumbersToTen() {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();
        int result = counter.sumPrimeNumbers(0, 10);

        assertEquals(17, result, "Summan av primtal mellan 0 och 10 borde vara 17");
    }

    @Test
    @DisplayName("Test för att få rätt utskrift till kosnolen av antalet primtal")
    public void countCorrectMessage() {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        counter.logPrimeNumbers(4);

        assertEquals("Hej, det finns 4 primtal mellan 0 och 1000!\n", outContent.toString());
    }

    @Test
    @DisplayName("Test för att få rätt utskrift av summan av primtalen")
    public void sumCorrectMessage() {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        counter.logSumPrimeNumbers(17);

        assertEquals("Och den totala summan av dessa primtal är 17.\n", outContent.toString());
    }


    //samma test för 0-1000
    @Test
    @DisplayName("Test för giltigt intervall 0-1000")
    public void validateIntervall() {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();

        assertTrue(counter.validateInput(0, 1000), "Intervallet 0 till 1000 borde vara giltigt.");
    }

    @Test
    @DisplayName("Test för negativt startvärde -1 - 1000")
    public void validateIntervallNotNegativeStartNumber() {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();

        assertFalse(counter.validateInput(-1, 1000), "Ett negativt startvärde borde vara ogiltigt.");
    }

    @Test
    @DisplayName("Test för ogiltligt slutvärde 0-123423")
    public void validateIntervallNotOverThousandEndNumber() {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();

        assertFalse(counter.validateInput(0, 123423), "Ett slutvärde över 1000 borde vara ogiltigt.");
    }

    @Test
    @DisplayName("Test för ett startvärde stööre än slutvärdet 2-1")
    public void validateIntervallStartNumberNotGreaterThanEndNumber() {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();

        assertFalse(counter.validateInput(2, 1), "Ett startvärde större än slutvärdet borde vara ogiltigt.");
    }

}