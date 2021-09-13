package br.dcomp.ufs.softwaretest.thiago.credit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditTest {

    private final double CREDIT_EXPECTED = 20000;
    private final int LIMIT_PARCELS = 12;
    private final double SALARY_FLOOR = 5000;



    private Credit targetTest = new Credit();

    @Test
    void testDefineCreditSucess() {
       double creditReceived = targetTest.defineCredit(10, true, 8500);
        Assertions.assertEquals(CREDIT_EXPECTED, creditReceived);
    }

    @Test
    void testDefineCreditParcelsBigThanLimit() {
        Assertions.assertEquals(0, targetTest.defineCredit(LIMIT_PARCELS + 1, true, 8500));
    }

    @Test
    void testDefineCreditSalaryBelowFloor() {
        Assertions.assertEquals(0, targetTest.defineCredit(10, true, SALARY_FLOOR - 1));
    }

    @Test
    void testDefineCreditNotReliableClient() {
        Assertions.assertEquals(0, targetTest.defineCredit(10, false, 8500));
    }


}
