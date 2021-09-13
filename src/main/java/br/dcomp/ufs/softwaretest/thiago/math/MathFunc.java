package br.dcomp.ufs.softwaretest.thiago.math;

import br.dcomp.ufs.softwaretest.thiago.math.exception.FatorialNegativeNumberException;

public class MathFunc {

    public static double pow(int base, int expoent) {
        double result = 1;
        int p = expoent < 0 ? -expoent : expoent;
        while (p != 0) {
            result *= base;
            p--;
        }
        return expoent < 0 ? (1 / result) : result;
    }

    public static long fatorial(int number) {
        if (number < 0) {
            throw new FatorialNegativeNumberException();
        }
        long result = 1;
        for (int i = number; i >= 1; i--) {
            result *= i;
        }
        return result;
    }
}
