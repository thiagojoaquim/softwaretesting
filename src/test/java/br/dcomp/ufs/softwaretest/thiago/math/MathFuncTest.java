package br.dcomp.ufs.softwaretest.thiago.math;

import br.dcomp.ufs.softwaretest.thiago.math.exception.ExceptionMessages;
import br.dcomp.ufs.softwaretest.thiago.math.exception.FatorialNegativeNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

@DisplayName("Tests of math functions")
public class MathFuncTest {

    private Random random = new Random();

    @Test
    public void testSucessPositivePow() {
        Assertions.assertEquals(4, MathFunc.pow(2,2));
    }

    @Test
    public void testInfiniteResult() {
        int exponent = -random.nextInt(100);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, MathFunc.pow(0, exponent));
    }

    @Test
    public void testPositiveNumberPowOfZero() {
        int base = random.nextInt(100);
        Assertions.assertEquals(1, MathFunc.pow(base, 0));
    }

    @Test
    public void testZeroPowerOfPositiveNumber() {
        int exponent = random.nextInt(99) + 1;
        Assertions.assertEquals(0, MathFunc.pow(0, exponent));
    }

    @Test
    public void testFatorialNegativeNumber() {
        FatorialNegativeNumberException fatorialException = Assertions.assertThrows(FatorialNegativeNumberException.class,
                () -> MathFunc.fatorial(-10));
        Assertions.assertEquals(ExceptionMessages.FATORIAL_NEGATIVE_NUMBER.getMessage(), fatorialException.getMessage());
    }

    @Test
    public void testFatorialSuccess() {
        Assertions.assertEquals(120, MathFunc.fatorial(5));
    }

    @Test
    public void testFatorialZero() {
        Assertions.assertEquals(1, MathFunc.fatorial(0));
    }
}
