package br.dcomp.ufs.softwaretest.thiago.math.exception;

public class FatorialNegativeNumberException extends RuntimeException {

    public FatorialNegativeNumberException() {
        super(ExceptionMessages.FATORIAL_NEGATIVE_NUMBER.getMessage());
    }

}
