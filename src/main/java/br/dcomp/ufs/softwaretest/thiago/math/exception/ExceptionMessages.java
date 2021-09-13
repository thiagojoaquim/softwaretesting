package br.dcomp.ufs.softwaretest.thiago.math.exception;

public enum ExceptionMessages {

    FATORIAL_NEGATIVE_NUMBER("Negative number factorial does not exist");

    private String message;

    private ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
